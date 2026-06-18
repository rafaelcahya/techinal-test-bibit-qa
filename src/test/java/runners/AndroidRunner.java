package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/android")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:build/reports/cucumber/android.html, json:build/reports/cucumber/android.json")
@ConfigurationParameter(key = "cucumber.glue", value = "stepDefinitions.android,hooks")
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@login or @buy or @sort")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
public class AndroidRunner {
}
