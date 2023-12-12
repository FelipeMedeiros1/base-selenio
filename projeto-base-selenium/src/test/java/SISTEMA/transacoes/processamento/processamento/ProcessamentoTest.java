package SISTEMA.transacoes.processamento.processamento;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class ProcessamentoTest extends BaseTest {
    private Processamento processamento;

    @Test
    public void testProcessarCarteira(){
        new ProcessamentoUtils ("ProcessamentoTest").executar(processamento,"P1");
    }
}
