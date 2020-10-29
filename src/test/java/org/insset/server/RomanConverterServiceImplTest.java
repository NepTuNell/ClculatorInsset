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

/**
 *
 * @author insset
 */
public class RomanConverterServiceImplTest {

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe1() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int res = service.convertRomanToArabe("X");
        assertEquals(10, res);
    }
    
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRoman() {
        System.out.println("convertArabeToRoman");
        Integer nbr = 950;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "CML";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
    }
    
    /**
     * 
     */
    @Test
    public void testConvertArabeToRomanNotInRane() {
        System.out.println("convertArabeToRoman");
        Integer nbr = 2000;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "Le nombre saisi n'est pas valide entre 1 et 1999";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
    }
    
}
