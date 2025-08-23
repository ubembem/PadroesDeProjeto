package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBradesco extends AbstractLeituraRetorno {

    /**
     * Formato esperado (Bradesco):
     * 0:id ; 1:codBanco ; 2:agencia ; 3:conta ; 4:dataVenc(dd/MM/yyyy) ;
     * 5:dataPag(dd/MM/yyyy HH:mm:ss) ; 6:cpf ; 7:valor ; 8:multa ; 9:juros
     */
    @Override
    public Boleto processarLinha(String[] c) {
        Boleto b = new Boleto();
        b.setId(Integer.parseInt(c[0]));
        b.setCodBanco(c[1]);
        b.setAgencia(c[2]);
        b.setContaBancaria(c[3]);
        b.setDataVencimento(LocalDate.parse(c[4], Boleto.FORMATO_DATA));
        b.setDataPagamento(LocalDateTime.parse(c[5], Boleto.FORMATO_DATA_HORA));
        b.setCpfCliente(c[6]);
        b.setValor(Double.parseDouble(c[7]));
        b.setMulta(Double.parseDouble(c[8]));
        b.setJuros(Double.parseDouble(c[9]));
        return b;
    }
}