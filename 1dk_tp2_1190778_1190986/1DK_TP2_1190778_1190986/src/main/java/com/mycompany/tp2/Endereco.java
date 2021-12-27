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
public class Endereco {

    /**
     * O nome da rua.
     */
    private String nomeRua;
    
    /** 
     * O código postal.
     */
    private String codigoPostal;
    
    /**
     * A localidade.
     */
    private String localidade;

    /**
     * O nome da rua por omissão.
     */
    private static final String NOMERUA_POR_OMISSAO = "sem nome";
    
    /**
     * O código postal por omissão.
     */
    private static final String CODIGOPOSTAL_POR_OMISSAO = "sem  código postal";
    
    /**
     * A localidade por omissão.
     */
    private static final String LOCALIDADE_POR_OMISSAO = "sem localidade";

    /**
     * Constrói uma instância de Endereco recebendo o nome da rua, o codigo postal, a localidade.
     * 
     * @param nomeRua O nome da rua
     * @param codigoPostal O código postal
     * @param localidade A localidade
     */
    public Endereco(String nomeRua, String codigoPostal, String localidade) {
        this.nomeRua = nomeRua;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
    }

    /**
     * Constrói uma instância de Apartamentos usando o nome da rua, o codigo postal, a localidade por omissão.
     */
    public Endereco() {
        this.nomeRua = NOMERUA_POR_OMISSAO;
        this.codigoPostal = CODIGOPOSTAL_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Apartamentos recebendo outro objeto da classe Endereco.
     * 
     * @param outroEndereco Outro objeto Endereco
     */
    public Endereco(Endereco outroEndereco) {
        this.nomeRua = outroEndereco.nomeRua;
        this.codigoPostal = outroEndereco.codigoPostal;
        this.localidade = outroEndereco.localidade;
    }

    /**
     * Devolve o nome da rua.
     * 
     * @return the nomeRua
     */
    public String getNomeRua() {
        return nomeRua;
    }

    /**
     * Devolve o código postal.
     * 
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Devolve a localidade
     * 
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Modifica o nome da rua recebendo uma nova rua
     * 
     * @param nomeRua O novo nome da rua
     */
    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    /**
     * Modifica o código postal recebendo um novo codigo postal
     * 
     * @param codigoPostal O novo codigo postal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Modifica a loclidade recebendo uma nova localidade
     * 
     * @param localidade A nova localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Devolve a descrição textual dos dados do endereço no formato: nome da rua, codigo postal, localidade.
     * 
     * @return os dados do endereço
     */
    @Override
    public String toString() {
        return String.format("A %s tem o código postal %s da localidade %s", nomeRua, codigoPostal, localidade);
    }
}
