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
    
    public void testconvertDateYearsLongueurPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String expected = "La date n'est pas valide.";
        String longueurInvalideTest  = projet.convertDateYears("01/05/102");
        assertEquals(expected, longueurInvalideTest);
    }
    
    public void testconvertDateYearsLongueurValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String longueurValideTest = projet.convertDateYears("01/05/1025");
        assertEquals("I/V/MXXV", longueurValideTest);
    }
    
    public void testconvertDateYearsJourPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String jourDigitale = projet.convertDateYears("mm/11/1255");
        assertEquals("La date n'est pas valide.", jourDigitale);
    }
    
    public void testconvertDateYearsJourValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String longueurValideTest = projet.convertDateYears("01/05/1025");
        assertEquals("I/V/MXXV", longueurValideTest);
    }
    
     public void testconvertDateYearsMoisPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisDigitale = projet.convertDateYears("15/ab/1255");
        assertEquals("La date n'est pas valide.", moisDigitale);
    }
    
    public void testconvertDateYearsAnneesPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String anneeDigitale = projet.convertDateYears("15/11/mopl");
        assertEquals("La date n'est pas valide.", anneeDigitale);
    }
     
    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
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
