package com.ulissesbembem.retornoboleto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa um boleto bancário.
 * @author Ulisses da Silva Bembem
 */
public class Boleto {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private String id;
    private String banco;
    private String agencia;
    private String conta;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;

    public Boleto(String id, String banco, String agencia, String conta,
                  LocalDate dataVencimento, LocalDateTime dataPagamento,
                  String cpfCliente, double valor, double multa, double juros) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.multa = multa;
        this.juros = juros;
    }

    // Getters
    public String getId() { return id; }
    public String getBanco() { return banco; }
    public String getAgencia() { return agencia; }
    public String getConta() { return conta; }
    public LocalDate getDataVencimento() { return dataVencimento; }
    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public String getCpfCliente() { return cpfCliente; }
    public double getValor() { return valor; }
    public double getMulta() { return multa; }
    public double getJuros() { return juros; }

    @Override
    public String toString() {
        return String.format(
                "Boleto{id='%s', banco='%s', agencia='%s', conta='%s', vencimento=%s, pagamento=%s, cpf='%s', valor=%.2f, multa=%.2f, juros=%.2f}",
                id, banco, agencia, conta,
                dataVencimento, dataPagamento,
                cpfCliente, valor, multa, juros
        );
    }
}




