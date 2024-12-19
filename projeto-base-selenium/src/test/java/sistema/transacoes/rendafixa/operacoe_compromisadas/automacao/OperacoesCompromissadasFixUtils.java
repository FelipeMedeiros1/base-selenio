package sistema.transacoes.rendafixa.operacoe_compromisadas.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;

import servico.utils.UtilitarioCadastro;
import sistema.transacoes.rendafixa.operacoe_compromisadas.pagina.PaginaOperacoesCompromissadas;


public class OperacoesCompromissadasFixUtils extends UtilitarioCadastro<OperacoesCompromissadas> {

    public OperacoesCompromissadasFixUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaOperacoesCompromissadas pagina = new PaginaOperacoesCompromissadas();

    @Override
    public void preencheDados(OperacoesCompromissadas dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, OperacoesCompromissadas.class);
        /**/
        selecionaAba(pagina.dadosDaMovimentacao().dadosDaMovimentacao);
        selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDaOperacaoOriginal, dados.dataDaOperacaoOriginal());
        preenche(pagina.dadosDaMovimentacao().dataDeVencimento, dados.dataDeVencimento());
        preenche(pagina.dadosDaMovimentacao().carteira, dados.carteira());
        selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo());
        selecionaUm(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        selecionaUm(pagina.dadosDaMovimentacao().moeda, dados.moeda());
        selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        preenche(pagina.dadosDaMovimentacao().serie, dados.serie());
        preenche(pagina.dadosDaMovimentacao().porcentagemDaSerie, dados.porcentagemDaSerie());
        preenche(pagina.dadosDaMovimentacao().puInicio, dados.puInicio());
        preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        preenche(pagina.dadosDaMovimentacao().financeiroDeIda, dados.financeiroDeIda());
        selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());
        selecionaUm(pagina.dadosDaMovimentacao().livreMovimentacao, dados.livreMovimentacao());
        /**/
        selecionaAba(pagina.lastroDeCompra().lastroDeCompra);
        preenche(pagina.lastroDeCompra().tituloSelicPu550Titulo, dados.tituloSelicPu550TituloCompra());
        selecionaUm(pagina.lastroDeCompra().titulo, dados.titulo());
        selecionaUm(pagina.lastroDeCompra().emissao, dados.emissaoCompra());
        preenche(pagina.lastroDeCompra().dataDaEmissao, dados.dataDaEmissaoCompra());
        preenche(pagina.lastroDeCompra().dataDeVencimento, dados.dataDeVencimentoCompra());
        selecionaUm(pagina.lastroDeCompra().calcular, dados.calcularCompra());
        preenche(pagina.lastroDeCompra().financeiroIda, dados.financeiroIdaCompra());
        preenche(pagina.lastroDeCompra().pu550Pu, dados.pu550PuCompra());
        preenche(pagina.lastroDeCompra().quantidade, dados.quantidadeCompra());
        preenche(pagina.lastroDeCompra().financeiroDeIdaCalculado, dados.financeiroDeIdaCalculadoCompra());
        preenche(pagina.lastroDeCompra().isin, dados.isinCompra());
        preenche(pagina.lastroDeCompra().codigoSelicCetipCompra, dados.codigoSelicCetipCompra());
        selecionaUm(pagina.lastroDeCompra().esferaDaEmissao, dados.esferaDaEmissaoCompra());
        selecionaUm(pagina.lastroDeCompra().empresaLigada, dados.empresaLigadaCompra());
        selecionaUm(pagina.lastroDeCompra().descricaoBacen, dados.descricaoBacenCompra());
        preenche(pagina.lastroDeCompra().codigoCBLCCompra, dados.codigoCBLCCompra());
        selecionaUm(pagina.lastroDeCompra().localidade, dados.localidadeCompra());
        selecionaUm(pagina.lastroDeCompra().emissorParaPerfilMensal, dados.emissorParaPerfilMensalCompra());
        /**/
        selecionaAba(pagina.lastroDeVenda().lastroDeVenda);
        selecionaUm(pagina.lastroDeVenda().tituloSelicPu550TituloVenda, dados.tituloSelicPu550TituloVenda());
        selecionaUm(pagina.lastroDeVenda().emissaoVenda, dados.emissaoVenda());
        preenche(pagina.lastroDeVenda().codigoDaOperacaoVenda, dados.codigoDaOperacaoVenda());
        preenche(pagina.lastroDeVenda().dataDeEmissaoVenda, dados.dataDeEmissaoVenda());
        preenche(pagina.lastroDeVenda().dataDeVencimentoVenda, dados.dataDeVencimentoVenda());
        selecionaUm(pagina.lastroDeVenda().calcularVenda, dados.calcularVenda());
        preenche(pagina.lastroDeVenda().financeiroIdaVenda, dados.financeiroIdaVenda());
        preenche(pagina.lastroDeVenda().pu550PuVenda, dados.pu550PuVenda());
        preenche(pagina.lastroDeVenda().quantidadeVenda, dados.quantidadeVenda());
        preenche(pagina.lastroDeVenda().financeiroDeIdaCalculadoVenda, dados.financeiroDeIdaCalculadoVenda());
        preenche(pagina.lastroDeVenda().isinVenda, dados.isinVenda());
        preenche(pagina.lastroDeVenda().codigoSelicCetipVenda, dados.codigoSelicCetipVenda());
        preenche(pagina.lastroDeVenda().codigoCBLCVenda, dados.codigoCBLCVenda());
    }

    @Override
    public void consultar(OperacoesCompromissadas dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, OperacoesCompromissadas.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }



    @Override
    protected String transacao() {
        return "Caminho da Página";
    }


}
