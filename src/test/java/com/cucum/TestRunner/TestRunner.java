package com.cucum.TestRunner;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/cucum/features",
plugin= {"com.aventstack.extentreports.offline.commons.css.icons.material"},
glue= {"com.cucum.stepDefinitions"},
monochrome=true
)
public class TestRunner {
	public static String env = System.getenv("ENV");
	public static File temp = new File("resources/temp.xml");
	
	@BeforeClass
	public static void setup() {
		String reportFilePath;
		String something;
	}

}
