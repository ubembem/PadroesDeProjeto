package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;

public class LeituraRetornoBancoBrasil extends AbstractLeituraRetorno {

    /**
     * Formato esperado (BB):
     * 0:id ; 1:codBanco ; 2:dataVenc(dd/MM/yyyy) ; 3:dataPag(dd/MM/yyyy) ; 4:cpf ; 5:valor ; 6:multa ; 7:juros
     */
    @Override
    public Boleto processarLinha(String[] c) {
        Boleto b = new Boleto();
        b.setId(Integer.parseInt(c[0]));
        b.setCodBanco(c[1]);
        b.setDataVencimento(LocalDate.parse(c[2], Boleto.FORMATO_DATA));
        b.setDataPagamento(LocalDate.parse(c[3], Boleto.FORMATO_DATA).atTime(0, 0, 0));
        b.setCpfCliente(c[4]);
        b.setValor(Double.parseDouble(c[5]));
        b.setMulta(Double.parseDouble(c[6]));
        b.setJuros(Double.parseDouble(c[7]));
        // BB não fornece agência/conta no CSV de exemplo
        return b;
    }
}