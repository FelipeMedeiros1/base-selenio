package sistema_integrado;

import sistema.dominio.relatorios.patrimonio.carteira_diaria.CarteiraDiaria;
import sistema.dominio.relatorios.patrimonio.carteira_diaria.CarteiraDiariaUtils;
import sistema.dominio.transacoes.cadastro_pessoas.fundamental.Fundamental;
import sistema.dominio.transacoes.fundos.movimentacao.Movimentacao;
import sistema.dominio.transacoes.fundos.movimentacao.MovimentacaoFdsUtils;
import sistema.dominio.transacoes.processamento.cockpit.CockPit;
import sistema.dominio.transacoes.processamento.cockpit.CockPitUtils;
import sistema.dominio.transacoes.processamento.processamento.Processamento;
import webdriver.base.BaseTest;
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
