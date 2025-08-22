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
        URI nomeArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        URI nomeArquivo1 = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("\nBoletos do Banco do Brasil");
        ProcessarBoletos processador = new ProcessarBoletos();
        processador.processar(nomeArquivo);
        System.out.println("\nBoletos do Banco Bradesco");
        processador.processar(nomeArquivo1);

    }
}
