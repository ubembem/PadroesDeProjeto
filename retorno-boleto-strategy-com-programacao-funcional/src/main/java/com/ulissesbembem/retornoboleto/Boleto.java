package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Boleto {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final String banco;
    private final String agencia;
    private final LocalDate vencimento;
    private final LocalDateTime pagamento;
    private final double valor;
    private final double multa;
    private final double juros;
    private final String codigo;

    public Boleto(String banco, String agencia, LocalDate vencimento, LocalDateTime pagamento,
                  double valor, double multa, double juros, String codigo) {
        this.banco = banco;
        this.agencia = agencia;
        this.vencimento = vencimento;
        this.pagamento = pagamento;
        this.valor = valor;
        this.multa = multa;
        this.juros = juros;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("Boleto{id='%s', banco='%s', vencimento=%s, pagamento=%s, valor=%.2f, multa=%.2f, juros=%.2f, codigo='%s'}",
                codigo, banco, vencimento, pagamento, valor, multa, juros, codigo);
    }
}