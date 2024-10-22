package sistema.amplis.transacoes.cadastrobasico.moedas.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoedasTest extends BaseTeste{
    private Moedas moedas;
    private String json = "transacoes/cadastrobasico/moedas/automacao/Moedas.json";

    @Test
    public void test01_cadastrarMoeda() {
        new MoedasUtils(json).incluir(moedas, 1);
    }
    @Test
    public void test02_alterarMoeda() {
        new MoedasUtils(json).atualizar(moedas,2);
    }

    @Test
    public void test03_excluirMoeda() {
        new MoedasUtils(json).excluir(moedas,3);
    }
}
