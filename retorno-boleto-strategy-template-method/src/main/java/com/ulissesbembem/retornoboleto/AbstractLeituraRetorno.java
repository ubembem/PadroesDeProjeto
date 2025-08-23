package com.ulissesbembem.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLeituraRetorno implements LeituraRetorno {

    @Override
    public final List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                boletos.add(processarLinha(campos)); // operação primitiva (Strategy)
            }
            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException("Erro lendo arquivo: " + nomeArquivo, e);
        }
    }

    // continua abstrato para as subclasses definirem como montar o Boleto a partir dos campos
    @Override
    public abstract Boleto processarLinha(String[] campos);
}
