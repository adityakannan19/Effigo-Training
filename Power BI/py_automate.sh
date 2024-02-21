#!/bin/bash

# Read database credentials from environment variables
DB_HOST="localhost"
DB_PORT="5432"
DB_NAME="powerbi_test_db"
DB_USER="postgres"
DB_PASSWORD="sillicon"

# Validate required variables
if [[ -z "$DB_HOST" || -z "$DB_PORT" || -z "$DB_NAME" || -z "$DB_USER" || -z "$DB_PASSWORD" ]]; then
  echo "Error: Missing required environment variables for database access."
  exit 1
fi

# CSV file path
CSV_FILE="D:/data/category_lookup.csv"

# Get column names from the first row of the CSV file
CSV_HEADER=$(head -n 1 "$CSV_FILE")
COLUMN_NAMES=$(echo "$CSV_HEADER" | sed 's/,/ TEXT,/g; s/$/ TEXT/')
TABLE_SCHEMA="($COLUMN_NAMES)"

# Extract table name from CSV file name
TABLE_NAME=$(basename "$CSV_FILE" .csv)

# SQL command to create table
CREATE_TABLE_COMMAND="CREATE TABLE IF NOT EXISTS $TABLE_NAME $TABLE_SCHEMA"
IMPORT_COMMAND="COPY $TABLE_NAME FROM '$CSV_FILE' WITH (FORMAT csv, HEADER true)"


# Set PGPASSWORD environment variable
export PGPASSWORD="$DB_PASSWORD"

# Connect to PostgreSQL and execute create table command
psql -h "$DB_HOST" -p "$DB_PORT" -d "$DB_NAME" -U "$DB_USER" -c "$CREATE_TABLE_COMMAND" || { echo "Error creating table $TABLE_NAME. Check CSV format and data types."; exit 1; }
psql -h "$DB_HOST" -p "$DB_PORT" -d "$DB_NAME" -U "$DB_USER" -c "$IMPORT_COMMAND" || { echo "Error importing data to $TABLE_NAME. Check CSV format and data integrity."; exit 1; }


echo "Table $TABLE_NAME created successfully based on CSV file structure."
