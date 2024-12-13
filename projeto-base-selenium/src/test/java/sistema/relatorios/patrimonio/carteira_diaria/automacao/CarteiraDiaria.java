package amplis.relatorios.patrimonio.carteira_diaria.automacao;

public record CarteiraDiaria(
        int id,
        String dataInicio,
        String dataFinal,
        String[] tipoDePosicao,
        String tipoDeConsolidacao,
        String custoMedio,
        String[] carteira,
        String tipoDoRelatorio,
        String saida

) {

}
