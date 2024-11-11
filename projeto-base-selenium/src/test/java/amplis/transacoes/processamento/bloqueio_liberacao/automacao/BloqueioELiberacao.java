package amplis.transacoes.processamento.bloqueio_liberacao.automacao;

public record BloqueioELiberacao(
        int id,
        String dataBloqueioLiberacao,
        String tipo,
        String fitroCarteira,
        String carteira,
        String bloqueado,
        String liberacaoContabil,
        String motivoDoBloqueio,
        String motivoDoDesbloqueio
) {


}
