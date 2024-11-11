package servico.leitorDeArquivo.config_json;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.List;

public class LeitorJson {

    public static <T> T carregarDados(String caminhoArquivo, int posicao, Class<T> classe) {
        ObjectMapper mapearObjeto = new ObjectMapper();
        try {
            JsonNode jsonCarregado = mapearObjeto.readTree(new File("src/test/java/" + caminhoArquivo));
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


    public static <M> M converteParaJson(String json, Class<M> classe) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<M>>() {}.getType();
        List<M> objetos = gson.fromJson(json, listType);
        if (!objetos.isEmpty()) {
            return objetos.get(0); // Retorna o primeiro objeto da lista
        } else {
            return null; // Ou lance uma exceção se a lista estiver vazia
        }
    }


}

