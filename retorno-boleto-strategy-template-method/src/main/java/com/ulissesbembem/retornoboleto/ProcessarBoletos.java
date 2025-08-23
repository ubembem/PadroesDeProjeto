package com.ulissesbembem.retornoboleto;

import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = Objects.requireNonNull(leituraRetorno, "Estratégia de leitura não pode ser nula");
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = Objects.requireNonNull(leituraRetorno, "Estratégia de leitura não pode ser nula");
    }

    public void processar(URI uriArquivo) {
        Objects.requireNonNull(uriArquivo, "URI do arquivo não pode ser nula");
        String caminho = Paths.get(uriArquivo).toString();
        List<Boleto> boletos = leituraRetorno.lerArquivo(caminho);
        boletos.forEach(System.out::println);
    }
}