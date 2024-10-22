package sistema.servicos.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import sistema.amplis.login.PaginaLogin;
import webdriver.componentes.Espera;


import static sistema.servicos.leitorDeArquivo.LeitorPropriedade.*;
import static sistema.servicos.utils.LogUtil.info;
import static webdriver.fabrica.FabricaDeDriver.fecharBrowser;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class BaseTeste {
    @BeforeClass
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

//    @AfterClass
    public static void finalizar() {
        fecharBrowser();
    }
}