package com.ulissesbembem.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProcessarBoletos {
    public void processar(URI nomeArquivo){
        LeituraRetorno leitura = EstrategiaBoletoFactory.newStrategy(nomeArquivo);

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = leitura.processarLinha(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
}
