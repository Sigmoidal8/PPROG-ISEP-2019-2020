/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp2;

/**
 *
 * @author raulcoelho & miguelsilva
 */
public interface Alugaveis {
    
    /**
     * A taxa aplicada pela plataforma aos aluguaveis.
     */
    static final float TAXAALUGUER = 5;
    
    float calcularValorAluguer();
    
    float getValorAluguer();
}
