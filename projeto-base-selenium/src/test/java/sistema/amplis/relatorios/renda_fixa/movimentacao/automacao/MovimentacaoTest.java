package sistema.amplis.relatorios.renda_fixa.movimentacao.automacao;

import webdriver.base.BaseTeste;
import org.junit.Test;

public class MovimentacaoTest extends BaseTeste {
    private String json = "relatorios/renda_fixa/movimentacao/automacao/Movimentacao.json";
    private Movimentacao movimentacao;

    @Test
    public void relatorioMovimentacaoRendaFixa() {
        new MovimentacaoUtils(json).gerarRelatorio(movimentacao, 1);
    }

}
