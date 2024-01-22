package WEBDRIVER.base.baseTest;

import WEBDRIVER.componentes.Espera;
import WEBDRIVER.config.menu.propriedades.LoginAmplisPage;
import SISTEMA.propriedades.utils.ConfigReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;


import static WEBDRIVER.fabrica.FabricaDeDriver.finalizarDriver;
import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BaseTest {
    //region

    private static final String CAMINHO_DRIVER = "C:\\Users\\felipem.medeiros\\Documents\\02-cursos\\SELENIUM\\base-selenio\\projeto-base-selenium\\src\\main\\resources\\drivers\\chromedriver-120.0.6099.109.exe";

    //endregion
    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        String url = ConfigReader.getUrl();
        String email = ConfigReader.getEmail();
        String senha = ConfigReader.getSenha();

        if (url == null || email == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.properties não foram configuradas corretamente.");
        }
        getDriver().get(url);
        new LoginAmplisPage().executarLogin(email,senha);
        new Espera().esperaPor(3000);
    }

    @AfterClass
    public static void finalizar() {
        finalizarDriver();

    }
}






























































































































































