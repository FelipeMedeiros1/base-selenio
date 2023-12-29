package SISTEMA.transacoes.fundos.movimentacao;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class MovimentacaoFdsTest extends BaseTest {
    private Movimentacao movimentacao;

    @Test
    public void incluirMovimentacaoFundos() {
        new MovimentacaoFdsUtils("MovimentacaoFdsTest").iniciarTeste(movimentacao, "M1");
    }
}
