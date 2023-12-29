package SISTEMA.transacoes.renda_fixa.operacoes_termo;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class OperacoesATermoTest extends BaseTest {
    private OperacoesATermo OpTermo;

    @Test
    public void teste01() {
        new OperacoesATermoUtils("OperacoesATermoTest").iniciarTeste(OpTermo, "OT1");


    }
}
