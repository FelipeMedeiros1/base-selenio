package sistema.dominio.transacoes.renda_fixa.operacoe_compromisadas;



import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;
import webdriver.pages.transacoes.renda_fixa.operacoes_compromissadas.OperacoesCompromissadasPage;

public class OperacoesCompromissadasUtils extends UtilitarioCadastroTestCase<OperacoesCompromissadas, OperacoesCompromissadasPage> {
    public OperacoesCompromissadasUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(OperacoesCompromissadasPage page, OperacoesCompromissadas modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "OperacoesCompromissadas", OperacoesCompromissadas.class);

        page.dadosDaMovimentacao().modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        page.dadosDaMovimentacao().dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        page.dadosDaMovimentacao().dataDaOperacaoOriginal(modeloDeCadastro.getDataDaOperacaoOriginal());
        page.dadosDaMovimentacao().dataDeVencimento(modeloDeCadastro.getDataDeVencimento());
        page.dadosDaMovimentacao().carteira(modeloDeCadastro.getCarteira());
        page.dadosDaMovimentacao().titulo(modeloDeCadastro.getTitulo());
        page.dadosDaMovimentacao().estoque(modeloDeCadastro.getEstoque());
        page.dadosDaMovimentacao().moeda(modeloDeCadastro.getMoeda());
        page.dadosDaMovimentacao().categoria(modeloDeCadastro.getCategoria());
        page.dadosDaMovimentacao().riscoBeneficio(modeloDeCadastro.getRiscoBeneficio());
        page.dadosDaMovimentacao().condicoesDeNegociacao(modeloDeCadastro.getCondicoesDeNegociacao());
        page.dadosDaMovimentacao().serie(modeloDeCadastro.getSerie());
        page.dadosDaMovimentacao().porcentagemDaSerie(modeloDeCadastro.getPorcentagemDaSerie());
        page.dadosDaMovimentacao().puInicio(modeloDeCadastro.getPuInicio());
        page.dadosDaMovimentacao().quantidade(modeloDeCadastro.getQuantidade());
        page.dadosDaMovimentacao().financeiroDeIda(modeloDeCadastro.getFinanceiroDeIda());
        page.dadosDaMovimentacao().rendimento(modeloDeCadastro.getRendimento());
        page.dadosDaMovimentacao().eventoEmAtraso(modeloDeCadastro.getEventoEmAtraso());
        page.dadosDaMovimentacao().livreMovimentacao(modeloDeCadastro.getLivreMovimentacao());

        page.lastroDeCompra().tituloSelicPu550Titulo(modeloDeCadastro.getTituloSelicPu550TituloCompra());
        page.lastroDeCompra().titulo(modeloDeCadastro.getTitulo());
        page.lastroDeCompra().emissao(modeloDeCadastro.getEmissaoCompra());
        page.lastroDeCompra().dataDaEmissao(modeloDeCadastro.getDataDaEmissaoCompra());
        page.lastroDeCompra().dataDeVencimento(modeloDeCadastro.getDataDeVencimentoCompra());
        page.lastroDeCompra().calcular(modeloDeCadastro.getCalcularCompra());
        page.lastroDeCompra().financeiroIda(modeloDeCadastro.getFinanceiroIdaCompra());
        page.lastroDeCompra().pu550Pu(modeloDeCadastro.getPu550PuCompra());
        page.lastroDeCompra().quantidade(modeloDeCadastro.getQuantidadeCompra());
        page.lastroDeCompra().financeiroDeIdaCalculado(modeloDeCadastro.getFinanceiroDeIdaCalculadoCompra());
        page.lastroDeCompra().isin(modeloDeCadastro.getIsinCompra());
        page.lastroDeCompra().codigoSelicCetipCompra(modeloDeCadastro.getCodigoSelicCetipCompra());
        page.lastroDeCompra().esferaDaEmissao(modeloDeCadastro.getEsferaDaEmissaoCompra());
        page.lastroDeCompra().empresaLigada(modeloDeCadastro.getEmpresaLigadaCompra());
        page.lastroDeCompra().descricaoBacen(modeloDeCadastro.getDescricaoBacenCompra());
        page.lastroDeCompra().codigoCBLCCompra(modeloDeCadastro.getCodigoCBLCCompra());
        page.lastroDeCompra().localidade(modeloDeCadastro.getLocalidadeCompra());
        page.lastroDeCompra().emissorParaPerfilMensal(modeloDeCadastro.getEmissorParaPerfilMensalCompra());

        page.lastroDeVenda().tituloSelicPu550Titulo(modeloDeCadastro.getTituloSelicPu550TituloVenda());
        page.lastroDeVenda().emissao(modeloDeCadastro.getEmissaoVenda());
        page.lastroDeVenda().codigoDaOperacao(modeloDeCadastro.getCodigoDaOperacaoVenda());
        page.lastroDeVenda().dataDeEmissao(modeloDeCadastro.getDataDeEmissaoVenda());
        page.lastroDeVenda().dataDeVencimento(modeloDeCadastro.getDataDeVencimentoVenda());
        page.lastroDeVenda().calcular(modeloDeCadastro.getCalcularVenda());
        page.lastroDeVenda().financeiroIda(modeloDeCadastro.getFinanceiroIdaVenda());
        page.lastroDeVenda().pu550Pu(modeloDeCadastro.getPu550PuVenda());
        page.lastroDeVenda().quantidade(modeloDeCadastro.getQuantidadeVenda());
        page.lastroDeVenda().financeiroDeIdaCalculado(modeloDeCadastro.getFinanceiroDeIdaCalculadoVenda());
        page.lastroDeVenda().isin(modeloDeCadastro.getIsinVenda());
        page.lastroDeVenda().codigoSelicCetip(modeloDeCadastro.getCodigoSelicCetipVenda());
        page.lastroDeVenda().codigoCBLC(modeloDeCadastro.getCodigoCBLCVenda());
    }

    @Override
    protected OperacoesCompromissadasUtils executarTeste(OperacoesCompromissadas modeloDeCadastro, String chavePrimaria) {
        OperacoesCompromissadasPage page = new OperacoesCompromissadasPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao("OperacoesCompromissadas");
        return this;
    }
}
