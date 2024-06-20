package sistema.amplis.transacoes.processamento.processamento.automacao;

import webdriver.base.BaseTeste;
import org.junit.Test;

public class ProcessamentoTest extends BaseTeste {
    private Processamento processamento;
    private String json = "transacoes/processamento/processamento/automacao/Processamento.json";

    @Test
    public void testProcessarCarteira() {
        new ProcessamentoUtils(json).executar(processamento, 3);
    }
}
