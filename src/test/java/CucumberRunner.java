import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = {"DZ08.steps"},
        tags = {"@all"},
        plugin = {"DZ08.helpers.Allure"}

)
public class CucumberRunner {
}
