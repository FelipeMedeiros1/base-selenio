package webdriver.base;

import webdriver.componentes.Espera;
import sistema.servicos.leitorDeArquivo.LeitorPropriedade;
import org.junit.AfterClass;
import org.junit.BeforeClass;


import static webdriver.fabrica.FabricaDeDriver.finalizarDriver;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public abstract class BaseTeste {
    private static final String CAMINHO_DRIVER = "src/test/resources/drivers/chromedriverV124.exe";

    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        String url = LeitorPropriedade.getUrl();
        String login = LeitorPropriedade.getLogin();
        String senha = LeitorPropriedade.getSenha();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.propriedades não foram configuradas corretamente.");
        }
        getDriver().get(url);
        new PaginaLogin().executarLogin(login,senha);
        new Espera().esperaPor(3000);

    }

//    @AfterClass
    public static void finalizar() {
        finalizarDriver();

    }
}