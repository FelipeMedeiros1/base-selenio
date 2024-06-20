package sistema.servicos.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import webdriver.base.PaginaLogin;
import webdriver.componentes.Espera;
import sistema.servicos.leitorDeArquivo.LeitorPropriedade;

import static webdriver.fabrica.FabricaDeDriver.finalizarDriver;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class ConfiguracaoCucumber {
    private static final String CAMINHO_DRIVER = "src/test/resources/drivers/chromedriverV124.exe";

    @Before
    public void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        String url = LeitorPropriedade.getUrl();
        String login = LeitorPropriedade.getLogin();
        String senha = LeitorPropriedade.getSenha();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.propriedades não foram configuradas corretamente.");
        }
        getDriver().get(url);
        new PaginaLogin().executarLogin(login, senha);
        new Espera().esperaPor(3000);
    }

    @After
    public void finalizar() {
        finalizarDriver();
    }
}


