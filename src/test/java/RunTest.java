import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/features/quickBook.feature"},
        //tags="@testBook",
        //plugin = {"pretty","html:target/tsr/tsr.html"},
        dryRun =!true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)





public class RunTest {

}
