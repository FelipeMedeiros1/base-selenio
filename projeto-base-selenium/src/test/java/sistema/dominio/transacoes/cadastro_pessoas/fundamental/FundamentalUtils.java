package sistema.dominio.transacoes.cadastro_pessoas.fundamental;


import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import webdriver.pages.transacoes.cadastro_pessoas.fundamental.FundamentalPage;

;


public class FundamentalUtils extends UtilitarioCadastroTestCase<Fundamental, FundamentalPage> {

    public FundamentalUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(FundamentalPage page, Fundamental modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Fundamental", Fundamental.class);
        page.pessoa(modeloDeCadastro.getPessoa());
        page.codigo(modeloDeCadastro.getCodigo());
        page.localidade(modeloDeCadastro.getLocalidade());
        page.grupoDeCarteiras(modeloDeCadastro.getGrupoDeCarteiras());
        page.selecionaTodos();
        page.apropriacao().administrador(modeloDeCadastro.getAdministrador());
        page.apropriacao().gestor(modeloDeCadastro.getGestor());
        page.apropriacao().custodiante(modeloDeCadastro.getCustodiante());
    }

    @Override
    public FundamentalUtils executarTeste(Fundamental modeloDeCadastro, String chavePrimaria) {
        FundamentalPage page = new FundamentalPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao("Fundamental");
        return this;
    }
}
