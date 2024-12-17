package sistema.transacoes.processamento.processamento.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class ProcessamentoTest extends BaseTeste {
    private Processamento processamento;
    private final String json = "amplis/transacoes/processamento/processamento/automacao/Processamento.json";

    @Test
    public void testProcessamento() {
        new ProcessamentoUtils(json).executar(processamento, 1);
    }
}
