package SISTEMA.transacoes.fundos.movimentacao;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class MovimentacaoFdsTest extends BaseTest {
    private Movimentacao movimentacao;

    @Test
    public void incluirMovimentacaoFundos() {
        new MovimentacaoFdsUtils("MovimentacaoFdsTest").executarTeste(movimentacao, "M1");
    }
}
