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
        expResult=instance.callAlgorithm(valor, nomeArquivo,null);
        assertEquals(expResult,1);
        /*TEST 2*/
        System.out.println("**********test2***********");
        valor = "rebeldes";
        nomeArquivo = "test2";
        expResult=instance.callAlgorithm(valor, nomeArquivo,null);
        assertEquals(expResult,5);
        /*TEST 3*/
        System.out.println("**********test3***********");
        valor = "marioti";
        nomeArquivo = "test3";
        expResult=instance.callAlgorithm(valor, nomeArquivo,null);
        assertEquals(expResult,3);
    }
   
    
}