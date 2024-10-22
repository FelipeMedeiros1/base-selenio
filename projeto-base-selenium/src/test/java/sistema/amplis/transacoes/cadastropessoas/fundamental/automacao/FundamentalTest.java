package sistema.amplis.transacoes.cadastropessoas.fundamental.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.Test;



public class FundamentalTest extends BaseTeste {
    private Fundamental fundamental;
    private String json = "transacoes/cadastropessoas/fundamental/automacao/Fundamental.json";

    @Test
    public void testFundamental() {

        new FundamentalUtils(json)
                .incluir(fundamental,1)
                .atualizar(fundamental,2)
                .excluir(fundamental, 3);
    }
}
