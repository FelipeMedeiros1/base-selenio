package SISTEMA.transacoes.processamento.bloqueio_liberacao;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoPage;

public class BloqueioELiberacaoUtils {
    private final String nomePlanilha;

    public BloqueioELiberacaoUtils(String planilhaTeste) {
        this.nomePlanilha = planilhaTeste;
    }
    public BloqueioELiberacaoUtils bloquear(BloqueioELiberacao modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro = LeitorPlanilha.carregarDados(nomePlanilha,chavePrimaria,"BloqueioEliberacao", BloqueioELiberacao.class);
        BloqueioELiberacaoPage page = new BloqueioELiberacaoPage();
        page.acessaPaginaBloqueioELiberacao();
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
        page.confirmaOperacao();
        return this;
    }
}
