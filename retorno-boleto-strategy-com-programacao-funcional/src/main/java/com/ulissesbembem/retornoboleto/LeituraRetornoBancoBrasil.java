package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public Boleto processarLinha(String[] vetor) {
        String banco = vetor[1]; // código do banco
        String agencia = "";     // Banco do Brasil não fornece agência no CSV
        LocalDate vencimento = LocalDate.parse(vetor[2], Boleto.FORMATO_DATA);
        LocalDateTime pagamento = vencimento.atStartOfDay(); // sem hora, começa do 00:00
        double valor = Double.parseDouble(vetor[5]);
        double multa = Double.parseDouble(vetor[6]);
        double juros = Double.parseDouble(vetor[7]);
        String codigo = vetor[0]; // id ou código do boleto

        return new Boleto(banco, agencia, vencimento, pagamento, valor, multa, juros, codigo);
    }

}
