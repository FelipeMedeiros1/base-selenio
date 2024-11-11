package amplis.transacoes.processamento.bloqueio_liberacao.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTeste {
    private String json = "transacoes/processamento/bloqueio_liberacao/automacao/BloqueioELiberacao.json";
    private BloqueioELiberacao bloqueioELiberacao;


    @Test
    public void testBloqueioDeProcessamentoELiberacaoContabil() {
        new BloqueioELiberacaoUtils(json).executar(bloqueioELiberacao, 1).executar(bloqueioELiberacao, 2);
    }
}
