package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import SISTEMA.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.componentes.CapturaDeTela;
import WEBDRIVER.pageObject.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoPage;

public class BloqueioELiberacaoUtils extends UtilitarioCadastroTestCase<BloqueioELiberacao,BloqueioELiberacaoPage> {

    public BloqueioELiberacaoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(BloqueioELiberacaoPage page, BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(),chavePrimaria,"BloqueioEliberacao", BloqueioELiberacao.class);

        page.dataBloqueioLiberacao(modeloDeCadastro.getDataBloqueioLiberacao());
        new CapturaDeTela().evidencia("BloqueioEliberacao","preenchendo-dataBloqueioLiberacao");
        page.tipo(modeloDeCadastro.getTipo());
        page.carteira(modeloDeCadastro.getCarteira());
        new CapturaDeTela().evidencia("BloqueioEliberacao","preenchendo-carteira");
        if (modeloDeCadastro.getBloqueado().equals("true")){
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
        }else if (modeloDeCadastro.getBloqueado().equals("false")){
            page.liberacaoContabil(Boolean.valueOf(modeloDeCadastro.getLiberacaoContabil()));
            page.bloqueado(Boolean.valueOf(modeloDeCadastro.getBloqueado()));
        }
        page.motivoDoBloqueio(modeloDeCadastro.getMotivoDoBloqueio());
        new CapturaDeTela().evidencia("BloqueioEliberacao","preenchendo-motivoDoBloqueio");
        page.motivoDoDesbloqueio(modeloDeCadastro.getMotivoDoDesbloqueio());
        new CapturaDeTela().evidencia("BloqueioEliberacao","preenchendo-motivoDoDesbloqueio");
    }

    @Override
    public BloqueioELiberacaoUtils executarTeste(BloqueioELiberacao modeloDeCadastro, String chavePrimaria) {
        BloqueioELiberacaoPage page = new BloqueioELiberacaoPage();
        page.acessaPaginaBloqueioELiberacao();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmaOperacao("BloqueioEliberacao");
        return this;
    }
}
