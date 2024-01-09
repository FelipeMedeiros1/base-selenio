package WEBDRIVER.base.baseTest;

import WEBDRIVER.componentes.Espera;
import WEBDRIVER.config.menu.propriedades.LoginAmplisPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static WEBDRIVER.fabrica.FabricaDeDriver.finalizarDriver;
import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BaseTest {
    //region

    private static final String CAMINHO_DRIVER = "src/resources/drivers/chromedriver-120.0.6099.109.exe";

    private static final String URL_BASE_02 = "https://funcional-ath-congelada.totvs.amplis.com.br/amplis/login/SEC_00001.jsf";
    private static final String EMAIL_02 = "robo.ath@totvs.com.br";
    private static final String SENHA_02 = "@123456Robo";
    private static final String URL_BASE_01 = "https://funcional-ath.totvs.amplis.com.br/amplis/login/SEC_00001.jsf";
    private static final String EMAIL_01 = "robo.ath@totvs.com.br";
    private static final String SENHA_01 = "@123456Robo";
    //endregion
    @BeforeClass
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        getDriver().get(URL_BASE_01);
        new LoginAmplisPage().executarLogin(EMAIL_01,SENHA_01);
        new Espera().esperaPor(3000);
    }
    @Rule
    public TestName testName = new TestName();
//    @After
    public void evidencia() {
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
    @AfterClass
    public static void finalizar() {
        finalizarDriver();

    }
}






























































































































































