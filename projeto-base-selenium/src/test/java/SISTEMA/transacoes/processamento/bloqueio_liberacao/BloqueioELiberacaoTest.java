package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import SISTEMA.transacoes.processamento.cockpit.CockPit;
import SISTEMA.transacoes.processamento.processamento.Processamento;
import SISTEMA.transacoes.processamento.processamentoContabil.ProcessamentoContabil;
import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTest {
    private BloqueioELiberacao libContabil;
    private Processamento proc;
    private CockPit ckp;
    private ProcessamentoContabil procContabil;

    @Test
    public void bloqueioDeProcessamentoELiberacaoContabil(){
        new BloqueioELiberacaoUtils("BloqueioELiberacaoTest").bloquear(libContabil,"BL2");
    }
}
