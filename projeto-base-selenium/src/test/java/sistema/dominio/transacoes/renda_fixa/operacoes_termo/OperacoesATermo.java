package sistema.dominio.transacoes.renda_fixa.operacoes_termo;

import lombok.Data;

@Data
public class OperacoesATermo {
    private String modalidadeDoMovimento;
    private String dataDoMovimento;
    private String dataDaCompra;
    private String dataDoVencimentoDoTermo;
    private String carteira;
    private String titulo;
    private String emissao;
    private String subsegmentoPrevic;
    private String estoque;
    private String nivelDeRisco;
    private String ativaPassiva;
    private String categoria;
    private String riscoBeneficio;
    private String condicaoDeNegociacao;
    private String taxaDeNegociacao;
    private String pu;
    private String quantidade;
    private String rendimento;
    private String irDaOperacao;
    private String iofDaOperacao;
    private String eventoEmAtraso;

    private String custodiante;
    private String localDeCustodia;
    private String contaDeCustodia;
}
