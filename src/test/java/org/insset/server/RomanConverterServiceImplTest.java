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
    
    public void testconvertDateYears() {
        RomanConverterServiceImpl projet = new RomanConverterServiceImpl();
        String resultatAttendu;

        String erreurAttendue1 = "La date n'est pas valide.";
        String erreurAttendue2 = "Le jour n'est pas valide.";
        String erreurAttendue3 = "Le mois n'est pas valide.";
        String erreurAttendue4 = "L'année n'est pas valide.";

        // ---------------------------------------------
        // 1 - Test de longueur
        // ---------------------------------------------
        String longueurInvalideTest  = projet.convertDateYears("01/05/102");
        assertEquals(erreurAttendue1, longueurInvalideTest);

        String longueurValideTest = projet.convertDateYears("01/05/1025");
        assertEquals("I/V/MXXV", longueurValideTest);

        // ---------------------------------------------
        // 2 - Test de validité de date uniquement digitale
        // ---------------------------------------------

        // Test sur le jour
        String jourDigitale = projet.convertDateYears("mm/11/1255");
        assertEquals(erreurAttendue2, jourDigitale);

        // Test sur le mois
        String moisDigitale = projet.convertDateYears("15/ab/1255");
        assertEquals(erreurAttendue3, moisDigitale);

        // Test sur l'année
        String anneeDigitale = projet.convertDateYears("15/11/mopl");
        assertEquals(erreurAttendue4, anneeDigitale);

        // ---------------------------------------------
        // 3 - Test de validité des blocs
        // ---------------------------------------------

        // Test sur le mois
        String moisFaible = projet.convertDateYears("15/00/1255");
        assertEquals(erreurAttendue3, moisFaible);

        String moisFort = projet.convertDateYears("15/13/1255");
        assertEquals(erreurAttendue3, moisFort);

        // Test sur le jour
        String jourFaible = projet.convertDateYears("00/05/1255");
        assertEquals(erreurAttendue2, jourFaible);

        String jourFort = projet.convertDateYears("32/05/1255");
        assertEquals(erreurAttendue2, jourFort);

        // Test sur l'année

        // Année faible inutile à tester (Reviens à test l'année 999)
        // Or c'est une date non valide à 3 chiffres
        // -> Test : longueurInvalideTest

        String anneeFort = projet.convertDateYears("15/07/2021");
        assertEquals(erreurAttendue4, anneeFort);

        // ---------------------------------------------
        // 4 - Test de validité des mois à 31 jours
        // ---------------------------------------------

        // Mois de février
        String janvierInvalide = projet.convertDateYears("32/01/2020");
        assertEquals(erreurAttendue2, janvierInvalide);

        String janvierValide = projet.convertDateYears("31/01/2020");
        assertEquals("XXXI/I/MMXX", janvierValide);

        // Mois de Mars
        String moisImpairInvalide = projet.convertDateYears("32/03/2020");
        assertEquals(erreurAttendue2, moisImpairInvalide);

        String moisImpairValide = projet.convertDateYears("31/03/2020");
        assertEquals("XXXI/III/MMXX", moisImpairValide);

        // Mois de Mai
        String maiInvalide = projet.convertDateYears("32/05/2020");
        assertEquals(erreurAttendue2, maiInvalide);

        String maiValide = projet.convertDateYears("31/05/2020");
        assertEquals("XXXI/V/MMXX", maiValide);

        // Mois de Juillet
        String juilletInvalide = projet.convertDateYears("32/07/2020");
        assertEquals(erreurAttendue2, juilletInvalide);

        String juilletValide = projet.convertDateYears("31/07/2020");
        assertEquals("XXXI/VII/MMXX", juilletValide);

        // Mois de Août
        String aoutInvalide = projet.convertDateYears("32/08/2020");
        assertEquals(erreurAttendue2, aoutInvalide);

        String aoutValide = projet.convertDateYears("31/08/2020");
        assertEquals("XXXI/VIII/MMXX", aoutValide);

        // Mois d'octobre
        String octobreInvalide = projet.convertDateYears("32/10/2020");
        assertEquals(erreurAttendue2, octobreInvalide);

        String octobreValide = projet.convertDateYears("31/10/2020");
        assertEquals("XXXI/X/MMXX", octobreValide);

        // Mois de décembre
        String decembreInvalide = projet.convertDateYears("32/12/2020");
        assertEquals(erreurAttendue2, decembreInvalide);

        String decembreValide = projet.convertDateYears("31/12/2020");
        assertEquals("XXXI/XII/MMXX", decembreValide);

        // ---------------------------------------------
        // 5 - Test de validité des mois à 30 jours
        // ---------------------------------------------

        // Mois d'avril
        String avrilInvalide = projet.convertDateYears("31/04/2020");
        assertEquals(erreurAttendue2, avrilInvalide);

        String avrilValide = projet.convertDateYears("30/04/2020");
        assertEquals("XXX/IV/MMXX", avrilValide);

        // Mois de juin
        String juinInvalide = projet.convertDateYears("31/06/2020");
        assertEquals(erreurAttendue2, juinInvalide);

        String juinValide = projet.convertDateYears("30/06/2020");
        assertEquals("XXX/VI/MMXX", juinValide);

        // Mois de septembre
        String septembreInvalide = projet.convertDateYears("31/09/2020");
        assertEquals(erreurAttendue2, septembreInvalide);

        String septembreValide = projet.convertDateYears("30/09/2020");
        assertEquals("XXX/IX/MMXX", septembreValide);

        // Mois de novembre
        String novembreInvalide = projet.convertDateYears("31/11/2020");
        assertEquals(erreurAttendue2, novembreInvalide);

        String novembreValide = projet.convertDateYears("30/11/2020");
        assertEquals("XXX/XI/MMXX", novembreValide);

        // ---------------------------------------------
        // 6 - Test de validité de février
        // ---------------------------------------------

        // Année bissextile
        String BissextileInvalide = projet.convertDateYears("30/02/2000");
        assertEquals(erreurAttendue2, BissextileInvalide);

        String BissextileValide = projet.convertDateYears("29/02/2000");
        assertEquals("XXIX/II/MM", BissextileValide);

        // Année non bissextile
        String NonBissextileInvalide = projet.convertDateYears("29/02/2001");
        assertEquals(erreurAttendue2, NonBissextileInvalide);

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
