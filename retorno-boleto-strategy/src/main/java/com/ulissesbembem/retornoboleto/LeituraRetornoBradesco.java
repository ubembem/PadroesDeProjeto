package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public Boleto processarLinha(String[] vetor) {
        String id = vetor[0];
        String banco = vetor[1];
        String agencia = vetor[2];
        String conta = vetor[3];
        LocalDate dataVencimento = LocalDate.parse(vetor[4], Boleto.FORMATO_DATA);
        LocalDateTime dataPagamento = LocalDateTime.parse(vetor[5], Boleto.FORMATO_DATA_HORA);
        String cpfCliente = vetor[6];
        double valor = Double.parseDouble(vetor[7]);
        double multa = Double.parseDouble(vetor[8]);
        double juros = Double.parseDouble(vetor[9]);

        return new Boleto(id, banco, agencia, conta,
                dataVencimento, dataPagamento,
                cpfCliente, valor, multa, juros);
    }
}

