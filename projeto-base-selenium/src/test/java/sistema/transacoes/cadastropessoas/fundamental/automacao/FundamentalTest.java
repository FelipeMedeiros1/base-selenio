package sistema.transacoes.cadastropessoas.fundamental.automacao;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import base.BaseTeste;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FundamentalTest extends BaseTeste {
    private Fundamental fundamental;
    private final String json = "amplis/transacoes/cadastropessoas/fundamental/automacao/Fundamental.json";

    @Test
    public void test01_lInclusao() {
        new FundamentalUtils(json).incluir(fundamental, 1);
    }

    @Test
    public void test02_Alteracao() {
        new FundamentalUtils(json).alterar(fundamental, 2);
    }

    @Test
    public void test03_lExclusao() {
        new FundamentalUtils(json).excluir(fundamental, 3);
    }
}
