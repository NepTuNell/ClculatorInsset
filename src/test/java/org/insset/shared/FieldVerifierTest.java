/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.insset.server.RomanConverterServiceImpl;
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
        FieldVerifier service = new FieldVerifier();
        String name = "toto";
        boolean result = service.isValidName(name);
        assertEquals(true, result);
    }
    
    /**
     * Test of isValidName method, of class FieldVerifier.
     */
    @Test
    public void testIsNullValidName() {
        FieldVerifier service = new FieldVerifier();
        String name = null;
        boolean result = service.isValidName(name);
        assertEquals(false, result);
    }
    
    /**
     * Test of isValidName method, of class FieldVerifier.
     */
    @Test
    public void testIsEmptyValidName() {
        FieldVerifier service = new FieldVerifier();
        String name = "";
        boolean result = service.isValidName(name);
        assertEquals(false, result);
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
        assertEquals(false, result);
    }
    
    /**
     * Test of isValidDecimal method, of class FieldVerifier.
     */
    @Test
    public void testIsNotValidDecimal2() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidDecimal(0);
        assertEquals(false, result);
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
        assertEquals(false, result);
    }
    
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsEmptyValidRoman() {
        FieldVerifier service = new FieldVerifier();
        boolean result = service.isValidRoman("");
        assertEquals(false, result);
    }

    /**
     * Test of isValidDate method, of class FieldVerifier.
     */
    @Test
    public void testconvertDateYearsLongueurPasValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean longueurInvalideTest = projet.isValidDate("01/05/102");
        assertEquals(false, longueurInvalideTest);
    }
    
    @Test
    public void testconvertDateYearsLongueurValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean longueurValideTest = projet.isValidDate("01/05/1025");
        assertEquals(true, longueurValideTest);
    }
    
    @Test
    public void testconvertDateYearsJourPasValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean resultat = projet.isValidDate("mm/11/1255");
        assertEquals(false, resultat);
    }
    
    @Test
    public void testconvertDateYearsJourValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean longueurValideTest = projet.isValidDate("01/05/1025");
        assertEquals(true, longueurValideTest);
    }
    
    @Test
    public void testconvertDateYearsMoisPasValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean moisDigitale = projet.isValidDate("15/ab/1255");
        assertEquals(false, moisDigitale);
    }
    
    @Test
    public void testconvertDateYearsAnneesPasValide() {
        FieldVerifier projet = new FieldVerifier();
        boolean anneeDigitale = projet.isValidDate("15/11/mopl");
        assertEquals(false, anneeDigitale);
    }
    
    @Test
    public void testconvertDateYearsMoisFaible() {
        FieldVerifier projet = new FieldVerifier();
        boolean moisFaible = projet.isValidDate("15/00/1255");
        assertEquals(false, moisFaible);
    }
    
    @Test
    public void testconvertDateYearsMoisFort() {
        FieldVerifier projet = new FieldVerifier();
        boolean moisFort = projet.isValidDate("15/13/1255");
        assertEquals(false, moisFort);
    }
    
    @Test
    public void testconvertDateYearsJourFaible() {
        FieldVerifier projet = new FieldVerifier();
        boolean jourFaible = projet.isValidDate("00/05/1255");
        assertEquals(false, jourFaible);
    }
    
    @Test
    public void testconvertDateYearsJourFort() {
        FieldVerifier projet = new FieldVerifier();
        boolean jourFort = projet.isValidDate("32/05/1255");
        assertEquals(false, jourFort);
    }
    
    @Test
    public void testconvertDateYearsAnneeFort() {
        FieldVerifier projet = new FieldVerifier();
        boolean anneeFort = projet.isValidDate("15/07/2021");
        assertEquals(false, anneeFort);
    }
    
    @Test
    public void testconvertDateYearsInvMoisFev() {
        FieldVerifier projet = new FieldVerifier();
        boolean janvierInvalide = projet.isValidDate("32/01/2020");
        assertEquals(false, janvierInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJan() {
        FieldVerifier projet = new FieldVerifier();
        boolean janvierValide = projet.isValidDate("31/01/2020");
        assertEquals(true, janvierValide);
    }
    
    @Test
    public void testconvertDateYearsInvMoisMars() {
        FieldVerifier projet = new FieldVerifier();
        boolean moisImpairInvalide = projet.isValidDate("32/03/2020");
        assertEquals(false, moisImpairInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisImpair() {
        FieldVerifier projet = new FieldVerifier();
        boolean moisImpairValide = projet.isValidDate("31/03/2020");
        assertEquals(true, moisImpairValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisMaiInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean maiInvalide = projet.isValidDate("32/05/2020");
        assertEquals(false, maiInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisMaiVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean maiValide = projet.isValidDate("31/05/2020");
        assertEquals(true, maiValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuilletInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean juilletInvalide = projet.isValidDate("32/07/2020");
        assertEquals(false, juilletInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuilletVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean juilletValide = projet.isValidDate("31/07/2020");
        assertEquals(true, juilletValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAoutInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean aoutInvalide = projet.isValidDate("32/08/2020");
        assertEquals(false, aoutInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAoutVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean aoutValide = projet.isValidDate("31/08/2020");
        assertEquals(true, aoutValide);
    }
     
    @Test
    public void testconvertDateYearsValideMoisOctInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean octobreInvalide = projet.isValidDate("32/10/2020");
        assertEquals(false, octobreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisOctVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean octobreValide = projet.isValidDate("31/10/2020");
        assertEquals(true, octobreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisDecInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean decembreInvalide = projet.isValidDate("32/12/2020");
        assertEquals(false, decembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisDecVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean decembreValide = projet.isValidDate("31/12/2020");
        assertEquals(true, decembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAvInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean avrilInvalide = projet.isValidDate("31/04/2020");
        assertEquals(false, avrilInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisAvVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean avrilValide = projet.isValidDate("30/04/2020");
        assertEquals(true, avrilValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuiInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean juinInvalide = projet.isValidDate("31/06/2020");
        assertEquals(false, juinInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisJuiVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean juinValide = projet.isValidDate("30/06/2020");
        assertEquals(true, juinValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisSepInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean septembreInvalide = projet.isValidDate("31/09/2020");
        assertEquals(false, septembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisSepVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean septembreValide = projet.isValidDate("30/09/2020");
        assertEquals(true, septembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisNovInv() {
        FieldVerifier projet = new FieldVerifier();
        boolean novembreInvalide = projet.isValidDate("31/11/2020");
        assertEquals(false, novembreInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisNovVal() {
        FieldVerifier projet = new FieldVerifier();
        boolean novembreValide = projet.isValidDate("30/11/2020");
        assertEquals(true, novembreValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevInvAnneeBis() {
        FieldVerifier projet = new FieldVerifier();
        boolean BissextileInvalide = projet.isValidDate("30/02/2000");
        assertEquals(false, BissextileInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevValAnneeBis() {
        FieldVerifier projet = new FieldVerifier();
        boolean BissextileValide = projet.isValidDate("29/02/2000");
        assertEquals(true, BissextileValide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevInvAnneeNonBis() {
        FieldVerifier projet = new FieldVerifier();
        boolean NonBissextileInvalide = projet.isValidDate("29/02/2001");
        assertEquals(false, NonBissextileInvalide);
    }
    
    @Test
    public void testconvertDateYearsValideMoisFevValAnneeNonBis() {
        FieldVerifier projet = new FieldVerifier();
        boolean NonBissextileValide = projet.isValidDate("28/02/2001");
        assertEquals(true, NonBissextileValide);
    }
    
}
