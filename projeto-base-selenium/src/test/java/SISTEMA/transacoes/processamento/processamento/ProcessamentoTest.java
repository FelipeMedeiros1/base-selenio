package SISTEMA.transacoes.processamento.processamento;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class ProcessamentoTest extends BaseTest {
    private Processamento processamento;

    @Test
    public void testProcessarCarteira(){
        new ProcessamentoUtils ("ProcessamentoTest")
                .executarTeste(processamento,"P1");

        new ProcessamentoUtils ("ProcessamentoTest")
                .executarTeste(processamento,"P1");



    }
}
