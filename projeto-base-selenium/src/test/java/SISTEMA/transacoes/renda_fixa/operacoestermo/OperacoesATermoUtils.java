package SISTEMA.transacoes.renda_fixa.operacoestermo;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.renda_fixa.operacoestermo.OperacoesATermoPage;

public class OperacoesATermoUtils {
    private final String nomeDaPlanilhaTeste;

    public OperacoesATermoUtils(String nomeDaPlanilhaTeste){
        this.nomeDaPlanilhaTeste = nomeDaPlanilhaTeste;
    }

    public OperacoesATermoUtils incluir(OperacoesATermo modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(nomeDaPlanilhaTeste,chavePrimaria,"OperacoesATermo", OperacoesATermo.class);
        OperacoesATermoPage page = new OperacoesATermoPage();
        page.acessaPagina();
        page.dadosDaMovimentacao().seleciona();
        page.dadosDaMovimentacao().modalidadeDoMovimento(modeloDeCadastro.getDadosDaMovimentacao().getModalidadeDoMovimento());
        page.dadosDaMovimentacao().dataDoMovimento(modeloDeCadastro.getDadosDaMovimentacao().getDataDoMovimento());
        page.dadosDaMovimentacao().dataDaCompra(modeloDeCadastro.getDadosDaMovimentacao().getDataDaCompra());
        page.dadosDaMovimentacao().dataDoVencimentoDoTermo(modeloDeCadastro.getDadosDaMovimentacao().getDataDoVencimentoDoTermo());
        page.dadosDaMovimentacao().carteira(modeloDeCadastro.getDadosDaMovimentacao().getCarteira());
        page.dadosDaMovimentacao().titulo(modeloDeCadastro.getDadosDaMovimentacao().getTitulo());
        page.dadosDaMovimentacao().emissao(modeloDeCadastro.getDadosDaMovimentacao().getEmissao());
        page.dadosDaMovimentacao().subsegmentoPrevic(modeloDeCadastro.getDadosDaMovimentacao().getSubsegmentoPrevic());
        page.dadosDaMovimentacao().estoque(modeloDeCadastro.getDadosDaMovimentacao().getEstoque());
        page.dadosDaMovimentacao().nivelDeRisco(modeloDeCadastro.getDadosDaMovimentacao().getNivelDeRisco());
        page.dadosDaMovimentacao().ativaPassiva(modeloDeCadastro.getDadosDaMovimentacao().getAtivaPassiva());
        page.dadosDaMovimentacao().categoria(modeloDeCadastro.getDadosDaMovimentacao().getCategoria());
        page.dadosDaMovimentacao().riscoBeneficio(modeloDeCadastro.getDadosDaMovimentacao().getRiscoBeneficio());
        page.dadosDaMovimentacao().condicaoDeNegociacao(modeloDeCadastro.getDadosDaMovimentacao().getRiscoBeneficio());
        page.dadosDaMovimentacao().taxaDeNegociacao(modeloDeCadastro.getDadosDaMovimentacao().getTaxaDeNegociacao());
        page.dadosDaMovimentacao().pu(modeloDeCadastro.getDadosDaMovimentacao().getPu());
        page.dadosDaMovimentacao().quantidade(modeloDeCadastro.getDadosDaMovimentacao().getQuantidade());
        page.dadosDaMovimentacao().calcular();
        page.dadosDaMovimentacao().rendimento(modeloDeCadastro.getDadosDaMovimentacao().getRendimento());
        page.dadosDaMovimentacao().irDaOperacao(modeloDeCadastro.getDadosDaMovimentacao().getIrDaOperacao());
        page.dadosDaMovimentacao().iofDaOperacao(modeloDeCadastro.getDadosDaMovimentacao().getIofDaOperacao());
        page.dadosDaMovimentacao().eventoEmAtraso(modeloDeCadastro.getDadosDaMovimentacao().getEventoEmAtraso());

        page.custodia().seleciona();
        page.custodia().custodiante(modeloDeCadastro.getCustodia().getCustodiante());
        page.custodia().localDeCustodia(modeloDeCadastro.getCustodia().getLocalDeCustodia());
        page.custodia().contaDeCustodia(modeloDeCadastro.getCustodia().getContaDeCustodia());


        return this;
    }
}
