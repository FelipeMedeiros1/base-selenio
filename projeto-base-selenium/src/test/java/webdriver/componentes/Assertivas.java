package webdriver.componentes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

/**
 * Classe utilitária para realizar asserções em testes automatizados.
 * <p>
 * Fornece métodos para comparar valores esperados com valores reais,
 * exibindo mensagens personalizadas em caso de falha.
 */
public class Assertivas {


    private static String PASSOU = "<font class=\"status pass\">O resultado da comparação de valores.\r\n<br><b>Esperado: xxx \r\n<br>Atual: yyy</b>\r\n<br>Estão corretos.</font>";
    private static String FALHOU = "<font class=\"status fail\">O resultado da comparação de valores.\r\n<br><b>Esperado: xxx \r\n<br>Atual: yyy</b>\r\n<br>Estão incorretos.</font>";

    /**
     * Obtém o texto de um elemento localizado por um seletor By.
     *
     * @param by O seletor By para localizar o elemento.
     * @return O texto do elemento.
     */
    public static String obterMensagemAtual(By by) {
        return getDriver().findElement(by).getText();
    }


   /* public static final void assertiva(String esperado, String atual) {
        Assert.assertEquals(esperado, obterMensagemAtual(atual));
    }*/

    /*public static final void assertiva(String esperado, WebElement atual) {
        Assert.assertEquals(esperado, obterMensagemAtual(atual));
    }*/

    /**
     * Obtém o texto de um WebElement.
     *
     * @param elemento O WebElement.
     * @return O texto do elemento.
     */
    public static String obterMensagemAtual(WebElement elemento) {
        return elemento.getText();
    }

    /**
     * Obtém o texto de um elemento por ID.
     *
     * @param id O ID do elemento.
     * @return O texto do elemento.
     */
    public static String obterMensagemAtual(String id) {
        return obterMensagemAtual(By.id(id));
    }

    /**
     * Realiza uma asserção entre um valor esperado e um valor atual,
     * exibindo mensagens personalizadas em caso de falha.
     *
     * @param esperado O valor esperado.
     * @param atual    O valor atual.
     */
    public static final void assertiva(String esperado, String atual) {
        try {
            Assert.assertEquals(esperado, obterMensagemAtual(atual));
            System.out.println(montaTexto(PASSOU, esperado, atual));
        } catch (AssertionError e) {
            System.out.println(montaTexto(FALHOU, esperado, atual));
            throw e;
        }
    }

    /**
     * Realiza uma asserção entre um valor esperado e um WebElement,
     * exibindo mensagens personalizadas em caso de falha.
     *
     * @param esperado O valor esperado.
     * @param atual    O WebElement.
     */
    public static final void assertiva(String esperado, WebElement atual) {
        try {
            Assert.assertEquals(esperado, obterMensagemAtual(atual));
            System.out.println(montaTexto(PASSOU, esperado, atual));
        } catch (AssertionError e) {
            System.out.println(montaTexto(FALHOU, esperado, atual));
            throw e;
        }
    }

    /**
     * Monta uma mensagem personalizada para a asserção.
     *
     * @param texto    O texto da mensagem.
     * @param esperado O valor esperado.
     * @param atual    O valor atual.
     * @return A mensagem personalizada.
     */

    private static final String montaTexto(String texto, String esperado, String atual) {
        String info = texto.replace("xxx", esperado).replace("yyy", atual);

        return info;
    }

    /**
     * Monta uma mensagem personalizada para a asserção.
     *
     * @param texto    O texto da mensagem.
     * @param esperado O valor esperado.
     * @param atual    O valor atual.
     * @return A mensagem personalizada.
     */
    private static final String montaTexto(String texto, String esperado, WebElement atual) {
        String info = texto.replace("xxx", esperado).replace((CharSequence) "yyy", (CharSequence) atual);

        return info;
    }
}

