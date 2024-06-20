package sistema.suiteteste;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:transacoes",
        glue = {"sistema.amplis.transacoes","sistema/servicos/cucumber"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = ("@operacaoTermo")

)
public class SuiteTesteCucumber {
}