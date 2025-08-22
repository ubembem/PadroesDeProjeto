package com.ulissesbembem.retornoboleto;

public interface LeituraRetorno {
    Boleto processarLinha(String[] vetor);
}
