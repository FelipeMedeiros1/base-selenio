package amplis.transacoes.rendafixa.operacoes_definitivas.automacao;
public record OperacoesDefinitivas(
        int id,
        String dataDoMovimento,
        String modalidadeDomovimento,
        String dataDaCompra,
        String carteira,
        String titulo,
        String emissao,
        String estoque,
        String ativaPassiva,
        String categoria,
        String riscoBeneficio,
        String condicoesDeNegociacao,
        String pu,
        String quantidade,
        String financeiro,
        String rendimento,
        String eventoEmAtraso
) {

}
