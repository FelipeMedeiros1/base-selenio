package sistema.transacoes.fundos.movimentacao.automacao;

public record Movimentacao(
        int id,
        String dataDoMovimento,
        String carteira,
        String fundo,
        String NegociacaoDeCotaAMercado,
        String modalidadeDoMovimento,
        String subsegmentoPREVIC,
        String dataDaAplicacao,
        String dataDeCotizacao,
        String liquidacaoDoMovimento,
        String estoque,
        String quantidade,
        String financeiro
) {

}
