package SISTEMA.transacoes.cadastro_pessoas.fundamental;

import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;
import SISTEMA.config.servicos.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental.FundamentalPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.adicionarLogDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class FundamentalUtils extends UtilitarioCadastroTestCase<Fundamental, FundamentalPage> {

    public FundamentalUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(FundamentalPage page, Fundamental modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Fundamental", Fundamental.class);

        page.pessoa(modeloDeCadastro.getPessoa());
        evidencia("Fundamental", "preenchendo-pessoa");
        page.codigo(modeloDeCadastro.getCodigo());
        evidencia("Fundamental", "preenchendo-codigo");
        page.localidade(modeloDeCadastro.getLocalidade());
        evidencia("Fundamental", "preenchendo-localidade");
        page.grupoDeCarteiras(modeloDeCadastro.getGrupoDeCarteiras());
        evidencia("Fundamental", "preenchendo-grupoDeCarteiras");
        page.selecionaTodos();
        page.apropriacao().administrador(modeloDeCadastro.getAdministrador());
        evidencia("Fundamental", "preenchendo-administrador");
        page.apropriacao().gestor(modeloDeCadastro.getGestor());
        evidencia("Fundamental", "preenchendo-gestor");
        page.apropriacao().custodiante(modeloDeCadastro.getCustodiante());
        evidencia("Fundamental", "preenchendo-custodiante");
    }

    @Override
    public FundamentalUtils executarTeste(Fundamental modeloDeCadastro, String chavePrimaria) {
        try {
            FundamentalPage page = new FundamentalPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmaOperacao("Fundamental");

        } catch (Exception e) {
            e.printStackTrace();
            adicionarLogDeFalha("Fundamental");
        }
        return this;
    }
}
