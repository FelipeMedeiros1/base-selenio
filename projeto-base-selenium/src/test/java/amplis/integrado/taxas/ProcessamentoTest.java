package amplis.integrado.taxas;

import org.junit.Test;
import amplis.transacoes.processamento.processamento.automacao.Processamento;
import amplis.transacoes.processamento.processamento.automacao.ProcessamentoUtils;
import amplis.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabil;
import amplis.transacoes.processamento.processamentoContabil.automacao.ProcessamentoContabilUtils;
import servico.base.BaseTeste;


public class ProcessamentoTest extends BaseTeste {
    private Processamento dadosProcessamento;
    private ProcessamentoContabil dadosCTB;
    private String processamento = "amplis/integrado/processamento/automacao/Processamento.json";
    private String processamentoCTB = "amplis/integrado/processamento/automacao/ProcessamentoContabil.json";

    @Test
    public void testProcessamento() {
        new ProcessamentoUtils(processamento).executar(dadosProcessamento, 1);
        new ProcessamentoContabilUtils(processamentoCTB).executar(dadosCTB, 1);
    }

}
