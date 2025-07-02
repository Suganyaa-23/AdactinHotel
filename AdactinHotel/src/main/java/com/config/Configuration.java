package com.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({ "system:properties", "classpath:local.properties", "classpath:app.properties",
		"classpath:report.properties" })

public interface Configuration extends Config {
	@Key("browser")
	String browser();

	@Key("headless")
	Boolean headless();

	@Key("max.retry")
	int maxRetry();

	@Key("url.base")
	String baseUrl();

	@Key("target")
	String target();

	@Key("timeout")
	int timeout();

	@Key("report.title")
	String reportTitle();

	@Key("report.name")
	String reportName();

	@Key("report.theme")
	String reportTheme();
}
