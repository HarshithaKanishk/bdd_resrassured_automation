package com.example.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.api.runner.stepdefinitions",
    plugin = {
        "pretty",
        "html:target/test-report.html",
        "json:target/test-report.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}