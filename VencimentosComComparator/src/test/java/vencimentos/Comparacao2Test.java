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
public class Comparacao2Test {

    private Trabalhador trab1, trab2, trab3;

    public Comparacao2Test() {
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
        trab3 = new TrabalhadorPeca("Paulo Silva", 20, 50);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class Comparacao2.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Comparacao2 instance = new Comparacao2();
        String nome1 = trab1.getNome();
        String nome2 = trab3.getNome();
        int expResult = nome1.compareTo(nome2);
        int result = instance.compare(trab1, trab3);
        assertEquals(expResult, result);
    }

}
