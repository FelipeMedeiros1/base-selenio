package sistema.amplis.transacoes.cadastropessoas.fundos.automacao;

import org.junit.Test;
import sistema.servicos.base.BaseTeste;


public class CadastroFundosTest extends BaseTeste {


    private String json = "";
    private CadastroFundos dados;

    @Test
    public void testCadastrarFundos() {
        new CadastroFundosUtils(json).excluir(dados, 1);
    }
}
