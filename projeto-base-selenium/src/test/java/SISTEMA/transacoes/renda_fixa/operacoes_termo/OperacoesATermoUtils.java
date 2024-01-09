package SISTEMA.transacoes.renda_fixa.operacoes_termo;

import SISTEMA.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_termo.OperacoesATermoPage;

public class OperacoesATermoUtils extends UtilitarioCadastroTestCase<OperacoesATermo,OperacoesATermoPage> {

    public OperacoesATermoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }


    @Override
    protected void preencheDados(OperacoesATermoPage page, OperacoesATermo modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(getNomeDaPlanilha(),chavePrimaria,"OperacoesATermo", OperacoesATermo.class);

        page.dadosDaMovimentacao().modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        page.dadosDaMovimentacao().dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        page.dadosDaMovimentacao().dataDaCompra(modeloDeCadastro.getDataDaCompra());
        page.dadosDaMovimentacao().dataDoVencimentoDoTermo(modeloDeCadastro.getDataDoVencimentoDoTermo());
        page.dadosDaMovimentacao().carteira(modeloDeCadastro.getCarteira());
        page.dadosDaMovimentacao().titulo(modeloDeCadastro.getTitulo());
        page.dadosDaMovimentacao().emissao(modeloDeCadastro.getEmissao());
        page.dadosDaMovimentacao().subsegmentoPrevic(modeloDeCadastro.getSubsegmentoPrevic());
        page.dadosDaMovimentacao().estoque(modeloDeCadastro.getEstoque());
        page.dadosDaMovimentacao().nivelDeRisco(modeloDeCadastro.getNivelDeRisco());
        page.dadosDaMovimentacao().ativaPassiva(modeloDeCadastro.getAtivaPassiva());
        page.dadosDaMovimentacao().categoria(modeloDeCadastro.getCategoria());
        page.dadosDaMovimentacao().riscoBeneficio(modeloDeCadastro.getRiscoBeneficio());

        page.dadosDaMovimentacao().condicaoDeNegociacao(modeloDeCadastro.getRiscoBeneficio());
        page.dadosDaMovimentacao().taxaDeNegociacao(modeloDeCadastro.getTaxaDeNegociacao());
        page.dadosDaMovimentacao().pu(modeloDeCadastro.getPu());
        page.dadosDaMovimentacao().quantidade(modeloDeCadastro.getQuantidade());
        page.dadosDaMovimentacao().calcular();
        page.dadosDaMovimentacao().rendimento(modeloDeCadastro.getRendimento());
        page.dadosDaMovimentacao().irDaOperacao(modeloDeCadastro.getIrDaOperacao());
        page.dadosDaMovimentacao().iofDaOperacao(modeloDeCadastro.getIofDaOperacao());
        page.dadosDaMovimentacao().eventoEmAtraso(modeloDeCadastro.getEventoEmAtraso());

        page.custodia().custodiante(modeloDeCadastro.getCustodiante());
        page.custodia().localDeCustodia(modeloDeCadastro.getLocalDeCustodia());
        page.custodia().contaDeCustodia(modeloDeCadastro.getContaDeCustodia());
    }

    @Override
    public UtilitarioCadastroTestCase<OperacoesATermo, OperacoesATermoPage> executarTeste(OperacoesATermo modeloDeCadastro, String chavePrimaria) {
        OperacoesATermoPage page = new OperacoesATermoPage();
        page.acessaPagina();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmaOperacao();
        return null;
    }
}
