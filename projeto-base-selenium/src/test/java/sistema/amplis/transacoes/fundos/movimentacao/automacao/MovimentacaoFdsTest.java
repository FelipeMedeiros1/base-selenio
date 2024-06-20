package sistema.amplis.transacoes.fundos.movimentacao.automacao;

import webdriver.base.BaseTeste;
import org.junit.Test;

public class MovimentacaoFdsTest extends BaseTeste {
    private Movimentacao movimentacao;
    private String json = "transacoes/fundos/movimentacao/automacao/MovimentacaoFds.json";

    @Test
    public void incluirMovimentacaoFundos() {
        new MovimentacaoFdsUtils(json).executar(movimentacao, 1);
    }
}
