/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vencimentos;

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
public class TrabalhadorComissaoTest {

    private TrabalhadorComissao trab1;
    
    public TrabalhadorComissaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trab1 = new TrabalhadorComissao("Paulo Silva",1000,3500,5.30f);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularVencimento method, of class TrabalhadorComissao.
     */
    @Test
    public void testCalcularVencimento() {
        System.out.println("calcularVencimento");
        float expResult = 1185.5F;
        float result = trab1.calcularVencimento();
        assertEquals(expResult, result, 0.005);
    }
    
}
