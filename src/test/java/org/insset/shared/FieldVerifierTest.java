/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author insset
 */
public class FieldVerifierTest {

    /**
     * Test of isValidName method, of class FieldVerifier.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        String name = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDecimal method, of class FieldVerifier.
     */
    @Test
    public void testIsValidDecimal() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidDecimal(1);
        assertEquals(true, result);
    }
    
    /**
     * Test of isValidDecimal method, of class FieldVerifier.
     */
    @Test
    public void testIsNotValidDecimal() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidDecimal(-1);
        assertEquals(true, result);
    }

    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRoman() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidRoman("X");
        assertEquals(true, result);
    }
    
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsNotValidRoman() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidRoman("S");
        assertEquals(true, result);
    }

    /**
     * Test of isValidDate method, of class FieldVerifier.
     */
    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        String date = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
