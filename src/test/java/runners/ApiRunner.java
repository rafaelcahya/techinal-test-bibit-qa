package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:build/reports/cucumber/api.html, json:build/reports/cucumber/api.json")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions.api,hooks")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
public class ApiRunner {
}
