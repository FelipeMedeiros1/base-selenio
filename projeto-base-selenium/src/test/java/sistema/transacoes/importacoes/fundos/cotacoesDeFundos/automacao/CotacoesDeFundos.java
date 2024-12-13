package amplis.transacoes.importacoes.fundos.cotacoesDeFundos.automacao;

public record CotacoesDeFundos(

        int id,
        String dataInicial,
        String dataFinal,
        String nomeDoArquivo,
        String tipoImportacao,
        String layoutImportacao

) {
}
