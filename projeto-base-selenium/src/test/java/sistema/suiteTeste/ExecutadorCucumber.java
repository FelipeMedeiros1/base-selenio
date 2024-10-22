package sistema.suiteTeste;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:sistema/amplis/transacoes",
        glue = {"sistema.amplis.transacoes", "sistema.servicos.base" },
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        tags = ("@moedas")

)
public class ExecutadorCucumber {
}