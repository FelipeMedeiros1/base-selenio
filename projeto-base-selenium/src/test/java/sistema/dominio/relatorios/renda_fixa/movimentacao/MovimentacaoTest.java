package sistema.dominio.relatorios.renda_fixa.movimentacao;

import webdriver.base.BaseTest;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    private Movimentacao movimentacao;
    @Test
    public void relatorioMovimentacaoRendaFixa(){
        new MovimentacaoUtils("MovimentacaoTest").gerarRelatorio(movimentacao,"MV1");
    }

}
