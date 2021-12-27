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
public class CreditoHabitacao extends CreditoBancario {

    /**
     * O spread aplicado ao cliente.
     */
    private float spread;

    /**
     * O spread por omissão aplicado ao cliente.
     */
    private static final float SPREAD_POR_OMISSAO = 0;

    /**
     * O número de objetos da classe CreditoHabitacao
     */
    private static int totalCreditosHabitacao = 0;

    /**
     * O valor da taxa Euribor aplicado ao cliente.
     */
    private static float taxaEuribor = 0.1f;

    /**
     * Constrói uma instância de CreditoHabitacao recebendo o nome, profissão,
     * montante, prazo de financiamento e spread.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     * @param spread Valor acordado com o cliente
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int prazoFinanciamento, float spread) {
        super(nome, profissao, montante, prazoFinanciamento);
        this.spread = spread;
        totalCreditosHabitacao++;
    }

    /**
     * Constrói uma instância de CreditoHabitacao recebendo o nome, profissão,
     * montante e prazo de financiamento e o spread por omissão.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int prazoFinanciamento) {
        super(nome, profissao, montante, prazoFinanciamento);
        spread = SPREAD_POR_OMISSAO;
        totalCreditosHabitacao++;
    }

    /**
     * Constrói uma instância de CreditoHabitacao recebendo os dados do cliente
     * por omissão e o spread.
     *
     * @param spread Valor acordado com o cliente
     */
    public CreditoHabitacao(float spread) {
        super();
        this.spread = spread;
        totalCreditosHabitacao++;
    }

    /**
     * Constrói uma instância de CreditoHabitacao recebendo os dados do cliente
     * e o spread por omissão.
     *
     */
    public CreditoHabitacao() {
        super();
        spread = SPREAD_POR_OMISSAO;
        totalCreditosHabitacao++;
    }

    /**
     * Devolve o valor do spread aplicado ao cliente.
     *
     * @return o spread
     */
    public float getSpread() {
        return spread;
    }

    /**
     * Modifica o valor do spread.
     *
     * @param spread o novo spread aplicado ao cliente
     */
    public void setSpread(float spread) {
        this.spread = spread;
    }

    /**
     * Devolve a descrição textual dos montantes do cliente no formato: montante
     * total de juros, montante a receber por credito.
     *
     * @return Os diversos montantes calculados do cliente
     */
    @Override
    public String toString() {
        return String.format("%s %nMONTANTE TOTAL DE JUROS: %.2f€ %nMONTATANTE A RECEBER POR CREDITO: %.2f€", super.toString(), calcularMontanteTotalJuros(), calcularMontanteAReceberPorCadaCredito());
    }

    /**
     * Permite calcular o montante a receber por cada credito do cliente através
     * do polimorfismo.
     *
     * @return o montante a receber por cada credito do cliente
     */
    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return calcularMontanteTotalJuros() + this.getMontante();
    }

    /**
     * Permite calcular o montante total de juros através do polimorfismo.
     *
     * @return montante de juros
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float capitalAPagar = this.getMontante();
        float total = 0;

        while (capitalAPagar > 0) {
            total += capitalAPagar * ((this.getTaxaEuribor() / 100 / 12) + (this.getSpread() / 100 / 12));
            capitalAPagar -= this.getMontante() / this.getPrazoFinanciamento();
        }
        return total;
    }

    /**
     *Devolve o total de objetos da classe CreditoHabitacao
     * 
     * @return the totalCreditosHabitacao
     */
    public static int getTotalCreditosHabitacao() {
        return totalCreditosHabitacao;
    }

    /**
     * Devolve o valor da taxa euribor aplicado ao cliente.
     *
     * @return a taxa Euribor
     */
    public static float getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * Modifica o valor da taxa euribor.
     *
     * @param TaxaEuribor a nova taxa Euribor aplicada ao cliente
     */
    public static void setTaxaEuribor(float TaxaEuribor) {
        taxaEuribor = TaxaEuribor;
    }
}
