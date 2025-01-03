package utils.leitorDeArquivo.config_xls;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LeitorXls<T> {

    public static <T> T carregarDados(String nomeArquivo, String chavePrimaria, String repositorio, Class<T> clazz) {
        T modeloDeCadastro = null;
        String caminho = nomeArquivo +".xlsx";

        try {
            Workbook pastaDeTrabalho = WorkbookFactory.create(new FileInputStream(BuscadorDeArquivoXls.encontrarCaminhoDoArquivo(caminho).toString()));
            Sheet planilha = pastaDeTrabalho.getSheet(repositorio);
            Row cabecalho = planilha.getRow(0);

            int indiceColunaChavePrimaria = -1;
            Map<String, Integer> indicesColuna = new HashMap<>();
            for (int i = 0; i < cabecalho.getLastCellNum(); i++) {
                Cell celula = cabecalho.getCell(i);
                // Defina o valor da célula da chave primária para o valor da chavePrimaria digitada
                if (celula != null) {
                    String nomeDaColuna = celula.getStringCellValue();
                    if (celula.getStringCellValue().startsWith("pk")) {
                        celula.setCellValue(chavePrimaria);
                        nomeDaColuna = chavePrimaria;
                        if (nomeDaColuna.equals(chavePrimaria)) {
                            indiceColunaChavePrimaria = i;
                        }
                    }
                    indicesColuna.put(nomeDaColuna, i);
                }
            }
            if (indiceColunaChavePrimaria == -1) {
                throw new IllegalArgumentException("Chave primária não encontrada na planilha: " + chavePrimaria);
            }

            for (int linha = 1; linha <= planilha.getLastRowNum(); linha++) {
                Row dadosLinha = planilha.getRow(linha);
                if (dadosLinha != null) {  // Verificar se dadosLinha não é nulo
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
                        break;
                    }
                } else
                    throw new IllegalArgumentException("Os dados não foram carregados...");
            }
            pastaDeTrabalho.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return modeloDeCadastro;
    }

}













