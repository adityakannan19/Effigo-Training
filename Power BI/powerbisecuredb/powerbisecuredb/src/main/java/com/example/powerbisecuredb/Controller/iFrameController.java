package com.example.powerbisecuredb.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class iFrameController {

	@Value("${powerbi.iframe}")
	private String iframeString;

	@GetMapping("/get-iframe")
	@ResponseBody
	public String getIframeString() {
		return iframeString;
	}
}
