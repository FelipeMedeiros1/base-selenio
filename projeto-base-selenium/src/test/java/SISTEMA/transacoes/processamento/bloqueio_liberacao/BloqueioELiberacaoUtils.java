package SISTEMA.transacoes.processamento.bloqueio_liberacao;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class BloqueioELiberacaoUtils extends UtilitarioCadastroTestCase<BloqueioELiberacao, BloqueioELiberacaoPage> {

    public BloqueioELiberacaoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(BloqueioELiberacaoPage page, BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "BloqueioEliberacao", BloqueioELiberacao.class);

        page.dataBloqueioLiberacao(modeloDeCadastro.getDataBloqueioLiberacao());
        evidencia("BloqueioEliberacao", "preenchendo-dataBloqueioLiberacao");
        page.tipo(modeloDeCadastro.getTipo());
        page.carteira(modeloDeCadastro.getCarteira());
        evidencia("BloqueioEliberacao", "preenchendo-carteira");
        if (modeloDeCadastro.getBloqueado().equals("true")) {
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
        } else if (modeloDeCadastro.getBloqueado().equals("false")) {
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
        }
        page.motivoDoBloqueio(modeloDeCadastro.getMotivoDoBloqueio());
        evidencia("BloqueioEliberacao", "preenchendo-motivoDoBloqueio");
        page.motivoDoDesbloqueio(modeloDeCadastro.getMotivoDoDesbloqueio());
        evidencia("BloqueioEliberacao", "preenchendo-motivoDoDesbloqueio");
    }

    @Override
    public BloqueioELiberacaoUtils executarTeste(BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        try {
            BloqueioELiberacaoPage page = new BloqueioELiberacaoPage();
            page.acessaPaginaBloqueioELiberacao();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmaOperacao("BloqueioEliberacao");
        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("BloqueioEliberacao");
        }

        return this;
    }
}
