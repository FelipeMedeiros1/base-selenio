package SISTEMA.transacoes.cadastro_pessoas.fundamental;

import SISTEMA.base.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental.FundamentalPage;

public class FundamentalUtils extends UtilitarioCadastroTestCase<Fundamental, FundamentalPage> {

    public FundamentalUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(FundamentalPage page, Fundamental modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Fundamental", Fundamental.class);

        page.pessoa(modeloDeCadastro.getPessoa());
        page.codigo(modeloDeCadastro.getCodigo());
        page.localidade(modeloDeCadastro.getLocalidade());
        page.grupoDeCarteiras(modeloDeCadastro.getGrupoDeCarteiras());
        page.apropriacao().seleciona();
        page.apropriacao().administrador(modeloDeCadastro.getAdministrador());
        page.apropriacao().gestor(modeloDeCadastro.getGestor());
        page.apropriacao().custodiante(modeloDeCadastro.getCustodiante());
    }

    @Override
    public FundamentalUtils iniciarTeste(Fundamental modeloDeCadastro, String chavePrimaria) {
        FundamentalPage page = new FundamentalPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao();

        return this;
    }
}
