package SISTEMA.transacoes.cadastro_pessoas.fundamental;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class FundamentalTest extends BaseTest {
    private Fundamental fundamental;

    @Test
    public void testCadastrarFundamental() {
        new FundamentalUtils("FundamentalTest").executarTeste(fundamental, "F1");
    }
}
