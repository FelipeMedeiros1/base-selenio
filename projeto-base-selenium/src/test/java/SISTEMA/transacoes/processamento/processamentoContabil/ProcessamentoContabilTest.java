package SISTEMA.transacoes.processamento.processamentoContabil;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class ProcessamentoContabilTest extends BaseTest {
    private ProcessamentoContabil procContabil;
    @Test
    public void processarContabil(){
        new ProcessamentoContabilUtils("ProcessamentoContabilTest").executar(procContabil,"PC1");
    }
}
