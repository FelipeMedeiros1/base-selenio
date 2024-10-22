package sistema.servicos.base;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import sistema.amplis.login.PaginaLogin;
import sistema.servicos.utils.LogUtil;
import webdriver.componentes.Espera;

import static sistema.servicos.leitorDeArquivo.LeitorPropriedade.*;
import static sistema.servicos.utils.LogUtil.info;
import static webdriver.componentes.Evidencia.liberarRelatorio;
import static webdriver.fabrica.FabricaDeDriver.fecharBrowser;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class BaseCucumber {
    @Before
    public void beforeScenario(Scenario scenario) {
        info("Cenário: " + scenario.getName());
    }

    @BeforeAll
    public static void inicializar() {
        WebDriverManager.chromedriver().setup();
        info("Acessando o sistema pela url: " + getUrl());
        String url = getUrl();
        String login = getLogin();
        String senha = getSenha();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.propriedades não foram configuradas corretamente.");
        }
        getDriver().get(url);
        new PaginaLogin().executarLogin(login, senha);
        new Espera().esperaPor(2500);

    }

    @AfterAll
    public static void finalizar() {
        fecharBrowser();

    }
}