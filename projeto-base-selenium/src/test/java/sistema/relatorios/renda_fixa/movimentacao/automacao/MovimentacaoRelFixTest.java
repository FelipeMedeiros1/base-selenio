package sistema.relatorios.renda_fixa.movimentacao.automacao;

import base.BaseTeste;
import org.junit.Test;

public class MovimentacaoRelFixTest extends BaseTeste {
    private final String json = "relatorios/renda_fixa/movimentacao/automacao/MovimentacaoRelFix.json";
    private MovimentacaoRelFix movimentacao;

    @Test
    public void relatorioMovimentacaoRendaFixa() {
        new MovimentacaoRelFixUtils(json).gerarRelatorio(movimentacao, 1);
    }

}
