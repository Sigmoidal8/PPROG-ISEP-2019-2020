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
public class Comparacao1Test {

    private Trabalhador trab1, trab2, trab3;

    public Comparacao1Test() {
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
     * Test of compare method, of class Comparacao1.
     */
    @Test
    public void testCompareZero() {
        System.out.println("compare");
        Comparacao1 instance = new Comparacao1();
        int expResult = 0;
        int result = instance.compare(trab1, trab3);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class Comparacao1.
     */
    @Test
    public void testComparePos() {
        System.out.println("compare");
        Comparacao1 instance = new Comparacao1();
        int expResult = 1;
        int result = instance.compare(trab1, trab2);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class Comparacao1.
     */
    @Test
    public void testCompareNeg() {
        System.out.println("compare");
        Comparacao1 instance = new Comparacao1();
        int expResult = -1;
        int result = instance.compare(trab2, trab1);
        assertEquals(expResult, result);
    }

}
