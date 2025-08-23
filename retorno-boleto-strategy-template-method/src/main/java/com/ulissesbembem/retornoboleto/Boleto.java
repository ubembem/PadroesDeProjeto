package com.ulissesbembem.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Ulisses da Silva Bembem
 */
public class Boleto {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private int id;
    private String codBanco;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodBanco() { return codBanco; }
    public void setCodBanco(String codBanco) { this.codBanco = codBanco; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }

    public double getJuros() { return juros; }
    public void setJuros(double juros) { this.juros = juros; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getContaBancaria() { return contaBancaria; }
    public void setContaBancaria(String contaBancaria) { this.contaBancaria = contaBancaria; }

    @Override
    public String toString() {
        String str = String.format("Id: %10d Banco: %3s", id, codBanco);
        String ag = "";
        if (agencia != null && !agencia.isEmpty() && contaBancaria != null && !contaBancaria.isEmpty()) {
            ag = String.format(" Ag: %6s CC: %10s", agencia, contaBancaria);
        }
        str += ag + String.format(
                " Venc: %s Pag: %s Valor: %10.2f",
                FORMATO_DATA.format(dataVencimento),
                FORMATO_DATA_HORA.format(dataPagamento),
                valor
        );
        if (multa > 0)  str += String.format(" Multa: %10.2f", multa);
        if (juros > 0)  str += String.format(" Juros: %10.2f", juros);
        return str;
    }
}