package servico.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

import org.testng.annotations.AfterClass;
import servico.utils.DescricaoCenario;
import webdriver.componentes.Espera;
import webdriver.componentes.Evidencia;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static servico.leitorDeArquivo.LeitorPropriedade.*;
import static webdriver.componentes.Evidencia.flushReports;
import static webdriver.componentes.Evidencia.logInfo;
import static webdriver.fabrica.FabricaDeDriver.fecharBrowser;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class BaseTeste {
    @Before
    public void inicializar() {
        Evidencia.iniciarTeste(getDescricaoCenario().toString());
        WebDriverManager.chromedriver().setup();
        logInfo("URL: " + getUrl());

        String url = getUrl();
        String login = getLogin();
        String senha = getSenha();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.propriedades não foram configuradas corretamente.");
        }
        getDriver().get(url);
//        new PaginaLogin().executarLogin(login, senha);
//        new Espera().esperaPor(2500);
    }

    public List<String> getDescricaoCenario() {
        List<String> descricoes = new ArrayList<>();
        for (Method method : this.getClass().getMethods()) {
            if (method.isAnnotationPresent(DescricaoCenario.class) && method.getName().startsWith("test") && method.getParameterCount() == 0) {
                DescricaoCenario descricao = method.getAnnotation(DescricaoCenario.class);
                descricoes.add(descricao.value());
            }
        }
        return descricoes;
    }


    @AfterClass
    public static void finalizar() {
        flushReports();
        fecharBrowser();
    }


}