package sistema.amplis.relatorios.renda_fixa.rendimentos.automacao;

import webdriver.base.BaseTeste;
import org.junit.Test;

public class RendimentosTest extends BaseTeste {
    private Rendimentos relRendimentos;
    private String json = "relatorios/renda_fixa/rendimentos/automacao/Rendimentos.json";

    @Test
    public void gerarRelatorioRendimentos() {
        new RendimentosUtils(json)
                .gerarRelatorio(relRendimentos, 1)
                .gerarRelatorio(relRendimentos, 2);
    }
}
