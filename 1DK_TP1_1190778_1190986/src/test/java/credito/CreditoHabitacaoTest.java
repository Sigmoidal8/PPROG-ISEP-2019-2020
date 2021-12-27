/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raulcoelho
 */
public class CreditoHabitacaoTest {
    
    public CreditoHabitacaoTest() {
    }
    
   /* @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoHabitacao.
     */
    @Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        CreditoHabitacao instance = new CreditoHabitacao("Joao", "Professor", 120000, 240, 1);
        float expResult = 133255.0F;
        float result = instance.calcularMontanteAReceberPorCadaCredito();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoHabitacao.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        CreditoHabitacao instance = new CreditoHabitacao("Joao", "Professor", 120000, 240, 1);
        float expResult = 13255.0F;
        float result = instance.calcularMontanteTotalJuros();
        assertEquals(expResult, result, 0.0);
    }

    
    
}
