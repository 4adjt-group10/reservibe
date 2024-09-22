package com.reservibe.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/restaurant.feature",
        glue = "com.reservibe.bdd",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTest {
}
