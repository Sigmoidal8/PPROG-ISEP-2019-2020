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
public class TrabalhadorTest {

    private TrabalhadorComissao trab1;
    private TrabalhadorHora trab2;
    private TrabalhadorComissao trab3;
    
    
    public TrabalhadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trab1 = new TrabalhadorComissao("Paulo Silva", 1000.0f, 3500.0f, 5.30f);
        trab2 = new TrabalhadorHora("Ana Neves", 100, 8.0f);
        trab3 = new TrabalhadorComissao("Gustavo Sousa", 1000.0f, 3500.0f,5.30f);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToZero() {
        System.out.println("compareTo");
        Trabalhador instance = new TrabalhadorImpl();
        int expResult = 0;
        int result = trab1.compareTo(trab3);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToPos() {
        System.out.println("compareTo");
        Trabalhador instance = new TrabalhadorImpl();
        int expResult = 1;
        int result = trab1.compareTo(trab2);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToNeg() {
        System.out.println("compareTo");
        Trabalhador instance = new TrabalhadorImpl();
        int expResult = -1;
        int result = trab2.compareTo(trab1);
        assertEquals(expResult, result);
    }

    public class TrabalhadorImpl extends Trabalhador {

        public float calcularVencimento() {
            return 0.0F;
        }
    }
    
}
