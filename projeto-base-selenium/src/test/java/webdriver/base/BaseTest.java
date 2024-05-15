package webdriver.base;

import webdriver.componentes.Espera;
import webdriver.pages.login.LoginPage;
import sistema.servicos.utils.LeitorConfiguracao;
import org.junit.AfterClass;
import org.junit.BeforeClass;


import static webdriver.fabrica.FabricaDeDriver.finalizarDriver;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public abstract class BaseTest {
    private static final String CAMINHO_DRIVER = "src/test/resources/drivers/chromedriverV124.exe";

    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        String url = LeitorConfiguracao.getUrl();
        String login = LeitorConfiguracao.getEmail();
        String senha = LeitorConfiguracao.getSenha();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.properties não foram configuradas corretamente.");
        }
        getDriver().get(url);
        new LoginPage().executarLogin(login,senha);
        new Espera().esperaPor(3000);

    }

    @AfterClass
    public static void finalizar() {
        finalizarDriver();

    }
}






























































































































































