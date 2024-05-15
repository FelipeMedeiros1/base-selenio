package sistema.dominio.transacoes.processamento.processamentoContabil;

import webdriver.base.BaseTest;
import org.junit.Test;

public class ProcessamentoContabilTest extends BaseTest {
    private ProcessamentoContabil procContabil;
    @Test
    public void processarContabil(){
        new ProcessamentoContabilUtils("ProcessamentoContabilTest").executar(procContabil,"PC1");
    }
}
