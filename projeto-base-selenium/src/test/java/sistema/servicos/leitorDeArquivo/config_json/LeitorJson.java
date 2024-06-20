package sistema.servicos.leitorDeArquivo.config_json;


import sistema.amplis.transacoes.processamento.processamento.automacao.Processamento;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class LeitorJson {

    public static <T> T carregarDados(String caminhoArquivo, int posicao, Class<T> classe) {
        ObjectMapper mapearObjeto = new ObjectMapper();
        try {
            JsonNode jsonCarregado = mapearObjeto.readTree(new File("src/test/java/sistema/amplis/" + caminhoArquivo));
            JsonNode objetoDesejado = jsonCarregado.get(posicao - 1);
            return mapearObjeto.treeToValue(objetoDesejado, classe);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String caminhoJson(String nomeArquivo) {
        Path start = Paths.get("projeto-base-selenium/src/test/");
        final String[] result = {""};

        try {
            Files.walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.getFileName().toString().equals(nomeArquivo)) {
                        result[0] = file.toAbsolutePath().toString();
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result[0];
    }

    public static void main(String[] args) {

        String json = "C:\\Users\\felipem.medeiros\\Documents\\cursos\\SELENIUM\\base-selenio\\projeto-base-selenium\\src\\test\\resources\\Proc.json";
        var processamento = LeitorJson.carregarDados(json, 1, Processamento.class);
        System.out.println(processamento);

        String filePath = caminhoJson("json/Proc.json");
        if (!filePath.isEmpty()) {
            System.out.println("Arquivo encontrado em: " + filePath);
        } else {
            System.out.println("Arquivo não encontrado.");
        }

    }


}

