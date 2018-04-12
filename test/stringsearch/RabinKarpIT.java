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
public class RabinKarpIT {
    
    public RabinKarpIT() {
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
     * Test of callAlgorithm method, of class RabinKarp.
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
     * Test of search method, of class RabinKarp.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String pat = "";
        String txt = "";
        int q = 0;
        int linha = 0;
        int expResult = 0;
        int result = RabinKarp.search(pat, txt, q, linha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
