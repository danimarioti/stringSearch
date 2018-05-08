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
 * @author kduzera
 */
public class AhoCorasickTest {
    
    public AhoCorasickTest() {
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
     * Test of callAlgorithm method, of class AhoCorasick.
     */
    @Test
    public void testCallAlgorithm1() {
        String valor = "Dani";
        int expResult;
        String nomeArquivo = "test1";
        Naive instance = new Naive();
        expResult=instance.callAlgorithm(valor, nomeArquivo, null);
        assertEquals(expResult,1);
    }
    @Test
    public void testCallAlgorithm2() {
        String valor = "Kduzera";
        int expResult;
        String nomeArquivo = "test1";
        Naive instance = new Naive();
        expResult=instance.callAlgorithm(valor, nomeArquivo, null);
        assertEquals(expResult,2);
    }
    @Test
    public void testCallAlgorithm3() {
        String valor = "jajaja";
        int expResult;
        String nomeArquivo = "test1";
        Naive instance = new Naive();
        expResult=instance.callAlgorithm(valor, nomeArquivo, null);
        assertEquals(expResult,1);
    }
    
}
