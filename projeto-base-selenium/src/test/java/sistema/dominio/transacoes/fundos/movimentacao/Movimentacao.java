package sistema.dominio.transacoes.fundos.movimentacao;

import lombok.Data;

@Data
public class Movimentacao {
    private String dataDoMovimento;
    private String carteira;
    private String fundo;
    private String modalidadeDoMovimento;
    private String subsegmentoPREVIC;
    private String dataDaAplicacao;
    private String dataDeCotizacao;
    private String liquidacaoDoMovimento;
    private String estoque;
    private String quantidade;
    private String financeiro;
}
