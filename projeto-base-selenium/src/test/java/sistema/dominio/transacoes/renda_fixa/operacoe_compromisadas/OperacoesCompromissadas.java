package sistema.dominio.transacoes.renda_fixa.operacoe_compromisadas;

import lombok.Data;

@Data
public class OperacoesCompromissadas {
    private String modalidadeDoMovimento;
    private String dataDoMovimento;
    private String dataDaOperacaoOriginal;
    private String dataDeVencimento;
    private String carteira;
    private String titulo;
    private String estoque;
    private String moeda;
    private String categoria;
    private String riscoBeneficio;
    private String condicoesDeNegociacao;
    private String serie;
    private String porcentagemDaSerie;
    private String puInicio;
    private String quantidade;
    private String financeiroDeIda;
    private String rendimento;
    private String eventoEmAtraso;
    private String livreMovimentacao;
    private String tituloSelicPu550TituloCompra;
    private String tituloCompra;
    private String emissaoCompra;
    private String dataDaEmissaoCompra;
    private String dataDeVencimentoCompra;
    private String calcularCompra;
    private String financeiroIdaCompra;
    private String pu550PuCompra;
    private String quantidadeCompra;
    private String financeiroDeIdaCalculadoCompra;
    private String isinCompra;
    private String codigoSelicCetipCompra;
    private String esferaDaEmissaoCompra;
    private String empresaLigadaCompra;
    private String descricaoBacenCompra;
    private String codigoCBLCCompra;
    private String localidadeCompra;
    private String emissorParaPerfilMensalCompra;
    private String tituloSelicPu550TituloVenda;
    private String emissaoVenda;
    private String codigoDaOperacaoVenda;
    private String dataDeEmissaoVenda;
    private String dataDeVencimentoVenda;
    private String calcularVenda;
    private String financeiroIdaVenda;
    private String pu550PuVenda;
    private String quantidadeVenda;
    private String financeiroDeIdaCalculadoVenda;
    private String isinVenda;
    private String codigoSelicCetipVenda;
    private String codigoCBLCVenda;
}
