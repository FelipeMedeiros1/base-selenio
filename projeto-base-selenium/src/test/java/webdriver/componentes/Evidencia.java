package webdriver.componentes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import servico.utils.LogUtil;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Evidencia {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final String diretorioDestino = "C:/TEMP/Reports/teste/";
    private static final String diretorioImagens = diretorioDestino + "screenshots";
    private static final String timestamp = new SimpleDateFormat("dd_MM_yy_HHmm").format(new Date());


    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    private static ExtentReports inicializarReports() {
        if (extent == null) {

            new File(diretorioDestino).mkdirs();
            new File(diretorioImagens).mkdirs();

            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                    diretorioDestino + "nome_do_projeto_" + timestamp + ".html");
            htmlReporter.config().setDocumentTitle("Relatório de Testes Automatizados");
            htmlReporter.config().setReportName("Resultados dos Testes");
            htmlReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", "Test Automation Specialist");
        }
        return extent;
    }

    public static ExtentTest iniciarTeste( String descricao) {
        ExtentTest test = inicializarReports().createTest(descricao);
        extentTestThreadLocal.set(test);
        return test;
    }

    private static ExtentTest getTeste() {
        return extentTestThreadLocal.get();
    }

    private static Media adicionarImagem(String titulo) {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            String screenshotPath = diretorioImagens + "/" + titulo + "_" + getUrl() + "_" + timestamp + ".png";
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);

            // Cria o objeto MediaEntityBuilder com a imagem
            return MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void capturaTelaSucesso(String titulo, String mensagem) {
        LogUtil.info(mensagem);
        getTeste().pass(mensagem, adicionarImagem(titulo));
    }

    public static void capturaTelaInfo(String titulo, String mensagem) {
        LogUtil.info(mensagem);
        getTeste().info(mensagem, adicionarImagem(titulo));
    }

    public static void capituraTelaFalha(String titulo, String mensagem) {
        LogUtil.error(mensagem);
        getTeste().fail(mensagem, adicionarImagem(titulo));

    }

    public static void logAlerta(String titulo, String mensagem) {
        LogUtil.warn(mensagem);
        getTeste().warning(mensagem, adicionarImagem(titulo));
    }

    public static void logSucesso(String mensagem) {
        LogUtil.info(mensagem);
        getTeste().pass(mensagem);
    }
    public static void logInfo(String mensagem) {
        LogUtil.info(mensagem);
        getTeste().info(mensagem);
    }

    public static void logFalha(String mensagem) {
        LogUtil.error(mensagem);
        getTeste().fail(mensagem);
    }

    public static void logAlerta(String mensagem) {
        LogUtil.warn(mensagem);
        getTeste().warning(mensagem);
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }


    public static String getUrl() {
        String url = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return window.location.href;");
        String[] segmentos = url.split("/");
        String ultimoSegmento = segmentos[segmentos.length - 1];
        return ultimoSegmento.split("\\.")[0];
    }


}