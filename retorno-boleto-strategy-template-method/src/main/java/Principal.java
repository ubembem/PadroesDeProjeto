import com.ulissesbembem.retornoboleto.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        URI arquivoBB = Objects.requireNonNull(
                Principal.class.getResource("banco-brasil-1.csv"),
                "Recurso banco-brasil-1.csv não encontrado"
        ).toURI();

        URI arquivoBradesco = Objects.requireNonNull(
                Principal.class.getResource("bradesco-1.csv"),
                "Recurso bradesco-1.csv não encontrado"
        ).toURI();

        System.out.println("\nBoletos do Banco do Brasil");
        ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        processador.processar(arquivoBB);

        System.out.println("\nBoletos do Banco Bradesco");
        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        processador.processar(arquivoBradesco);
    }
}
