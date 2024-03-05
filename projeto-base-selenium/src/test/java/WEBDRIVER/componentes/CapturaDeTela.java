package WEBDRIVER.componentes;


import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.adicionarLog;
import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class CapturaDeTela {

    private List<String> caminhosDasImagens = new ArrayList<>();

    public void capturaTela(String nomeDoArquivo, String nomeDoTeste) {
        try {
            WebDriver driver = getDriver();
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot capturaTela = (TakesScreenshot) driver;
                File fonte = capturaTela.getScreenshotAs(OutputType.FILE);
                String diretorioDestino = "target/evidencias/" + nomeDoArquivo + "/";

                File diretorio = new File(diretorioDestino);
//                if (!diretorio.exists()) {
                    diretorio.mkdirs();
//                }

                File destino = new File(diretorioDestino + nomeDoTeste + ".jpg");
                FileUtils.copyFile(fonte, destino);
                String caminhoDaImagem = destino.getAbsolutePath().replace("\\", "/");
                caminhosDasImagens.add(caminhoDaImagem);
            }

            adicionarImagensAoRelatorio(nomeDoArquivo, nomeDoTeste);
        } catch (Exception e) {
            adicionarLog("Erro durante a execução do Teste " + e.getMessage());
        }
    }

    private void adicionarImagensAoRelatorio(String nomeDoArquivo, String nomeDoTeste) {
        StringBuilder mensagemFinal = new StringBuilder();
        for (String caminhoDaImagem : caminhosDasImagens) {
            String caminhoRelativo = "target/evidencias/" + nomeDoArquivo + "/" + nomeDoTeste + ".jpg";
            mensagemFinal.append("<img src='" + caminhoRelativo + "' width='350px' height='200px' /><br><br>");
        }
        adicionarLog(mensagemFinal.toString());
    }


    @Rule
    public static TestName testName = new TestName();

    public void evidencias() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        BufferedImage image = robot.createScreenCapture(new Rectangle(1230, 550));
        try {
            ImageIO.write(image, "jpg", new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Rule
    public static TestName nomeTeste = new TestName();

    public static void capturaScreenshot() {
        try {
            File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshotFile, new File("target" + File.separator + "screenshot" + File.separator + nomeTeste.getMethodName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





