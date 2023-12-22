package SISTEMA.transacoes.processamento.cockpit;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class CockPitTest extends BaseTest {
    private CockPit cockPit;
    @Test
    public void testCockPit(){
       new CockPitUtils("CockPitTest").iniciarTeste(cockPit,"C1");
    }

}
