/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raulcoelho & miguelsilva
 */
public class Anunciante {

    /**
     * Nome do anunciante que usa a plataforma
     */
    private String nome;
    
    /**
     * Endereço do anunciante que usa a plataforma
     */
    private Endereco endereco;
    
    /**
     * Lista de itens que o anunciante pretende vender
     */
    private List<Vendaveis> listaVendaveis;
    
    /**
     * Lista de itens que o anunciante pretende alugar
     */
    private List<Alugaveis> listaAlugaveis;

    /**
     * Nome do anunciante por omissao
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    
    /**
     * Limite de itens na listaAlugaveis
     */
    private static final int LIMITE_ALUGAVEL = 3;
    
    /**
     * Limite de itens na listaVendaveis
     */
    private static final int LIMITE_VENDAVEL = 2;

    /**
     * Constrói uma instância de Anunciante recebendo o nome, nome da Rua, código postal, a localidade, 
     * a lista de vendaveis e a listaAlugaveis.
     * 
     * @param nome O nome do anunciante
     * @param nomeRua O nome da rua do anunciante
     * @param codigoPostal O codigo postal do anunciante
     * @param localidade A localidade do anunciante
     * @param listaVendaveis A lista de itens a vender do anunciante
     * @param listaAlugaveis A lista de itens a alugar do anunciante
     */
    public Anunciante(String nome, String nomeRua, String codigoPostal, String localidade,
            List<Vendaveis> listaVendaveis, List<Alugaveis> listaAlugaveis) {

        this.nome = nome;
        this.endereco = new Endereco(nomeRua, codigoPostal, localidade);
        this.listaVendaveis = new ArrayList<>(listaVendaveis);
        this.listaAlugaveis = new ArrayList<>(listaAlugaveis);
    }

    /**
     * Constrói uma instância de Anunciante recebendo o nome, um objeto Endereço, a lista de vendaveis e a listaAlugaveis.
     * 
     * @param nome O nome do anunciante
     * @param endereco O objeto de Endereço
     * @param listaVendaveis A lista de itens a vender do anunciante
     * @param listaAlugaveis A lista de itens a alugar do anunciante
     */
    public Anunciante(String nome, Endereco endereco, List<Vendaveis> listaVendaveis, List<Alugaveis> listaAlugaveis) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
        this.listaVendaveis = new ArrayList<>(listaVendaveis);
        this.listaAlugaveis = new ArrayList<>(listaAlugaveis);
    }
    
/**
 * Constrói uma instância de Anunciante recebendo o nome, nome da Rua, código postal, a localidade 
 * com as listas de alugaveis e vendaveis por omissão.
 * 
 * @param nome O nome do anunciante
 * @param nomeRua O nome da rua do anunciante
 * @param codigoPostal O codigo postal do anunciante
 * @param localidade A localidade do anunciante
 */
    public Anunciante(String nome, String nomeRua, String codigoPostal, String localidade) {
        this.nome = nome;
        this.endereco = new Endereco(nomeRua, codigoPostal, localidade);
        listaVendaveis = new ArrayList<>();
        listaAlugaveis = new ArrayList<>();
    }

    /**
     * Constrói uma instância de Anunciante recebendo o nome, um objeto Endereço e 
     * com as listas de alugaveis e vendaveis por omissão.
     * 
     * @param nome O nome do anunciante
     * @param endereco O objeto de Endereço
     */
    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
        listaVendaveis = new ArrayList<>();
        listaAlugaveis = new ArrayList<>();
    }

    /**
     * Constrói uma instância de Anunciante com os valores por omissão.
     * 
     */
    public Anunciante() {
        nome = NOME_POR_OMISSAO;
        endereco = new Endereco();
        listaVendaveis = new ArrayList<>();
        listaAlugaveis = new ArrayList<>();
    }

    /**
     * Constói uma instância que copia outro objeto da classe anunciante
     * 
     * @param outroAnunciante O objeto de Anunciante
     */
    public Anunciante(Anunciante outroAnunciante) {
        nome = outroAnunciante.nome;
        endereco = new Endereco(outroAnunciante.getEndereco());
        listaVendaveis = new ArrayList<>(outroAnunciante.getListaVendaveis());
        listaAlugaveis = new ArrayList<>(outroAnunciante.getListaAlugaveis());
    }

    /**
     * Devolve o nome do anunciante.
     * 
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o endereço do cliente.
     * 
     * @return the endereco
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * Devolve a lista de itens a vender
     * 
     * @return the listaVendaveis
     */
    public List<Vendaveis> getListaVendaveis() {
        return new ArrayList<>(listaVendaveis);
    }

    /**
     * Devolve a lista de itens a alugar
     * 
     * @return the listaAlugaveis
     */
    public List<Alugaveis> getListaAlugaveis() {
        return new ArrayList<>(listaAlugaveis);
    }

    /**
     * Modifica o nome do anunciante.
     * 
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o endereço do Anunciante por outro objeto de Endereco
     * 
     * @param endereco to novo Endereco do anunciante
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco);
    }
    
    /**
     * Modifica o endereco do Anunciante recebendo por parametro o nome da rua, o codigo postal e a loclidade.
     * 
     * @param nomeRua O novo nome da rua do anunciante
     * @param codigoPostal O novo codigo postal do anunciante
     * @param localidade A nova localidade do anunciante
     */
    public void setEndereco(String nomeRua, String codigoPostal, String localidade) {
        this.endereco = new Endereco(nomeRua, codigoPostal, localidade);
    }

    /**
     * Modifica a lista de itens a vender do Anunciante recebendo por parametro uma nova lista de itens a vender.
     * 
     * @param listaVendaveis A nova lista de itens a vender
     */
    public void setListaVendaveis(List<Vendaveis> listaVendaveis) {
        this.listaVendaveis = new ArrayList<>(listaVendaveis);
    }

    /**
     * Modifica a lista de itens a alugar do Anunciante recebendo por parametro uma nova lista de itens a alugar.
     * 
     * @param listaAlugaveis A nova lista de itens a alugar
     */
    public void setListaAlugaveis(List<Alugaveis> listaAlugaveis) {
        this.listaAlugaveis = new ArrayList<>(listaAlugaveis);
    }

    /**
     * Adiciona um novo item a alugar à lista de itens a alugar.
     * 
     * @param alugavel item a adicionar à lista
     * @return Devolve a lista adicionando o novo item
     */
    public boolean adicionarAlugavel(Alugaveis alugavel) {
        return listaAlugaveis.contains(alugavel) || listaAlugaveis.size() >= LIMITE_ALUGAVEL ? false : listaAlugaveis.add(alugavel);
    }

    /**
     * Adiciona um novo item a vender à lista de itens a vender.
     * 
     * @param vendavel item a adicionar à lista
     * @return  Devolver a lista adicionando o novo item
     */
    public boolean adicionarVendavel(Vendaveis vendavel) {
        return listaVendaveis.contains(vendavel) || listaVendaveis.size() >= LIMITE_VENDAVEL ? false : listaVendaveis.add(vendavel);
    }

    /**
     * Calcula o número de itens que o anunciante tem para alugar.
     * 
     * @return o número de itens que o anunciante tem a alugar
     */
    public int calcularTotalProdutosAlugar() {
        return listaAlugaveis.size();
    }

    /**
     * Calcula qual o objeto da lista de itens a alugar que é mais caro.
     * 
     * @return o objeto da lista itens a lugar que é mais caro
     */
    public Alugaveis getAluguerMaisCaro() {
        Alugaveis maisCaro = listaAlugaveis.get(0);
        for(Alugaveis objetoAlugar : listaAlugaveis) {
            if(objetoAlugar.calcularValorAluguer()>maisCaro.calcularValorAluguer()){
                maisCaro = objetoAlugar;
            }
        }
        return maisCaro;
    }
    
    /**
     * Calcula o valor total possível de obter com a venda dos itens que o anunciante tem na lista de itens a vender.
     * 
     * @return o valor total possível de obter das vendas
     */
    public float calcularValorPossivelVendas() {
        float total = 0;
        for(Vendaveis obj : listaVendaveis) {
            total+= obj.calcularValorVenda();
        }
        return total;
    }

    /**
     * Devolve a descrição textual dos dados do anunciante no formato: nome e endereço
     * 
     * @return os dados do anunciante
     */
    @Override
    public String toString() {
        return String.format("### ANUNCIANTE ###%nNOME: %s%nENDERECO: %s", nome, endereco);
    }

}
