package stigbd.clubmemberservice.rest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:MemberAPI.feature")
public class RunCukesTestIT {
}