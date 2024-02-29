package com.example.PowerBIAzureAD.Models;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.PowerBIAzureAD.Controllers.EmbedController;

public class ReportConfig {
	static final Logger logger = LoggerFactory.getLogger(EmbedController.class);

	public String reportId = "";

	public String embedUrl = "";

	public String reportName = "";

	public Boolean isEffectiveIdentityRolesRequired = false;

	public Boolean isEffectiveIdentityRequired = false;

	public Boolean enableRLS = false;

	public String username;

	public String roles;

	public JSONObject getJSONObject() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("reportId", reportId);
			jsonObj.put("embedUrl", embedUrl);
			jsonObj.put("reportName", reportName);
		} catch (JSONException e) {
			logger.error("DefaultListItem.toString JSONException: " + e.getMessage());
		}
		return jsonObj;
	}
}