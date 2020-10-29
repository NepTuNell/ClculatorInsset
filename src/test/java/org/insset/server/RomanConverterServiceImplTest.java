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
    
    @Test
    public void testconvertDateYearsLongueurPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String expected = "La date n'est pas valide.";
        String longueurInvalideTest  = projet.convertDateYears("01/05/102");
        assertEquals(expected, longueurInvalideTest);
    }
    
    @Test
    public void testconvertDateYearsLongueurValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String longueurValideTest = projet.convertDateYears("01/05/1025");
        assertEquals("I/V/MXXV", longueurValideTest);
    }
    
    @Test
    public void testconvertDateYearsJourPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String jourDigitale = projet.convertDateYears("mm/11/1255");
        assertEquals("La date n'est pas valide.", jourDigitale);
    }
    
    @Test
    public void testconvertDateYearsJourValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String longueurValideTest = projet.convertDateYears("01/05/1025");
        assertEquals("I/V/MXXV", longueurValideTest);
    }
    
    @Test
    public void testconvertDateYearsMoisPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisDigitale = projet.convertDateYears("15/ab/1255");
        assertEquals("La date n'est pas valide.", moisDigitale);
    }
    
    @Test
    public void testconvertDateYearsAnneesPasValide() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String anneeDigitale = projet.convertDateYears("15/11/mopl");
        assertEquals("La date n'est pas valide.", anneeDigitale);
    }
    
    @Test
    public void testconvertDateYearsMoisFaible() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisFaible = projet.convertDateYears("15/00/1255");
        assertEquals("La date n'est pas valide.", moisFaible);
    }
    
    @Test
    public void testconvertDateYearsMoisFort() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisFort = projet.convertDateYears("15/13/1255");
        assertEquals("La date n'est pas valide.", moisFort);
    }
    
    @Test
    public void testconvertDateYearsJourFaible() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String jourFaible = projet.convertDateYears("00/05/1255");
        assertEquals("La date n'est pas valide.", jourFaible);
    }
    
    @Test
    public void testconvertDateYearsJourFort() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String jourFort = projet.convertDateYears("32/05/1255");
        assertEquals("La date n'est pas valide.", jourFort);
    }
    
    @Test
    public void testconvertDateYearsAnneeFort() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String anneeFort = projet.convertDateYears("15/07/2021");
        assertEquals("La date n'est pas valide.", anneeFort);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFev() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String janvierInvalide = projet.convertDateYears("32/01/2020");
        assertEquals("La date n'est pas valide.", janvierInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJan() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String janvierValide = projet.convertDateYears("31/01/2020");
        assertEquals("XXXI/I/MMXX", janvierValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisMars() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisImpairInvalide = projet.convertDateYears("32/03/2020");
        assertEquals("La date n'est pas valide.", moisImpairInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisImpair() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String moisImpairValide = projet.convertDateYears("31/03/2020");
        assertEquals("XXXI/III/MMXX", moisImpairValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisMaiInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String maiInvalide = projet.convertDateYears("32/05/2020");
        assertEquals("La date n'est pas valide.", maiInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisMaiVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String maiValide = projet.convertDateYears("31/05/2020");
        assertEquals("XXXI/V/MMXX", maiValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuilletInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String juilletInvalide = projet.convertDateYears("32/07/2020");
        assertEquals("La date n'est pas valide.", juilletInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuilletVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String juilletValide = projet.convertDateYears("31/07/2020");
        assertEquals("XXXI/VII/MMXX", juilletValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAoutInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String aoutInvalide = projet.convertDateYears("32/08/2020");
        assertEquals("La date n'est pas valide.", aoutInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAoutVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String aoutValide = projet.convertDateYears("31/08/2020");
        assertEquals("XXXI/VIII/MMXX", aoutValide);
    }
     
    @Test
    public void testconvertDateYearsValideMoisOctInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String octobreInvalide = projet.convertDateYears("32/10/2020");
        assertEquals("La date n'est pas valide.", octobreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisOctVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String octobreValide = projet.convertDateYears("31/10/2020");
        assertEquals("XXXI/X/MMXX", octobreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisDecInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String decembreInvalide = projet.convertDateYears("32/12/2020");
        assertEquals("La date n'est pas valide.", decembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisDecVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String decembreValide = projet.convertDateYears("31/12/2020");
        assertEquals("XXXI/XII/MMXX", decembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAvInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String avrilInvalide = projet.convertDateYears("31/04/2020");
        assertEquals("La date n'est pas valide.", avrilInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAvVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String avrilValide = projet.convertDateYears("30/04/2020");
        assertEquals("XXX/IV/MMXX", avrilValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuiInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String juinInvalide = projet.convertDateYears("31/06/2020");
        assertEquals("La date n'est pas valide.", juinInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuiVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String juinValide = projet.convertDateYears("30/06/2020");
        assertEquals("XXX/VI/MMXX", juinValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisSepInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String septembreInvalide = projet.convertDateYears("31/09/2020");
        assertEquals("La date n'est pas valide.", septembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisSepVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String septembreValide = projet.convertDateYears("30/09/2020");
        assertEquals("XXX/IX/MMXX", septembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisNovInv() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String novembreInvalide = projet.convertDateYears("31/11/2020");
        assertEquals("La date n'est pas valide.", novembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisNovVal() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String novembreValide = projet.convertDateYears("30/11/2020");
        assertEquals("XXX/XI/MMXX", novembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevInvAnneeBis() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String BissextileInvalide = projet.convertDateYears("30/02/2000");
        assertEquals("La date n'est pas valide.", BissextileInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevValAnneeBis() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String BissextileValide = projet.convertDateYears("29/02/2000");
        assertEquals("XXIX/II/MM", BissextileValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevInvAnneeNonBis() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String NonBissextileInvalide = projet.convertDateYears("29/02/2001");
        assertEquals("La date n'est pas valide.", NonBissextileInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevValAnneeNonBis() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String NonBissextileValide = projet.convertDateYears("28/02/2001");
        assertEquals("XXVIII/II/MMI", NonBissextileValide);
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
