package sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastroTestCase;
import sistema.amplis.transacoes.rendafixa.operacoe_compromisadas.pagina.PaginaOperacoesCompromissadas;

public class OperacoesCompromissadasUtils extends UtilitarioCadastroTestCase<OperacoesCompromissadas> {
    public OperacoesCompromissadasUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaOperacoesCompromissadas pagina = new PaginaOperacoesCompromissadas();

    @Override
    protected void preencheDados(OperacoesCompromissadas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesCompromissadas.class);

        pagina.selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDoMovimento());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDaOperacaoOriginal, dados.dataDaOperacaoOriginal());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDeVencimento, dados.dataDeVencimento());
        pagina.preenche(pagina.dadosDaMovimentacao().carteira, dados.carteira());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().moeda, dados.moeda());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        pagina.preenche(pagina.dadosDaMovimentacao().serie, dados.serie());
        pagina.preenche(pagina.dadosDaMovimentacao().porcentagemDaSerie, dados.porcentagemDaSerie());
        pagina.preenche(pagina.dadosDaMovimentacao().puInicio, dados.puInicio());
        pagina.preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        pagina.preenche(pagina.dadosDaMovimentacao().financeiroDeIda, dados.financeiroDeIda());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().livreMovimentacao, dados.livreMovimentacao());

        pagina.preenche(pagina.lastroDeCompra().tituloSelicPu550Titulo, dados.tituloSelicPu550TituloCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().titulo, dados.titulo());
        pagina.selecionaUm(pagina.lastroDeCompra().emissao, dados.emissaoCompra());
        pagina.preenche(pagina.lastroDeCompra().dataDaEmissao, dados.dataDaEmissaoCompra());
        pagina.preenche(pagina.lastroDeCompra().dataDeVencimento, dados.dataDeVencimentoCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().calcular, dados.calcularCompra());
        pagina.preenche(pagina.lastroDeCompra().financeiroIda, dados.financeiroIdaCompra());
        pagina.preenche(pagina.lastroDeCompra().pu550Pu, dados.pu550PuCompra());
        pagina.preenche(pagina.lastroDeCompra().quantidade, dados.quantidadeCompra());
        pagina.preenche(pagina.lastroDeCompra().financeiroDeIdaCalculado, dados.financeiroDeIdaCalculadoCompra());
        pagina.preenche(pagina.lastroDeCompra().isin, dados.isinCompra());
        pagina.preenche(pagina.lastroDeCompra().codigoSelicCetipCompra, dados.codigoSelicCetipCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().esferaDaEmissao, dados.esferaDaEmissaoCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().empresaLigada, dados.empresaLigadaCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().descricaoBacen, dados.descricaoBacenCompra());
        pagina.preenche(pagina.lastroDeCompra().codigoCBLCCompra, dados.codigoCBLCCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().localidade, dados.localidadeCompra());
        pagina.selecionaUm(pagina.lastroDeCompra().emissorParaPerfilMensal, dados.emissorParaPerfilMensalCompra());

        pagina.selecionaUm(pagina.lastroDeVenda().tituloSelicPu550TituloVenda, dados.tituloSelicPu550TituloVenda());
        pagina.selecionaUm(pagina.lastroDeVenda().emissaoVenda, dados.emissaoVenda());
        pagina.preenche(pagina.lastroDeVenda().codigoDaOperacaoVenda, dados.codigoDaOperacaoVenda());
        pagina.preenche(pagina.lastroDeVenda().dataDeEmissaoVenda, dados.dataDeEmissaoVenda());
        pagina.preenche(pagina.lastroDeVenda().dataDeVencimentoVenda, dados.dataDeVencimentoVenda());
        pagina.selecionaUm(pagina.lastroDeVenda().calcularVenda, dados.calcularVenda());
        pagina.preenche(pagina.lastroDeVenda().financeiroIdaVenda, dados.financeiroIdaVenda());
        pagina.preenche(pagina.lastroDeVenda().pu550PuVenda, dados.pu550PuVenda());
        pagina.preenche(pagina.lastroDeVenda().quantidadeVenda, dados.quantidadeVenda());
        pagina.preenche(pagina.lastroDeVenda().financeiroDeIdaCalculadoVenda, dados.financeiroDeIdaCalculadoVenda());
        pagina.preenche(pagina.lastroDeVenda().isinVenda, dados.isinVenda());
        pagina.preenche(pagina.lastroDeVenda().codigoSelicCetipVenda, dados.codigoSelicCetipVenda());
        pagina.preenche(pagina.lastroDeVenda().codigoCBLCVenda, dados.codigoCBLCVenda());
    }


    @Override
    protected OperacoesCompromissadasUtils executar(OperacoesCompromissadas dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    protected void consulta(OperacoesCompromissadas dados, int posicao) {

    }

    @Override
    protected OperacoesCompromissadasUtils atualizar(OperacoesCompromissadas dados, int posicao) {
        return this;
    }

    @Override
    protected void excluir(OperacoesCompromissadas dados, int posicao) {

    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirmaOperacao();
    }
}
