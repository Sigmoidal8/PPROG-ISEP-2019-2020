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
public abstract class CreditoConsumo extends CreditoBancario {

    /**
     * O número de objetos da classe CreditoConsumo
     */
    private static int totalCreditosConsumo = 0;

    /**
     * Constrói uma instância de CreditoConsumo recebendo o nome, profissão,
     * montante, prazo de financiamento.
     *
     * @param nome O nome do cliente
     * @param profissao A profissao do cliente
     * @param montante Montante de empréstimo pretendido
     * @param prazoFinanciamento Número de meses para pagar o empréstimo
     */
    public CreditoConsumo(String nome, String profissao, float montante, int prazoFinanciamento) {
        super(nome, profissao, montante, prazoFinanciamento);
        totalCreditosConsumo++;
    }

    /**
     * Constrói uma instância de CreditoConsumo recebendo os dados do cliente
     * por omissão.
     */
    public CreditoConsumo() {
        super();
        totalCreditosConsumo++;
    }

    /**
     * Devolve a descrição textual dos dados do cliente no formato: nome,
     * profissao, montante e prazo de financiamento.
     *
     * @return os dados do cliente
     */
    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

    /**
     * Permite calcular o montante a receber por cada credito do cliente através
     * do polimorfismo.
     *
     * @return o montante a receber por cada credito do cliente
     */
    @Override
    public abstract float calcularMontanteAReceberPorCadaCredito();

    /**
     * Permite calcular o montante total de juros através do polimorfismo.
     *
     * @return montante de juros
     */
    @Override
    public abstract float calcularMontanteTotalJuros();

    /**
     *Devolve o total de objetos da classe CreditoConsumo
     * 
     * @return the totalCreditosConsumo
     */
    public static int getTotalCreditosConsumo() {
        return totalCreditosConsumo;
    }
}
