package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public Boleto processarLinha(String[] vetor) {
        String banco = vetor[1];
        String agencia = vetor[2];
        LocalDate vencimento = LocalDate.parse(vetor[4], Boleto.FORMATO_DATA);
        LocalDateTime pagamento = LocalDateTime.parse(vetor[5], Boleto.FORMATO_DATA_HORA);
        double valor = Double.parseDouble(vetor[7]);
        double multa = Double.parseDouble(vetor[8]);
        double juros = Double.parseDouble(vetor[9]);
        String codigo = vetor[0];

        return new Boleto(banco, agencia, vencimento, pagamento, valor, multa, juros, codigo);
    }

}

