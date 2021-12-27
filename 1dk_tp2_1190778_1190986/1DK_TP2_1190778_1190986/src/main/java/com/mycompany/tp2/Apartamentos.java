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
public class Apartamentos implements Alugaveis {

    /**
     * Área do apartamento.
     */
    private float area;

    /**
     * Valor de aluguer para o apartamento que o anunciante pretende receber.
     */
    private float valorAluguer;

    /**
     * Endereço do apartamento.
     */
    private Endereco endereco;

    /**
     * Área do apartamento por omissão.
     */
    private static final float AREA_POR_OMISSAO = 0;

    /**
     * Valor de aluguer para o apartamentp que o anunciante pretende receber por
     * omissão.
     */
    private static final float VALORALUGUER_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Apartamentos recebendo o nome da rua, o codigo
     * postal, a localidade, a área e o valor de aluguer que o anunciante
     * pretende receber .
     *
     * @param nomeRua O nome da rua do apartamento
     * @param codigoPostal O código postal do apartamento
     * @param localidade A localidade do apartamento
     * @param area A área do apartamento
     * @param valorAluguer O valor de aluguer que o anunciante pretende receber
     */
    public Apartamentos(String nomeRua, String codigoPostal, String localidade, float area, float valorAluguer) {
        this.endereco = new Endereco(nomeRua, codigoPostal, localidade);
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    /**
     * Constrói uma instância de Apartamentos recebendo um objeto Endereco, a
     * área e o valor de aluguer que o anunciante pretende receber .
     *
     * @param endereco O endereço do apartamento
     * @param area A área do apartamento
     * @param valorAluguer O valor de aluguer que o anunciante pretende recber
     */
    public Apartamentos(Endereco endereco, float area, float valorAluguer) {
        this.endereco = new Endereco(endereco);
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    /**
     * Constrói uma instância de Apartamentos usando o Endereco, a área e o
     * valor de aluguer que o anunciante pretende receber por omissão.
     *
     */
    public Apartamentos() {
        this.endereco = new Endereco();
        area = AREA_POR_OMISSAO;
        valorAluguer = VALORALUGUER_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Apartamentos recebendo outro objeto da classe
     * Apartamentos.
     *
     * @param outroApartamento Outro objeto da classe Apartamentos
     */
    public Apartamentos(Apartamentos outroApartamento) {
        this.endereco = new Endereco(outroApartamento.getEndereco());
        this.area = outroApartamento.getArea();
        this.valorAluguer = outroApartamento.getValorAluguer();
    }

    /**
     * Devolve o endereço do apartamento.
     *
     * @return endereco
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * Devolve a área do apartamento.
     *
     * @return area
     */
    public float getArea() {
        return area;
    }

    /**
     * Devolve o valor de aluguer do apartamento que o anunciante pretende
     * receber.
     *
     * @return valorAluguer
     */
    public float getValorAluguer() {
        return valorAluguer;
    }

    /**
     * Modifica o endereço do apartamento recebendo o novo nome da rua, o código
     * postal e a localidade.
     *
     * @param nomeRua O novo nome da rua
     * @param codigoPostal O novo código postal
     * @param localidade A nova localidade
     */
    public void setEndereco(String nomeRua, String codigoPostal, String localidade) {
        this.endereco = new Endereco(nomeRua, codigoPostal, localidade);
    }

    /**
     * Modifica o endereço do apartamento recebendo um novo objeto da classe
     * Endereco.
     *
     * @param endereco O novo endereço
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco);
    }

    /**
     * Modifica a área do apartamento recebendo a nova área.
     *
     * @param area A nova área
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Modifica o valor de aluguer que o anunciante pretende receber recebendo
     * um novo valor.
     *
     * @param valorAluguer O novo valor
     */
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    /**
     * Devolve a descrição textual dos dados do apartamento no formato:
     * endereço, área, valor de aluguer.
     *
     * @return Os dados do apartamento
     */
    @Override
    public String toString() {
        return String.format("%n### APARTAMENTO ###%nENDEREÇO: %s%nAREA: %.2f%nVALOR: %.2f", endereco, area, valorAluguer);
    }

    /**
     * Calcula do valor de aluguer do apartamento com a taxa da plataforma.
     *
     * @return o valor do apartamento
     */
    @Override
    public float calcularValorAluguer() {
        return valorAluguer * (1 + (TAXAALUGUER / 100));
    }
}
