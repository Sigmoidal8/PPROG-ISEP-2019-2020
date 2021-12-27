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
public class Automoveis implements Vendaveis, Alugaveis {

    /**
     * Marca do automovel.
     */
    private String marca;
    
    /**
     * Modelo do automovel.
     */
    private String modelo;
    
    /**
     * Valor de venda que o anunciante pode receber.
     */
    private float valorVenda;
    
    /**
     * Valor de aluguer que o aunciante pode receber.
     */
    private float valorAluguer;

    /**
     * Marca do automovel por omissão.
     */
    private static final String MARCA_POR_OMISSAO = "sem marca";
    
    /**
     * Modelo do automovel por omissão.
     */
    private static final String MODELO_POR_OMISSAO = "desconhecido";
    
    /**
     * Valor de venda que o anunciante pode receber por omissão.
     */
    private static final float VALORVENDA_POR_OMISSAO = 0;
    
    /**
     * Valor de aluguer que o aunciante pode receber por omissão.
     */
    private static final float VALORALUGUER_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Automoveis recebendo a marca, o modelo, 
     * o valor de venda que o anunciante pretende receber e o valor de aluguer que o anunciante pretende receber .
     * 
     * @param marca A marca do automovel
     * @param modelo O modelo do automovel
     * @param valorVenda O valor de venda do automovel
     * @param valorAluguer O valor de aluguer do automovel
     */
    public Automoveis(String marca, String modelo, float valorVenda, float valorAluguer) {
        this.marca=marca;
        this.modelo=modelo;
        this.valorVenda=valorVenda;
        this.valorAluguer = valorAluguer;
    }
    
    /**
     * Constrói uma instância de Automoveis recebendo a marca, o modelo, 
     * o valor de venda que o anunciante pretende receber e o valor de aluguer que o anunciante pretende receber por omissão.
     */
    public Automoveis(){
        marca = MARCA_POR_OMISSAO;
        modelo = MODELO_POR_OMISSAO;
        valorVenda = VALORVENDA_POR_OMISSAO;
        valorAluguer = VALORALUGUER_POR_OMISSAO;
    }
    
    /**
     * Constrói uma instância de Automoveis recebendo outro objeto da classe Automoveis.
     * 
     * @param outroAutomovel Outro objeto da classe Automoveis
     */
    public Automoveis(Automoveis outroAutomovel) {
        marca=outroAutomovel.marca;
        modelo=outroAutomovel.modelo;
        valorVenda=outroAutomovel.valorVenda;
        valorAluguer=outroAutomovel.valorAluguer;
    }
    
    
    /**
     * Devolve a marca do automovel
     * 
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devolve o modelo do automovel
     * 
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devolve o valor de venda do automovel que o anunciante pretende receber 
     * 
     * @return valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * Devolve o valor de aluguer do automovel que o anunciante pretende receber 
     * 
     * @return valorAluguer
     */
    public float getValorAluguer() {
        return valorAluguer;
    }

    /**
     * Modifica a marca do automovel
     * 
     * @param marca a nova marca do automovel
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Modifica o modelo do automovel
     * 
     * @param modelo o novo modelo do automovel
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Modifica o valor de venda do automovel que o anunciante pretende receber 
     * 
     * @param valorVenda o novo valor de venda do automovel que o anunciante pretende receber 
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Modifica o valor de aluguer do automovel que o anunciante pretende receber 
     * 
     * @param valorAluguer o novo valor de aluguer do automovel que o anunciante pretende receber 
     */
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguer = valorAluguer;
    }
    
    /**
     * Devolve a descrição textual dos dados do automovel no formato: marca, modelo, valor de venda ou valor de aluguer.
     * 
     * @return os dados do automovel
     */
    @Override
    public String toString() {
        return String.format("%n### AUTOMÓVEL ###%nMARCA: %s%nMODELO: %f%nVALOR: %.2f", marca, modelo, (valorAluguer == 0 ? valorVenda : valorAluguer));
    }
    
    /**
     * Calcula o valor de venda do automovel com a taxa da plataforma.
     * 
     * @return o valor de venda do automovel
     */
    @Override
    public float calcularValorVenda() {
        return valorVenda*(1+(TAXAVENDA/100));
    }

    /**
     * Calcula do valor de aluguer do automovel com a taxa da plataforma.
     * 
     * @return o valor de alguer do automovel
     */
    @Override
    public float calcularValorAluguer() {
        return valorAluguer*(1+(TAXAALUGUER/100));
    }
}
