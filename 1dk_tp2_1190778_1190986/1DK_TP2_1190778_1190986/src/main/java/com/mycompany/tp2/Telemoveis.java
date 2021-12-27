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
public class Telemoveis implements Vendaveis {

    /**
     * A designação do telemóvel
     */
    private String designacao;

    /**
     * O valor de venda que o anunciante pretende receber.
     */
    private float valorVenda;

    /**
     * A designaçao do telemovel por omissão.
     */
    private static final String DESIGNACAO_POR_OMISSAO = "sem designação";

    /**
     * O valor de venda que o anunciante pretende receber po omissão.
     */
    private static final float VALORVENDA_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Telemoveis recebendo a designação e o valor de
     * venda que o anunciante pretende receber .
     *
     * @param designacao A designação do telemóvel
     * @param valorVenda O valor de venda que o anunciante prentende receber
     */
    public Telemoveis(String designacao, float valorVenda) {
        this.designacao = designacao;
        this.valorVenda = valorVenda;
    }

    /**
     * Constrói uma instância de Telemoveis usando a designação e o valor de
     * venda que o anunciante pretende receber por omissão.
     */
    public Telemoveis() {
        designacao = DESIGNACAO_POR_OMISSAO;
        valorVenda = VALORVENDA_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Telemoveis recebendo outro objeto da classe
     * Telemoveis.
     *
     * @param outroTelemovel Outro objeto da classe Telemoveis
     */
    public Telemoveis(Telemoveis outroTelemovel) {
        this.designacao = outroTelemovel.designacao;
        this.valorVenda = outroTelemovel.valorVenda;
    }

    /**
     * Devolve a designação do telemovel.
     *
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Devolve o valor de venda que o anunciante pretende receber.
     *
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * Modifica a designação do telemovel recebendo uma nova designação.
     *
     * @param designacao A nova designação
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Modifica o valor de venda que o anunciante pretende receber recebendo o
     * novo valor.
     *
     * @param valorVenda O novo valor
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Devolve a descrição textual dos dados do telemóvel no formato:
     * designação, valor de venda que o anunciante prentende receber.
     *
     * @return os dados do telemovel
     */
    @Override
    public String toString() {
        return String.format("%n### TELEMÓVEL ###%nDESIGNAÇÃO: %f%nVALOR: %.2f", designacao, valorVenda);
    }

    /**
     * Calcula o valor de venda do telemovel com a taxa da plataforma.
     *
     * @return o valor de venda do telemovel
     */
    @Override
    public float calcularValorVenda() {
        return valorVenda * (1 + (TAXAVENDA / 100));
    }
}
