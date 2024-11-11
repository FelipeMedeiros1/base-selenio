package suiteDeTeste;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runners.MethodSorters;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:sistema/amplis/transacoes",
        glue = {"sistema.amplis", "servico.base" },
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        tags = ("@moedas")

)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutorCucumber {
}