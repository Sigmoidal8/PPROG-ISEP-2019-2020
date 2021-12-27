/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

import java.util.Comparator;

/**
 *
 * @author raulcoelho
 */
public class Comparacao1 implements Comparator<Trabalhador> {

    @Override
    public int compare(Trabalhador o1, Trabalhador o2) {
        float vencimento1 = o1.calcularVencimento();
        float vencimento2 = o2.calcularVencimento();

        if (vencimento1 > vencimento2) {
            return 1;
        } else if (vencimento1 < vencimento2) {
            return -1;
        } else {
            return 0;
        }
    }

}
