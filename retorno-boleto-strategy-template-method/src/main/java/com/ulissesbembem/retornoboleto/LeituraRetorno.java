package com.ulissesbembem.retornoboleto;

import java.util.List;

public interface LeituraRetorno {
    List<Boleto> lerArquivo(String nomeArquivo);
    Boleto processarLinha(String[] campos);
}



