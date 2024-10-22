package sistema.amplis.relatorios.renda_fixa.movimentacao.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.Test;

public class MovimentacaoRelFixTest extends BaseTeste {
    private String json = "relatorios/renda_fixa/movimentacao/automacao/MovimentacaoRelFix.json";
    private MovimentacaoRelFix movimentacao;

    @Test
    public void relatorioMovimentacaoRendaFixa() {
        new MovimentacaoRelFixUtils(json).gerarRelatorio(movimentacao, 1);
    }

}
