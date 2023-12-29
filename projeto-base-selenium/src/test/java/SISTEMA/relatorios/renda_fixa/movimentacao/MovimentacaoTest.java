package SISTEMA.relatorios.renda_fixa.movimentacao;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    private Movimentacao movimentacao;
    @Test
    public void relatorioMovimentacaoRendaFixa(){
        new MovimentacaoUtils("MovimentacaoFdsTest").gerarRelatorio(movimentacao,"MV1");
    }

}
