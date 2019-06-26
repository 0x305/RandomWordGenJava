/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceable_words;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arielomar
 */
public class GeneratorTest {
    
    public GeneratorTest() {
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
     * Test of randomChar method, of class Generator.
     */
    @Test
    public void testRandomChar() {
        System.out.println("randomChar");
        Generator instance = new Generator();
        char expResult = ' ';
        char result = instance.randomChar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomWord method, of class Generator.
     */
    @Test
    public void testRandomWord() {
        System.out.println("randomWord");
        int wordLength = 0;
        Generator instance = new Generator();
        StringBuilder expResult = null;
        StringBuilder result = instance.randomWord(wordLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConditions method, of class Generator.
     */
    @Test
    public void testSetConditions() throws Exception {
        System.out.println("setConditions");
        Generator instance = new Generator();
        instance.setConditions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkWord method, of class Generator.
     */
    @Test
    public void testCheckWord() throws Exception {
        System.out.println("checkWord");
        StringBuilder word = null;
        Generator instance = new Generator();
        instance.checkWord(word);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyBegin method, of class Generator.
     */
    @Test
    public void testModifyBegin() throws Exception {
        System.out.println("modifyBegin");
        StringBuilder word = null;
        String combo = "";
        Generator instance = new Generator();
        instance.modifyBegin(word, combo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyNotBegin method, of class Generator.
     */
    @Test
    public void testModifyNotBegin() throws Exception {
        System.out.println("modifyNotBegin");
        StringBuilder word = null;
        String combo = "";
        Generator instance = new Generator();
        instance.modifyNotBegin(word, combo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyEnd method, of class Generator.
     */
    @Test
    public void testModifyEnd() throws Exception {
        System.out.println("modifyEnd");
        StringBuilder word = null;
        String combo = "";
        Generator instance = new Generator();
        instance.modifyEnd(word, combo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyNotEnd method, of class Generator.
     */
    @Test
    public void testModifyNotEnd() throws Exception {
        System.out.println("modifyNotEnd");
        StringBuilder word = null;
        String combo = "";
        Generator instance = new Generator();
        instance.modifyNotEnd(word, combo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfBreak method, of class Generator.
     */
    @Test
    public void testCheckIfBreak() throws Exception {
        System.out.println("checkIfBreak");
        StringBuilder word = null;
        String combo = "";
        Generator instance = new Generator();
        Boolean expResult = null;
        Boolean result = instance.checkIfBreak(word, combo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyMustBreak method, of class Generator.
     */
    @Test
    public void testModifyMustBreak() throws Exception {
        System.out.println("modifyMustBreak");
        Generator instance = new Generator();
        StringBuilder word =null;
        word.append("abbruterz");
        String combo = "br";
        
        instance.modifyMustBreak(word, combo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swapConsecutiveCombo method, of class Generator.
     */
    @Test
    public void testSwapConsecutiveCombo() throws Exception {
        System.out.println("swapConsecutiveCombo");
        StringBuilder word = null;
        int start = 0;
        int end = 0;
        Generator instance = new Generator();
        instance.swapConsecutiveCombo(word, start, end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
