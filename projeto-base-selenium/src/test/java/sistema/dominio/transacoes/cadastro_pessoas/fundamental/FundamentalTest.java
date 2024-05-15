package sistema.dominio.transacoes.cadastro_pessoas.fundamental;

import webdriver.base.BaseTest;
import org.junit.Test;

public class FundamentalTest extends BaseTest {
    private Fundamental fundamental;

    @Test
    public void testCadastrarFundamental() {
        new FundamentalUtils("FundamentalTest").executarTeste(fundamental, "F1");
    }
}
