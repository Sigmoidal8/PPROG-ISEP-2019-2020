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
public class CreditoAutomovel extends CreditoConsumo {

    /**
     * A taxa de juro anual aplicada ao crédito do cliente
     */
    private static float taxaAnual = 6;

    /**
     * Limite a partir do qual deixa de existir desconto para o cliente
     */
    private static int limitePrazo = 24;

    /**
     * Desconto aplicavél ao crédiito
     */
    private static float desconto = 1;

    /**
     * Constrói uma instância de CreditoAutomovel recebendo o nome, profissão,
     * montante, prazo de financiamento.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     */
    public CreditoAutomovel(String nome, String profissao, float montante, int prazoFinanciamento) {
        super(nome, profissao, montante, prazoFinanciamento);
    }

    /**
     * Constrói uma instância de CreditoAutomovel recebendo os dados do cliente
     * por omissão.
     */
    public CreditoAutomovel() {
        super();
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

        if (this.getPrazoFinanciamento() <= limitePrazo) {
            while (capitalAPagar > 0) {
                total += capitalAPagar * ((this.getTaxaAnual() / 100) / 12) * (desconto / 100);
                capitalAPagar -= this.getMontante() / this.getPrazoFinanciamento();
            }
        } else {
            while (capitalAPagar > 0) {
                total += capitalAPagar * ((this.getTaxaAnual() / 100) / 12);
                capitalAPagar -= this.getMontante() / this.getPrazoFinanciamento();
            }
        }
        return total;
    }

    /**
     * Devolve a taxa anual aplicada ao crédito do cliente
     *
     * @return a taxaAnual
     */
    public static float getTaxaAnual() {
        return taxaAnual;
    }

    /**
     * Devolve o limite a partir do qual deixa de existir desconto para o cliente
     * 
     * @return the limitePrazo
     */
    public static int getLimitePrazo() {
        return limitePrazo;
    }

    /**
     * Devolve o desconto aplicavél ao crédiito
     * 
     * @return the desconto
     */
    public static float getDesconto() {
        return desconto;
    }

    /**
     * Modifica a taxa de juro anual aplicada ao crédito do cliente
     * 
     * @param aTaxaAnual the taxaAnual to set
     */
    public static void setTaxaAnual(float aTaxaAnual) {
        taxaAnual = aTaxaAnual;
    }

    /**
     * Modifica o limite a partir do qual deixa de existir desconto para o cliente
     * 
     * @param aLimitePrazo the limitePrazo to set
     */
    public static void setLimitePrazo(int aLimitePrazo) {
        limitePrazo = aLimitePrazo;
    }

    /**
     * Modifica o desconto aplicavél ao crédiito
     * 
     * @param aDesconto the desconto to set
     */
    public static void setDesconto(float aDesconto) {
        desconto = aDesconto;
    }
}
