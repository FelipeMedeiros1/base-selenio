package sistema.amplis.transacoes.cadastropessoas.fundamental.automacao;

import webdriver.base.BaseTeste;
import org.junit.Test;

public class FundamentalTest extends BaseTeste {
    private Fundamental fundamental;
    private String json = "transacoes/cadastropessoas/fundamental/automacao/Fundamental.json";

    @Test
    public void testCadastrarFundamental() {
        new FundamentalUtils(json)
                .executar(fundamental,1)
                .atualizar(fundamental,2)
                .atualizar(fundamental, 3);
    }
}
