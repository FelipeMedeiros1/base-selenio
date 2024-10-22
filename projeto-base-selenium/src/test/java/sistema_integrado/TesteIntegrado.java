package sistema_integrado;

import sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao.CarteiraDiaria;
import sistema.amplis.transacoes.cadastropessoas.fundamental.automacao.Fundamental;
import sistema.amplis.transacoes.fundos.movimentacao.automacao.Movimentacao;
import sistema.amplis.transacoes.fundos.movimentacao.automacao.MovimentacaoFdsUtils;
import sistema.amplis.transacoes.processamento.cockpit.automacao.CockPit;
import sistema.amplis.transacoes.processamento.processamento.automacao.Processamento;
import sistema.servicos.base.BaseTeste;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteIntegrado extends BaseTeste {
    private String repositorio = "TesteIntegrado";
    private Processamento processamento;
    private CockPit cockPit;
    private Fundamental fundamental;
    private CarteiraDiaria cateirraDiara;
    private Movimentacao mov;

    @Test
    public void test01() {
//        new CockPitUtils(repositorio).executarTeste(cockPit, "C1");
//        new CarteiraDiariaUtils(repositorio).gerarRelatorio(cateirraDiara, "CD1")
//                .gerarRelatorio(cateirraDiara, "CD2");
        new MovimentacaoFdsUtils(repositorio).incluir(mov, 1);


    }

}
