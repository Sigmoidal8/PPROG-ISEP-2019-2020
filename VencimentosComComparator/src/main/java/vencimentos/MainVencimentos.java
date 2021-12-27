package vencimentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);

        List<Trabalhador> trabs = new ArrayList<>();
        trabs.add(tc);
        trabs.add(tp);
        trabs.add(th);

        System.out.println("### Trabalhadores ###");
        listar(trabs);
        
        System.out.println("### Trabalhadores por vencimento crescente ###");
        Comparacao1 criterio1 = new Comparacao1();
        Collections.sort(trabs, criterio1);
        listar(trabs);

        System.out.println("### Trabalhadores por vencimento decrescente ###");
        Collections.sort(trabs, Collections.reverseOrder(criterio1));
        listar(trabs);

        System.out.println("### Trabalhadores por ordem alfabética ###");
        Comparacao2 criterio2 = new Comparacao2();
        Collections.sort(trabs, criterio2);
        listar(trabs);
    }

    private static void listar(List<Trabalhador> trabs) {
        for (Trabalhador trab : trabs) {
            if (trab != null) {
                System.out.printf("%s, vencimento = %.2f€%n", trab.getNome(),
                        trab.calcularVencimento());
            }
        }
    }

}
