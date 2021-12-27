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
public abstract class CreditoBancario {

    /**
     * O nome do cliente.
     */
    private String nome;

    /**
     * A profissao do cliente.
     */
    private String profissao;

    /**
     * O montante do cliente.
     */
    private float montante;

    /**
     * O Prazo de financiamento do cliente.
     */
    private int prazoFinanciamento;

    /**
     * O nome por omissão do cliente
     */
    private static final String NOME_POR_OMISSAO = "sem none";
    
     /**
     * A profissão por omissão do cliente
     */
    private static final String PROFISSAO_POR_OMISSAO = "sem profissão";
    
     /**
     * O montante por omissão do cliente
     */
    private static final float MONTANTE_POR_OMISSAO = 0;
    
     /**
     * O prazo de financiamento por omissão do cliente
     */
    private static final int PRAZOFINANCIAMENTO_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de CreditoBancario recebendo o nome, profissão,
     * montante e prazo de financiamento.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     */
    public CreditoBancario(String nome, String profissao, float montante, int prazoFinanciamento) {
        this.nome = nome;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    /**
     * Constrói uma instância de CreditoBancario com os dados do cliente por
     * omissão
     *
     */
    public CreditoBancario() {
        nome = NOME_POR_OMISSAO;
        profissao = PROFISSAO_POR_OMISSAO;
        montante = MONTANTE_POR_OMISSAO;
        prazoFinanciamento = PRAZOFINANCIAMENTO_POR_OMISSAO;
    }

    /**
     * Devolve o nome do cliente.
     *
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a profissão do cliente.
     *
     * @return a profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Devolve o montante de empréstimo do cliente.
     *
     * @return o montante
     */
    public float getMontante() {
        return montante;
    }

    /**
     * Devolve o número de meses para pagar o empréstimo
     *
     * @return o prazoFinanciamento
     */
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    /**
     * Modifica o nome do cliente.
     *
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a profissão do cliente.
     *
     * @param profissao a nova profissão do cliente
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Modifica o montate de empréstimo do cliente
     *
     * @param montante o novo montante de empréstimo do cliente
     */
    public void setMontante(float montante) {
        this.montante = montante;
    }

    /**
     * Modifica o número de meses para pagar o empréstimo
     *
     * @param prazoFinanciamento o novo número de meses para pagar o empréstimo
     */
    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    /**
     * Devolve a descrição textual dos dados do cliente no formato: nome,
     * profissao, montante e prazo de financiamento
     *
     * @return Os dados do cliente
     */
    @Override
    public String toString() {
        return String.format("NOME: %s %nPROFISSAO: %s %nMONTANTE: %.2f€ %nPRAZO DE FINANCIAMENTO: %d", this.nome, this.profissao, this.montante, this.prazoFinanciamento);
    }

    /**
     *Permite calcular o montante a receber por cada credito do cliente através do polimorfismo.
     * 
     * @return o montante a receber por cada credito do cliente 
     */
    public abstract float calcularMontanteAReceberPorCadaCredito();

    /**
     *Permite calcular o montante total de juros através do polimorfismo.
     * 
     * @return montante de juros
     */
    public abstract float calcularMontanteTotalJuros();

}
