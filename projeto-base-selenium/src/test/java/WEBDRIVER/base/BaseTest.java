package WEBDRIVER.base;

import WEBDRIVER.componentes.Espera;
import WEBDRIVER.pageObject.login.LoginPage;
import SISTEMA.config.servicos.utils.ConfigReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;


import static WEBDRIVER.fabrica.FabricaDeDriver.finalizarDriver;
import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BaseTest {
    private static final String CAMINHO_DRIVER = "src/main/resources/drivers/chromedriverV124.exe";

    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        String url = ConfigReader.getUrl();
        String login = ConfigReader.getEmail();
        String senha = ConfigReader.getSenha();

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






























































































































































