package sistema.integrado.taxas;

import org.junit.Test;
import servico.base.BaseTeste;
import sistema.transacoes.processamento.processamento.automacao.Processamento;
import sistema.transacoes.processamento.processamento.automacao.ProcessamentoUtils;
import sistema.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabil;
import sistema.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabilUtils;


public class ProcessamentoTest extends BaseTeste {
    private Processamento dadosProcessamento;
    private ProcessamentoContabil dadosCTB;
    private final String processamento = "amplis/integrado/processamento/automacao/Processamento.json";
    private final String processamentoCTB = "amplis/integrado/processamento/automacao/ProcessamentoContabil.json";

    @Test
    public void testProcessamento() {
        new ProcessamentoUtils(processamento).executar(dadosProcessamento, 1);
        new ProcessamentoContabilUtils(processamentoCTB).executar(dadosCTB, 1);
    }

}
