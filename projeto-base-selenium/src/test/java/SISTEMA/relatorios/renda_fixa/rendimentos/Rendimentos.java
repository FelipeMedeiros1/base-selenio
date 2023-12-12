package SISTEMA.relatorios.renda_fixa.rendimentos;

import lombok.Data;

@Data
public class Rendimentos {
    private String dataInicial;
    private String dataFinal;
    private String carteira;
    private String saida;
    private String moeda;
}
