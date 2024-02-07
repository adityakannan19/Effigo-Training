package com.example.finalProject.util;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class DateTimeFormatter {
	public static String formatTimestamp(Timestamp timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		return dateFormat.format(timestamp);
	}
}
