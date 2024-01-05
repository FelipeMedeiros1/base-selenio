package SISTEMA.transacoes.processamento.cockpit;

import SISTEMA.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.cockpit.CockPitPage;

public class CockPitUtils extends UtilitarioCadastroTestCase<CockPit, CockPitPage> {

    public CockPitUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CockPitPage page, CockPit modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "CockPit", CockPit.class);

        page.dataProcessamento(modeloDeCadastro.getDataProcessamento());
        page.tipoProcessamennto(modeloDeCadastro.getTipoProcessamennto());
        page.carteira(modeloDeCadastro.getCarteira());
        page.statusProcessamento(modeloDeCadastro.getStatusProcessamento());
    }

    @Override
    public CockPitUtils iniciarTeste(CockPit modeloDeCadastro, String chavePrimaria) {
        CockPitPage page = new CockPitPage();
        page.acessaPaginaCockPit();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.pesquisaResultado();

        return this;
    }
}
