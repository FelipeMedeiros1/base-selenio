package sistema.dominio.transacoes.processamento.bloqueio_liberacao;

import webdriver.base.BaseTest;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTest {
    private BloqueioELiberacao libContabil;


    @Test
    public void testBloqueioDeProcessamentoELiberacaoContabil(){
        new BloqueioELiberacaoUtils("BloqueioELiberacaoTest").executarTeste(libContabil,"BL2");
    }
}
