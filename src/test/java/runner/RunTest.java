package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//CUCUMBER_PUBLISH_TOKEN=e839023b-0fde-4113-bd2b-0347160a6d7b
@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features/amazon_ui",//to tell cucumber where is ur feature file
        glue="stepdefs", // to tell cucumber where is ur step def code
        tags="@tag1", // to tell which tagged feature file to execute
        plugin = {"pretty", // to generate reports
            "html:target/html/htmlreport.html",
            "json:target/json/file.json",
            },
        monochrome =true,// generate report in readable format
        dryRun=false // to tell whether to test run(true) or actual run(false)
        )

public class RunTest {
    //Class will be Empty.
    //Nothing goes here
    //So do not get confused
}
