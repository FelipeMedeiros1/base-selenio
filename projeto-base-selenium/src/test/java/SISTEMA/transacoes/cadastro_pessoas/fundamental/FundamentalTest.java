package SISTEMA.transacoes.cadastro_pessoas.fundamental;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FundamentalTest extends BaseTest {
    private Fundamental fundamental;

    @Test
    public void testCadastrarFundamental(){
      new FundamentalUtils("FundamentalTest").iniciarTeste(fundamental,"F1");
    }
}
