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
public class CreditoEducacao extends CreditoConsumo {

    /**
     * O período de carência que é aplicado no crédito
     */
    private int periodoCarencia;

    /**
     * O período de carência por omissão
     */
    private static final int PERIODOCARENCIA_POR_OMISSAO = 0;

    /**
     * A taxa de juro anual aplicada ao crédito do cliente
     */
    private static float taxaAnual = 2;

    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, profissão,
     * montante, prazo de financiamento, periodo de carencia.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     * @param periodoCarencia O período de carência que é aplicado no crédito
     */
    public CreditoEducacao(String nome, String profissao, float montante, int prazoFinanciamento, int periodoCarencia) {
        super(nome, profissao, montante, prazoFinanciamento);
        this.periodoCarencia = periodoCarencia;
    }

    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, profissão,
     * montante, prazo de financiamento e periodo de carencio por omissão.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     */
    public CreditoEducacao(String nome, String profissao, float montante, int prazoFinanciamento) {
        super(nome, profissao, montante, prazoFinanciamento);
        periodoCarencia = PERIODOCARENCIA_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de CreditoEducacao recebendo o periodo de carencia
     * e o nome, profissão, montante, prazo de financiamento por omissão.
     *
     * @param periodoCarencia O período de carência que é aplicado no crédito
     */
    public CreditoEducacao(int periodoCarencia) {
        super();
        this.periodoCarencia = periodoCarencia;
    }

    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, profissão,
     * montante, prazo de financiamento, periodo de carencia por omissão.
     *
     */
    public CreditoEducacao() {
        super();
        periodoCarencia = PERIODOCARENCIA_POR_OMISSAO;
    }

    /**
     * Devolve o período de carência que é aplicado no crédito
     *
     * @return the periodoCarencia
     */
    public int getPeriodoCarencia() {
        return periodoCarencia;
    }

    /**
     * Modifica o período de carência que é aplicado no crédito
     *
     * @param periodoCarencia the periodoCarencia to set
     */
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }

    /**
     * Devolve a descrição textual dos montantes de juros e o montante a receber
     * pelo crédito
     *
     * @return os montantes
     */
    @Override
    public String toString() {
        return String.format("%s %nMONTANTE TOTAL DE JUROS: %.2f€ %nMONTATANTE A RECEBER POR CREDITO: %.2f€", super.toString(), calcularMontanteTotalJuros(), calcularMontanteAReceberPorCadaCredito());
    }

    /**
     * Permite calcular o montante a receber por cada credito do cliente através
     * do polimorfismo.
     *
     * @return montante do total do Crédito
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

        for (int i = 0; i < periodoCarencia; i++) {
            total += this.getMontante() * ((this.getTaxaAnual() / 100) / 12);
        }
        while (capitalAPagar > 0) {
            total += capitalAPagar * ((this.getTaxaAnual() / 100) / 12);
            capitalAPagar -= this.getMontante() / (this.getPrazoFinanciamento() - this.getPeriodoCarencia());
        }
        return total;
    }

    /**
     * Devolve a taxa de juro anual aplicada ao crédito do cliente
     *
     * @return the taxaAnual
     */
    public static float getTaxaAnual() {
        return taxaAnual;
    }

    /**
     * Modifica a taxa de juro anual aplicada ao crédito do cliente
     *
     * @param aTaxaAnual the taxaAnual to set
     */
    public static void setTaxaAnual(float aTaxaAnual) {
        taxaAnual = aTaxaAnual;
    }

}
