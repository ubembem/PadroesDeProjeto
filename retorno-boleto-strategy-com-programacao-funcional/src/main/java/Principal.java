import com.ulissesbembem.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author ulissesbembem
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        URI arquivoBB = Principal.class.getResource("banco-brasil-1.csv").toURI();
        URI arquivoBradesco = Principal.class.getResource("bradesco-1.csv").toURI();

        ProcessarBoletos processador = new ProcessarBoletos();

        System.out.println("\nBoletos do Banco do Brasil");
        processador.processar(arquivoBB);

        System.out.println("\nBoletos do Banco Bradesco");
        processador.processar(arquivoBradesco);
    }
}