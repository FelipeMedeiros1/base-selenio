package sistema.dominio.transacoes.processamento.cockpit;

import webdriver.base.BaseTest;
import org.junit.Test;

public class CockPitTest extends BaseTest {
    private CockPit cockPit;
    @Test
    public void testCockPit(){
       new CockPitUtils("CockPitTest").executarTeste(cockPit,"C1");
    }

}
