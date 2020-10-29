/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.insset.server.RomanConverterServiceImpl;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author insset
 */
public class RomanConverterServiceImplTest {
    
    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int res = service.convertRomanToArabe("X");
        assertEquals(10, res);
    }
    
    @Test
    public void testConvertRomanToArabe2() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int res = service.convertRomanToArabe("MMD");
        assertEquals(2500, res);
    }
    
    @Test
    public void testConvertArabeToRoman() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        String res = service.convertArabeToRoman(10);
        assertEquals("X", res);
    }
    
    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDate() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        String res = service.convertDateYears("12/08/2014");
        assertEquals("XII/VIII/MMXIV", res);
    }
    
}
