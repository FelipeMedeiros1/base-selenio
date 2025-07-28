package test.java.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;


import test.java.utils.DescricaoCenario;
import test.java.webdriver.componentes.Evidencia;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static test.java.utils.leitorDeArquivo.LeitorPropriedade.*;
import static test.java.webdriver.componentes.Evidencia.flushReports;
import static test.java.webdriver.componentes.Evidencia.logInfo;
import static test.java.webdriver.fabrica.FabricaDeDriver.fecharBrowser;
import static test.java.webdriver.fabrica.FabricaDeDriver.getDriver;

public class BaseTeste {
    @Before
    public void inicializar() {
        Evidencia.iniciarTeste(getDescricaoCenario().toString());
        WebDriverManager.chromedriver().setup();
        logInfo("URL: " + getUrl());

        getDriver().get(getUrl());
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