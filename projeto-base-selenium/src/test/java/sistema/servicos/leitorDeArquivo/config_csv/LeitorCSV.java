package sistema.servicos.leitorDeArquivo.config_csv;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {

    public static List<String[]> lerCSV(String csvFilePath, char separador) {
        List<String[]> dados = new ArrayList<>();

        try (CSVReader leitor = new CSVReaderBuilder(new FileReader(csvFilePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(separador).build()).build()) {
            String[] nextLine;
            while ((nextLine = leitor.readNext()) != null) {
                dados.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Erro ao ler o arquivo CSV: " + e.getMessage(), e);
        }
        return dados;
    }

    // Método para ler CSV com separador padrão (';')
    public static List<String[]> lerCSV(String csvFilePath) {
        return lerCSV(csvFilePath, ';');
    }
}