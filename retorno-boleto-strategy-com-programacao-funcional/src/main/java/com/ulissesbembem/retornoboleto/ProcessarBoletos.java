package com.ulissesbembem.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {

    public void processar(URI nomeArquivo) {
        // Seleciona a estratégia de leitura baseada no nome do arquivo
        Function<String[], Boleto> estrategia = selecionarEstrategia(nomeArquivo);

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo))) {
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = estrategia.apply(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    private Function<String[], Boleto> selecionarEstrategia(URI nomeArquivo) {
        String path = nomeArquivo.toString();
        if (path.contains("banco-brasil")) {
            return vetor -> {
                String banco = vetor[1];
                LocalDate vencimento = LocalDate.parse(vetor[2], Boleto.FORMATO_DATA);
                LocalDateTime pagamento = vencimento.atStartOfDay();
                double valor = Double.parseDouble(vetor[5]);
                double multa = Double.parseDouble(vetor[6]);
                double juros = Double.parseDouble(vetor[7]);
                String codigo = vetor[0];
                return new Boleto(banco, "", vencimento, pagamento, valor, multa, juros, codigo);
            };
        }
        if (path.contains("bradesco")) {
            return vetor -> {
                String banco = vetor[1];
                String agencia = vetor[2];
                LocalDate vencimento = LocalDate.parse(vetor[4], Boleto.FORMATO_DATA);
                LocalDateTime pagamento = LocalDateTime.parse(vetor[5], Boleto.FORMATO_DATA_HORA);
                double valor = Double.parseDouble(vetor[7]);
                double multa = Double.parseDouble(vetor[8]);
                double juros = Double.parseDouble(vetor[9]);
                String codigo = vetor[0];
                return new Boleto(banco, agencia, vencimento, pagamento, valor, multa, juros, codigo);
            };
        }
        throw new UnsupportedOperationException("Banco não identificado: " + nomeArquivo);
    }
}

