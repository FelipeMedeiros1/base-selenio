package amplis.relatorios.renda_fixa.rendimentos.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class RendimentosRelFixTest extends BaseTeste {
    private RendimentosRelFix relRendimentos;
    private String json = "relatorios/renda_fixa/rendimentos/automacao/RendimentosRelFix.json";

    @Test
    public void gerarRelatorioRendimentos() {
        new RendimentosRelFixUtils(json)
                .gerarRelatorio(relRendimentos, 1)
                .gerarRelatorio(relRendimentos, 2);
    }
}
