package SISTEMA_INTEGRADO.testeintegrado;

import SISTEMA.relatorios.patrimonio.carteira_diaria.CarteiraDiaria;
import SISTEMA.relatorios.patrimonio.carteira_diaria.CarteiraDiariaUtils;
import SISTEMA.transacoes.cadastro_pessoas.fundamental.Fundamental;
import SISTEMA.transacoes.fundos.movimentacao.Movimentacao;
import SISTEMA.transacoes.fundos.movimentacao.MovimentacaoFdsUtils;
import SISTEMA.transacoes.processamento.cockpit.CockPit;
import SISTEMA.transacoes.processamento.cockpit.CockPitUtils;
import SISTEMA.transacoes.processamento.processamento.Processamento;
import WEBDRIVER.base.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteIntegrado extends BaseTest {
    private String repositorio = "TesteIntegrado";
    private Processamento processamento;
    private CockPit cockPit;
    private Fundamental fundamental;
    private CarteiraDiaria cateirraDiara;
    private Movimentacao mov;

    @Test
    public void test01() {
        new CockPitUtils(repositorio).executarTeste(cockPit, "C1");
        new CarteiraDiariaUtils(repositorio).gerarRelatorio(cateirraDiara, "CD1")
                .gerarRelatorio(cateirraDiara, "CD2");
        new MovimentacaoFdsUtils(repositorio).executarTeste(mov, "M1");


    }

}
