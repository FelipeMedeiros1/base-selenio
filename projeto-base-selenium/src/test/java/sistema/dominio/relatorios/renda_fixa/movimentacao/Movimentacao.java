package sistema.dominio.relatorios.renda_fixa.movimentacao;

import lombok.Data;

@Data
public class Movimentacao {
    private String dataInicio;
    private String dataFinal;
    private String[] modalidadeDeMovimento;
    private String titulo;
    private String emissao;
    private String[] carteira;
    private String saida;
    private String idioma;
    private String moeda;
    private String tipoRelatorio;
}
