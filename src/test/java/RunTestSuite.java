import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        monochrome = true,
        glue = {"cucumber.test.steps"},
        features = {"src/test/resources/features/"})
public class RunTestSuite {
}
