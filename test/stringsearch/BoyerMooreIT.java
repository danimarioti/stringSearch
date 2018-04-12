/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author smlle
 */
public class BoyerMooreIT {
    
    public BoyerMooreIT() {
    }
    
    @BeforeClass
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
     * Test of callAlgorithm method, of class BoyerMoore.
     */
    @Test
    public void testCallAlgorithm() {
        String valor;
        int expResult;
        String nomeArquivo;
        Naive instance = new Naive();
        /*TEST 1*/
        valor = "Daniela";
        nomeArquivo = "test1";
        expResult=instance.callAlgorithm(valor, nomeArquivo);
        assertEquals(expResult,1);
        /*TEST 2*/
        System.out.println("**********test2***********");
        valor = "rebeldes";
        nomeArquivo = "test2";
        expResult=instance.callAlgorithm(valor, nomeArquivo);
        assertEquals(expResult,4);
        /*TEST 3*/
        System.out.println("**********test3***********");
        valor = "marioti";
        nomeArquivo = "test3";
        expResult=instance.callAlgorithm(valor, nomeArquivo);
        assertEquals(expResult,3);
    }

    /**
     * Test of search method, of class BoyerMoore.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String txt = "";
        int linha = 0;
        BoyerMoore instance = new BoyerMoore();
        int expResult = 0;
        int result = instance.search(txt, linha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
