package sistema.suite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:sistema/transacoes",
        glue = {"sistema", "sistema.servico.base" },
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        tags = ("@OperacoesDefinitiva")

)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutorCucumber {
}
