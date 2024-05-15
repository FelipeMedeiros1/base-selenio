package sistema.dominio.transacoes.processamento.cockpit;


import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import webdriver.pages.transacoes.processamento.cockpit.CockPitPage;


public class CockPitUtils extends UtilitarioCadastroTestCase<CockPit, CockPitPage> {

    public CockPitUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CockPitPage page, CockPit modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "CockPit", CockPit.class);
        page.dataProcessamento(modeloDeCadastro.getDataProcessamento());
        page.tipoProcessamennto(modeloDeCadastro.getTipoProcessamennto());
        page.carteira(modeloDeCadastro.getCarteira());
        page.statusProcessamento(modeloDeCadastro.getStatusProcessamento());
    }

    @Override
    public CockPitUtils executarTeste(CockPit modeloDeCadastro, String chavePrimaria) {
        CockPitPage page = new CockPitPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.pesquisaResultado();
        return this;
    }
}
