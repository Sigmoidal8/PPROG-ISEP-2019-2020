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
public interface Vendaveis {
    
    /**
     * A taxa aplicada pela plataforma às vendas.
     */
    static final float TAXAVENDA =3;
    
    public float calcularValorVenda();
}
