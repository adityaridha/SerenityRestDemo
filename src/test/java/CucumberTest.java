import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@positive",
        plugin = {"pretty", "html:report-cucumber.html", "json:cucumber-json.json"}
)
public class CucumberTest {}