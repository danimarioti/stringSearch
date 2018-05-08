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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author smlle
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({stringsearch.BoyerMooreIT.class, stringsearch.textos.TextosITSuite.class, stringsearch.RabinKarpIT.class, stringsearch.NaiveIT.class,stringsearch.KmpIT.class, stringsearch.StringsearchIT.class, stringsearch.readFileIT.class})
public class StringsearchITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
