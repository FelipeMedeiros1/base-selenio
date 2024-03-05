package SISTEMA.config.servicos.utils;

import WEBDRIVER.componentes.CapturaDeTela;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class RelatorioEvidenciaDeTeste {
    private static ExtentReports extent;
    public static ExtentTest test;
    private static WebDriver driver = getDriver();
    private static ExtentHtmlReporter htmlReporter;

    private static List<String> mensagens = new ArrayList<>();

    public static void evidencia(String nomeDoArquivoHtml, String nomeDoTeste) {
        iniciarRelatorio(nomeDoArquivoHtml);
        iniciarTeste("Teste: " + nomeDoArquivoHtml);
        adicionarLog(nomeDoTeste);
        capturaTela(nomeDoArquivoHtml, nomeDoTeste);
        finalizarTeste();
    }

    public static void iniciarRelatorio(String nomeDoArquivo) {
        String caminhoRelatorio = "target" + File.separator + "evidencias" + File.separator + nomeDoArquivo + ".html";
        if (htmlReporter == null) {
            htmlReporter = new ExtentHtmlReporter(caminhoRelatorio);
        }
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void iniciarTeste(String nomeDoTeste) {
        test = extent.createTest(nomeDoTeste);
    }

    public static void adicionarLog(String mensagem) {
        mensagens.add(mensagem);
        StringBuilder mensagemFinal = new StringBuilder();
        for (String msg : mensagens) {
            mensagemFinal.append(msg).append("<br>");
        }
        test.info(mensagemFinal.toString());

    }

    public static void adicionarLogDeFalha(String nomeDoArquivo) {
        capturaTela(nomeDoArquivo, "Teste-falhou");
        test.fail("Erro durante a execução do Teste");
        finalizarTeste();
    }

    public static void finalizarTeste() {
        extent.flush();
    }

    public static void capturaTela(String nomeDoArquivo, String nomeDoTeste) {
        new CapturaDeTela().capturaTela(nomeDoArquivo, nomeDoTeste);
    }
}



