package sistema.transacoes.processamento.bloqueio_liberacao.automacao;

import base.BaseTeste;
import org.junit.Test;

public class BloqueioELiberacaoTest extends BaseTeste {
    private final String json = "transacoes/processamento/bloqueio_liberacao/automacao/BloqueioELiberacao.json";
    private BloqueioELiberacao bloqueioELiberacao;


    @Test
    public void testBloqueioDeProcessamentoELiberacaoContabil() {
        new BloqueioELiberacaoUtils(json).executar(bloqueioELiberacao, 1).executar(bloqueioELiberacao, 2);
    }
}
