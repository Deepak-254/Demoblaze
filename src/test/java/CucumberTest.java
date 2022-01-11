import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "src/main/java/master/stepDefs",
        monochrome = false, tags = "@Test",
        plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber-son/cucumber.json",
                "junit:cucumber-junit-report.xml"})
public class CucumberTest {

    @BeforeClass
    public static void setup(){}

    @AfterClass
    public static void destroy(){}
}
