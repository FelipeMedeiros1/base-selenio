package SISTEMA.relatorios.renda_fixa.movimentacao;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    private Movimentacao movimentacao;
    @Test
    public void relatorioMovimentacaoRendaFixa(){
        new MovimentacaoUtils("MovimentacaoTest").gerarRelatorio(movimentacao,"MV1");
    }

}
