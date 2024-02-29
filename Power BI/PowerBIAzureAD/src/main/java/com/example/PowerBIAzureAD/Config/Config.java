package com.example.PowerBIAzureAD.Config;

public abstract class Config {
	// Set this to true, to show debug statements in console
	public static final boolean DEBUG = true;

	//	Two possible Authentication methods: 
	//	- For authentication with master user credential choose MasterUser as AuthenticationType.
	//	- For authentication with app secret choose ServicePrincipal as AuthenticationType.
	//	More details here: https://aka.ms/EmbedServicePrincipal
	public static final String authenticationType = "MasterUser";

	//	Common configuration properties for both authentication types
	// Enter workspaceId / groupId
	public static final String workspaceId = "97ffae55-231e-4f35-927e-3ddfb073d330";

	// The id of the report to embed.
	public static final String reportId = "03672450-1010-40eb-9595-b487d01cb774";

	// Enter Application Id / Client Id
	public static final String clientId = "b9a58cbe-d582-4829-b98b-615dddbbb32a";

	// Enter MasterUser credentials
	public static final String pbiUsername = "effigodev@effigoglobal.com";
	public static final String pbiPassword = "SORGaBdM6zp9q36";

	// Enter ServicePrincipal credentials
	public static final String tenantId = "";
	public static final String appSecret = "";

	//	DO NOT CHANGE
	public static final String authorityUrl = "https://login.microsoftonline.com/";
	public static final String scopeBase = "https://analysis.windows.net/powerbi/api/.default";

	private Config() {
		//Private Constructor will prevent the instantiation of this class directly
		throw new IllegalStateException("Config class");
	}

}
