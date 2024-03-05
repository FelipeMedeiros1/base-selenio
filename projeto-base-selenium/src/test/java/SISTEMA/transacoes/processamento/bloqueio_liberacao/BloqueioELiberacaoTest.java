package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTest {
    private BloqueioELiberacao libContabil;


    @Test
    public void bloqueioDeProcessamentoELiberacaoContabil(){
        new BloqueioELiberacaoUtils("BloqueioELiberacaoTest").executarTeste(libContabil,"BL2");
    }
}
