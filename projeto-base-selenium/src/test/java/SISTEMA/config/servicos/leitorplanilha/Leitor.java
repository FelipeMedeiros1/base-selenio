package SISTEMA.config.servicos.leitorplanilha;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Leitor<T> {
    private static String caminho;

    public static <T> T carregarDados(String nomeArquivo, String chavePrimaria, String nomePlanilha, Class<T> clazz) {
        T modeloDeCadastro = null;
        caminho = nomeArquivo + ".xlsx";

        try {
            Workbook pastaDeTrabalho = WorkbookFactory.create(new FileInputStream(CaminhoDoArquivo.encontrarCaminhoDoArquivo(caminho).toString()));
            Sheet planilha = pastaDeTrabalho.getSheet(nomePlanilha);
            Row cabecalho = planilha.getRow(0);

            int indiceColunaChavePrimaria = -1;
            Map<String, Integer> indicesColuna = new HashMap<>();

            for (int i = 0; i < cabecalho.getLastCellNum(); i++) {
                Cell celula = cabecalho.getCell(i);
                if (celula != null) {
                    String nomeDaColuna = celula.getStringCellValue();
                    indicesColuna.put(nomeDaColuna, i);

                    if (celula.getStringCellValue().startsWith("pk")) {
                        if (chavePrimaria.equals(nomeDaColuna)) {
                            indiceColunaChavePrimaria = i;
                        }
                    }
                }
            }

            if (indiceColunaChavePrimaria == -1) {
                throw new IllegalArgumentException("Chave primária não encontrada na planilha: " + chavePrimaria);
            }

            for (int linha = 1; linha <= planilha.getLastRowNum(); linha++) {
                Row dadosLinha = planilha.getRow(linha);

                if (dadosLinha != null) {
                    Cell celulaChavePrimaria = dadosLinha.getCell(indiceColunaChavePrimaria);

                    if (celulaChavePrimaria != null && celulaChavePrimaria.getStringCellValue().equals(chavePrimaria)) {
                        modeloDeCadastro = clazz.getDeclaredConstructor().newInstance();
                        Field[] fields = clazz.getDeclaredFields();

                        for (Field campo : fields) {
                            campo.setAccessible(true);
                            String nomeCampo = campo.getName();

                            if (indicesColuna.containsKey(nomeCampo)) {
                                int indiceColuna = indicesColuna.get(nomeCampo);
                                Cell dadosCelula = dadosLinha.getCell(indiceColuna);

                                if (dadosCelula != null) {
                                    try {
                                        if (campo.getType().isArray() && campo.getType().getComponentType() == String.class) {
                                            campo.set(modeloDeCadastro, dadosCelula.getStringCellValue().split(","));
                                        } else {
                                            campo.set(modeloDeCadastro, dadosCelula.getStringCellValue());
                                        }
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        // Se quiser continuar procurando para possíveis duplicatas
                        // remover o break;
                    }
                } else {
                    throw new IllegalArgumentException("Os dados não foram carregados...");
                }
            }
            pastaDeTrabalho.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return modeloDeCadastro;
    }
}
