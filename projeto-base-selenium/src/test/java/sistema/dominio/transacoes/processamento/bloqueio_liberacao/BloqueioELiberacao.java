package sistema.dominio.transacoes.processamento.bloqueio_liberacao;

import lombok.Data;

@Data
public class BloqueioELiberacao {

    private String dataBloqueioLiberacao;
    private String tipo;
    private String carteira;
    private String bloqueado;
    private String liberacaoContabil;
    private String motivoDoBloqueio;
    private String motivoDoDesbloqueio;
}
