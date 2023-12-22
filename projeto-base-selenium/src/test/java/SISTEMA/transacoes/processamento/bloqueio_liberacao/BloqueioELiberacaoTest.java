package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTest {
    private BloqueioELiberacao libContabil;


    @Test
    public void bloqueioDeProcessamentoELiberacaoContabil(){
        new BloqueioELiberacaoUtils("BloqueioELiberacaoTest").iniciarTeste(libContabil,"BL2");
    }
}
