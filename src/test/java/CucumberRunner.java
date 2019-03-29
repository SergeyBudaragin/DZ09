import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"DZ09.steps"},
        tags = {"@all"},
        plugin = {"DZ09.AllureListener"})
public class CucumberRunner {
}
