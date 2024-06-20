package sistema.servicos.leitorDeArquivo.config_csv;


import sistema.servicos.leitorDeArquivo.config_xls.BuscadorDeArquivoXls;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ValidaArquivo {
    // Caminho do arquivo CSV baixado


    public static void validaCSV(String nomeDoArquivo){


        String caminhoArquivoGerado = "C:\\Users\\felipem.medeiros";
        String caminhoArquivoEstatico = null;
        try {
            caminhoArquivoEstatico = new FileInputStream(BuscadorDeArquivoXls.encontrarCaminhoDoArquivo(nomeDoArquivo).toString()).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (CSVReader arquivoGerado = new CSVReader(new FileReader(caminhoArquivoGerado));
             CSVReader arquivoEstatico = new CSVReader(new FileReader(caminhoArquivoEstatico))) {
            // Ler todas as linhas do arquivo
            String[] nextRecord1;
            String[] nextRecord2;


            while ((nextRecord1 = arquivoGerado.readNext()) != null && (nextRecord2 = arquivoEstatico.readNext()) != null) {
                // Comparar o conteúdo das linhas
                if (!comparaLinhasCSV(nextRecord1, nextRecord2)) {
                    throw new CsvValidationException("Erro: Conteúdo dos arquivos CSV são diferentes.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean comparaLinhasCSV(String[] coluna1, String[] coluna2) {
        // Verificar se o número de colunas é o mesmo
        if (coluna1.length != coluna2.length) {
            return false;
        }

        // Comparar o conteúdo de cada coluna
        for (int i = 0; i < coluna1.length; i++) {
            if (!coluna1[i].equals(coluna2[i])) {
                return false;
            }
        }

        return true;
    }
}
