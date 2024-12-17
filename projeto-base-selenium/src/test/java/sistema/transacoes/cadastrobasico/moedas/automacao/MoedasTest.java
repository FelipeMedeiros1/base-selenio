package sistema.transacoes.cadastrobasico.moedas.automacao;


import org.junit.Test;
import servico.base.BaseTeste;
import servico.utils.DescricaoCenario;

public class MoedasTest extends BaseTeste {

    private final String json = "amplis/transacoes/cadastrobasico/moedas/automacao/Moedas.json";
    private Moedas dados;

    @Test
    @DescricaoCenario("O teste deverá incluir um nova moeda, altera-la e no final deverá excluir.")
    public void testInclusaoAlteracaoExclusao() {

        new MoedasUtils(json)
                .incluir(dados, 1)
                .alterar(dados, 2)
                .excluir(dados, 1);
    }
}
