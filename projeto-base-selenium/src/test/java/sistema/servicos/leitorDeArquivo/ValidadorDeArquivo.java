package sistema.servicos.leitorDeArquivo;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import sistema.servicos.leitorDeArquivo.config_xls.BuscadorDeArquivoXls;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static sistema.servicos.leitorDeArquivo.config_csv.LeitorCSV.lerCSV;
import static sistema.servicos.utils.LogUtil.info;

public class ValidadorDeArquivo {

    public static void compararCSV(String arquivoEstatico, String arquivoGerado) {
        List<String[]> dadosEstaticos = lerCSV(arquivoEstatico);
        List<String[]> dadosGerados = lerCSV(arquivoGerado);

        if (dadosEstaticos.size() != dadosGerados.size()) {
            info("Erro: Os arquivos CSV têm tamanhos diferentes.");
            return;
        }

        for (int i = 0; i < dadosEstaticos.size(); i++) {
            String[] linha1 = dadosEstaticos.get(i);
            String[] linha2 = dadosGerados.get(i);

            for (int j = 0; j < linha1.length; j++) {
                if (!linha1[j].equalsIgnoreCase(linha2[j])) {
                    info("Diferença na coluna " + (j + 1) + " da linha " + (i + 1) + ":");
                    info("Arquivo 1: " + linha1[j]);
                    info("Arquivo 2: " + linha2[j]);
                }
            }
        }

        info("Arquivos CSV validados com sucesso.");
    }

    public static void validaCSV(String nomeDoArquivoZip) {
        String caminhoArquivoGerado = "C:\\Users\\felipem.medeiros\\Downloads\\" + nomeDoArquivoZip; // Substitua pelo caminho real do arquivo ZIP
        String caminhoArquivoEstatico = null;

        try {
            // Obtém a classe atual (a classe que está executando o método)
            Class<?> classeAtual = new Object() {
            }.getClass().getEnclosingClass();
            // Obtém o caminho do pacote da classe atual
            String caminhoPacote = classeAtual.getPackage().getName().replace('.', '/');
            // Constrói o caminho completo do arquivo estático
            caminhoArquivoEstatico = "/" + caminhoPacote + "/" + nomeDoArquivoZip.replace(".zip", ".csv");

            // Descompacta o arquivo ZIP
            descompactarZip(caminhoArquivoGerado, "C:\\Users\\felipem.medeiros\\Downloads"); // Substitua pelo caminho onde você deseja descompactar

            // Lê os arquivos CSV
            List<String[]> dadosEstaticos = lerCSV(caminhoArquivoEstatico);
            List<String[]> dadosGerados = lerCSV("C:\\Users\\felipem.medeiros\\Downloads\\" + nomeDoArquivoZip.replace(".zip", ".csv")); // Substitua pelo caminho do arquivo CSV descompactado

            // Verifica se os arquivos têm o mesmo número de linhas
            if (dadosEstaticos.size() != dadosGerados.size()) {
                throw new CsvValidationException("Erro: Os arquivos CSV têm tamanhos diferentes.");
            }

            // Compara as linhas dos arquivos
            for (int i = 0; i < dadosEstaticos.size(); i++) {
                String[] linha1 = dadosEstaticos.get(i);
                String[] linha2 = dadosGerados.get(i);

                for (int j = 0; j < linha1.length; j++) {
                    if (!linha1[j].equalsIgnoreCase(linha2[j])) {
                        info("Diferença na coluna " + (j + 1) + " da linha " + (i + 1) + ":");
                        info("Arquivo 1: " + linha1[j]);
                        info("Arquivo 2: " + linha2[j]);
                    }
                }
            }

            info("Arquivos CSV validados com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    private static void descompactarZip(String caminhoArquivoZip, String caminhoDestino) throws IOException {
        try (ZipArchiveInputStream zis = new ZipArchiveInputStream(new FileInputStream(caminhoArquivoZip))) {
            ArchiveEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String nomeArquivo = entry.getName();
                String caminhoCompleto = caminhoDestino + "/" + nomeArquivo;

                if (entry.isDirectory()) {
                    // Cria o diretório se ele não existir
                    new java.io.File(caminhoCompleto).mkdirs();
                } else {
                    // Cria o arquivo e copia o conteúdo do ZIP
                    try (FileOutputStream fos = new FileOutputStream(caminhoCompleto)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
            }
        }
    }
}

//package sistema.servicos.leitorDeArquivo;
//
//import sistema.servicos.leitorDeArquivo.config_xls.BuscadorDeArquivoXls;
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//import static sistema.servicos.leitorDeArquivo.config_csv.LeitorCSV.lerCSV;
//import static sistema.servicos.utils.LogUtil.info;
//
//public class ValidadorDeArquivo {
//
//    public static void compararCSV(String arquivoEstatico, String arquivoGerado) {
//        List<String[]> dadosEstaticos = lerCSV(arquivoEstatico);
//        List<String[]> dadosGerados = lerCSV(arquivoGerado);
//
//        if (dadosEstaticos.size() != dadosGerados.size()) {
//            info("Erro: Os arquivos CSV têm tamanhos diferentes.");
//            return;
//        }
//
//        for (int i = 0; i < dadosEstaticos.size(); i++) {
//            String[] linha1 = dadosEstaticos.get(i);
//            String[] linha2 = dadosGerados.get(i);
//
//            for (int j = 0; j < linha1.length; j++) {
//                if (!linha1[j].equalsIgnoreCase(linha2[j])) {
//                    info("Diferença na coluna " + (j + 1) + " da linha " + (i + 1) + ":");
//                    info("Arquivo 1: " + linha1[j]);
//                    info("Arquivo 2: " + linha2[j]);
//                }
//            }
//        }
//
//        info("Arquivos CSV validados com sucesso.");
//    }
//
//    public static void validaCSV(String nomeDoArquivo) {
//        String caminhoArquivoGerado = "C:\\Users\\felipem.medeiros";
//        String caminhoArquivoEstatico = null;
//        try {
//            caminhoArquivoEstatico = new FileInputStream(BuscadorDeArquivoXls.encontrarCaminhoDoArquivo(nomeDoArquivo).toString()).toString();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try (CSVReader arquivoGerado = new CSVReader(new FileReader(caminhoArquivoGerado));
//             CSVReader arquivoEstatico = new CSVReader(new FileReader(caminhoArquivoEstatico))) {
//            // Ler todas as linhas do arquivo
//            String[] nextRecord1;
//            String[] nextRecord2 = new String[0];
//
//            // Verificar se os arquivos têm o mesmo número de linhas
//            int contadorLinhas = 0;
//            while ((nextRecord1 = arquivoGerado.readNext()) != null && (nextRecord2 = arquivoEstatico.readNext()) != null) {
//                contadorLinhas++;
//                // Comparar o conteúdo das linhas
//                if (!comparaLinhasCSV(nextRecord1, nextRecord2)) {
//                    throw new CsvValidationException("Erro: Conteúdo dos arquivos CSV são diferentes na linha " + contadorLinhas + ".");
//                }
//            }
//
//            // Verificar se os arquivos têm o mesmo número de linhas
//            if (nextRecord1 != null || nextRecord2 != null) {
//                throw new CsvValidationException("Erro: Os arquivos CSV têm tamanhos diferentes.");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (CsvValidationException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static boolean comparaLinhasCSV(String[] coluna1, String[] coluna2) {
//        // Verificar se o número de colunas é o mesmo
//        if (coluna1.length != coluna2.length) {
//            return false;
//        }
//
//        // Comparar o conteúdo de cada coluna
//        for (int i = 0; i < coluna1.length; i++) {
//            if (!coluna1[i].equalsIgnoreCase(coluna2[i])) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//}