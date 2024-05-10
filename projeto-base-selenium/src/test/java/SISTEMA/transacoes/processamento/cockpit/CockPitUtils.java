package SISTEMA.transacoes.processamento.cockpit;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.processamento.cockpit.CockPitPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class CockPitUtils extends UtilitarioCadastroTestCase<CockPit, CockPitPage> {

    public CockPitUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CockPitPage page, CockPit modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "CockPit", CockPit.class);

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
            logDeFalha("CockPit");
        }

        return this;
    }
}
