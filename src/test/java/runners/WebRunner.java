package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/web")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:build/reports/cucumber/web.html, json:build/reports/cucumber/web.json")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions.web,hooks")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
public class WebRunner {
}
