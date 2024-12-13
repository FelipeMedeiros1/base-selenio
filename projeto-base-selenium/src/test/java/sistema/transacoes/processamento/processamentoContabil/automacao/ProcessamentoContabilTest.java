package amplis.transacoes.processamento.processamentoContabil.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class ProcessamentoContabilTest extends BaseTeste {
    private ProcessamentoContabil procContabil;
    private String json ="transacoes/processamento/processamentoContabil/automacao/ProcessamentoContabil.json";
    @Test
    public void testProcessamentoContabil(){
        new ProcessamentoContabilUtils(json).executar(procContabil,1);
    }
}
