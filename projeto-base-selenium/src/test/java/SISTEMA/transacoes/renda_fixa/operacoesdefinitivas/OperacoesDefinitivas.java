package SISTEMA.transacoes.renda_fixa.operacoesdefinitivas;

import lombok.Data;

@Data
public class OperacoesDefinitivas {
    private String modalidadeDomovimento;
    private String dataDoMovimento;
    private String dataDaCompra;
    private String carteira;
    private String titulo;
    private String emissao;
    private String estoque;
    private String ativaPassiva;
    private String categoria;
    private String riscoBeneficio;
    private String condicoesDeNegociacao;
    private String pu;
    private String quantidade;
    private String eventoEmAtraso;
}
