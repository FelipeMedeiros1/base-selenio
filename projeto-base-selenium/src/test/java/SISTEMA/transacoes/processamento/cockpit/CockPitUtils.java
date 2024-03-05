package SISTEMA.transacoes.processamento.cockpit;

import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;
import SISTEMA.config.servicos.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.cockpit.CockPitPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.adicionarLogDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class CockPitUtils extends UtilitarioCadastroTestCase<CockPit, CockPitPage> {

    public CockPitUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CockPitPage page, CockPit modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "CockPit", CockPit.class);

        page.dataProcessamento(modeloDeCadastro.getDataProcessamento());
        evidencia("CockPit","preenchendo-dataProcessamento");
        page.tipoProcessamennto(modeloDeCadastro.getTipoProcessamennto());
        evidencia("CockPit","preenchendo-tipoProcessamennto");
        page.carteira(modeloDeCadastro.getCarteira());
        evidencia("CockPit","preenchendo-carteira");
        page.statusProcessamento(modeloDeCadastro.getStatusProcessamento());
    }

    @Override
    public CockPitUtils executarTeste(CockPit modeloDeCadastro, String chavePrimaria) {
        try {
        CockPitPage page = new CockPitPage();
        page.acessaPaginaCockPit();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.pesquisaResultado();

        }catch (Exception e){
            e.printStackTrace();
            adicionarLogDeFalha("CockPit");
        }

        return this;
    }
}
