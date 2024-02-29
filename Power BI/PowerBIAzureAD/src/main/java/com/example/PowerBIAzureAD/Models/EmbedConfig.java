package com.example.PowerBIAzureAD.Models;

import java.util.List;

/**
* Properties for embedding the report 
*/
public class EmbedConfig {
	public List<ReportConfig> embedReports;

	public EmbedToken embedToken;

	public String errorMessage;
}