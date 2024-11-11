package amplis.transacoes.rendafixa.operacoes_termo.automacao;

import org.junit.Test;
import servico.base.BaseTeste;

public class OperacoesATermoTest extends BaseTeste {

    private OperacoesATermo opTermo;

    @Test
    public void qa() {

        String json = "amplis/transacoes/rendafixa/operacoes_termo/automacao/OperacoesATermo.json";
        new OperacoesATermoFixUtils(json).alterar(opTermo, 1);

    }
}
