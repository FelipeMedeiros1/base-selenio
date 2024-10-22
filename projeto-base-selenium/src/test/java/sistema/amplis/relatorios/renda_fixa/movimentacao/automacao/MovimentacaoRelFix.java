package sistema.amplis.relatorios.renda_fixa.movimentacao.automacao;

public record MovimentacaoRelFix(
        int id,
        String dataInicio,
        String dataFinal,
        String[] modalidadeDeMovimento,
        String titulo,
        String emissao,
        String[] carteira,
        String saida,
        String idioma,
        String moeda,
        String tipoRelatorio


) {

}
