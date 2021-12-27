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
public class Comparacao2 implements Comparator<Trabalhador> {

    @Override
    public int compare(Trabalhador o1, Trabalhador o2) {
        String nome1 = o1.getNome();
        String nome2 = o2.getNome();

        return nome1.compareTo(nome2);
    }

}
