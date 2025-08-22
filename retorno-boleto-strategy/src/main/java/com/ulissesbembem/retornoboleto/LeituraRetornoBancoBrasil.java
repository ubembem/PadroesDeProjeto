package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public Boleto processarLinha(String[] vetor) {
        String id = vetor[0];               // 1
        String banco = vetor[1];            // 001
        LocalDate dataVencimento = LocalDate.parse(vetor[2], Boleto.FORMATO_DATA); // 23/12/2019
        LocalDateTime dataPagamento = LocalDate.parse(vetor[3], Boleto.FORMATO_DATA).atStartOfDay(); // 31/07/2019
        String cpfCliente = vetor[4];       // 12345678911
        double valor = Double.parseDouble(vetor[5]); // 106.2
        double multa = Double.parseDouble(vetor[6]); // 0
        double juros = Double.parseDouble(vetor[7]); // 0
        String agencia = null;              // Não vem no CSV
        String conta = null;                // Não vem no CSV

        return new Boleto(id, banco, agencia, conta,
                dataVencimento, dataPagamento,
                cpfCliente, valor, multa, juros);
    }
}
