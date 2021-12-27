/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

/**
 *
 * @author raulcoelho & miguelsilva
 */
public class MainCredito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //A)
        CreditoHabitacao t1 = new CreditoHabitacao("Júlio", "Agricultor", 100000, 240, 2);
        CreditoHabitacao t2 = new CreditoHabitacao("César", "Engenheiro", 60000, 120, 4);

        CreditoAutomovel t3 = new CreditoAutomovel("Joana", "Atriz", 50000, 20);
        CreditoAutomovel t4 = new CreditoAutomovel("Jorge", "Pintor", 160000, 60);

        CreditoEducacao t5 = new CreditoEducacao("João", "Estudante", 15000, 20, 6);
        CreditoEducacao t6 = new CreditoEducacao("Inês", "Talhante", 20000, 36, 10);

        //B)
        CreditoBancario[] array = new CreditoBancario[10];
        array[0] = t1;
        array[1] = t2;
        array[2] = t3;
        array[3] = t4;
        array[4] = t5;
        array[5] = t6;

        //C1)
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i] instanceof CreditoConsumo) {
                System.out.printf("%nNOME: %s%nMONTANTE A RECEBER PELO CREDITO: %.2f€", array[i].getNome(), array[i].calcularMontanteAReceberPorCadaCredito());
            }
        }
        System.out.printf("%n================================================================================");

        //C2)
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.printf("%nNOME: %s%nJUROS A RECEBER PELO CREDITO: %.2f€", array[i].getNome(), array[i].calcularMontanteTotalJuros());
            }
        }
        System.out.printf("%n================================================================================");

        //D)
        System.out.printf("%nTOTAL CRÉDITOS À HABITAÇÃO: %d%nTOTAL CRÉDITOS AO CONSUMO: %d", CreditoHabitacao.getTotalCreditosHabitacao(), CreditoConsumo.getTotalCreditosConsumo());
        System.out.printf("%n================================================================================");

        //E)
        float valorTotal = 0, totalJuros = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                valorTotal += array[i].calcularMontanteAReceberPorCadaCredito();
                totalJuros += array[i].calcularMontanteTotalJuros();
            }
        }
        System.out.printf("%nVALOR TOTAL: %.2f€%nTOTAL DE JUROS: %.2f€",valorTotal, totalJuros);
    }

}
