package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:features"},
        glue = {"starter.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        tags = "@CatalogoLibros"
)
public class CucumberTestSuite {
}
