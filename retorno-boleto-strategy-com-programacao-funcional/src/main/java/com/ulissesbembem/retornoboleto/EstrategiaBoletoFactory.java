package com.ulissesbembem.retornoboleto;

import java.net.URI;

class EstrategiaBoletoFactory {
    private EstrategiaBoletoFactory(){}

    static LeituraRetorno newStrategy(URI nomeArquivo){
        if(nomeArquivo.toString().contains("banco-brasil")){
            return new LeituraRetornoBancoBrasil();
        }

        if(nomeArquivo.toString().contains("bradesco")){
            return new LeituraRetornoBradesco();
        }

        throw new UnsupportedOperationException("Banco não identificado para o arquivo " + nomeArquivo);
    }
}


