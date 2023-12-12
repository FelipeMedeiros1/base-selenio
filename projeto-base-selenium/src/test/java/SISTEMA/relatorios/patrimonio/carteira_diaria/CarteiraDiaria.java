package SISTEMA.relatorios.patrimonio.carteira_diaria;

import lombok.Data;

@Data
public class CarteiraDiaria {
    private String dataInicio;
    private String dataFinal;
    private String[] tipoDePosicao;
    private String tipoDeConsolidacao;
    private String custoMedio;
    private String[] carteira;
    private String tipoDoRelatorio;
    private String saida;
    private String nomeArquivo;

}
