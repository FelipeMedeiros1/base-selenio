package sistema.dominio.transacoes.renda_fixa.operacoes_termo;

import webdriver.base.BaseTest;
import org.junit.Test;

public class OperacoesATermoTest extends BaseTest {
    private OperacoesATermo OpTermo;

    @Test
    public void teste01() {
        new OperacoesATermoUtils("OperacoesATermoTest").executarTeste(OpTermo, "OT1");


    }
}
