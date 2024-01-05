package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import SISTEMA.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoPage;

public class BloqueioELiberacaoUtils extends UtilitarioCadastroTestCase<BloqueioELiberacao,BloqueioELiberacaoPage> {

    public BloqueioELiberacaoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(BloqueioELiberacaoPage page, BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(),chavePrimaria,"BloqueioEliberacao", BloqueioELiberacao.class);

        page.dataBloqueioLiberacao(modeloDeCadastro.getDataBloqueioLiberacao());
        page.tipo(modeloDeCadastro.getTipo());
        page.carteira(modeloDeCadastro.getCarteira());
        if (modeloDeCadastro.getBloqueado().equals("true")){
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
        }else if (modeloDeCadastro.getBloqueado().equals("false")){
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
        }
        page.motivoDoBloqueio(modeloDeCadastro.getMotivoDoBloqueio());
        page.motivoDoDesbloqueio(modeloDeCadastro.getMotivoDoDesbloqueio());
    }

    @Override
    public BloqueioELiberacaoUtils iniciarTeste(BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        BloqueioELiberacaoPage page = new BloqueioELiberacaoPage();
        page.acessaPaginaBloqueioELiberacao();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmaOperacao();
        return this;
    }
}
