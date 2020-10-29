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

/**
 *
 * @author insset
 */
public class RomanConverterServiceImplTest {
    
    private final int numbA;
    private final String strR;
    
    public RomanConverterServiceImplTest(final String strR, final int numbA) {
        this.strR = strR;
        this.numbA = numbA;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[]{"X",10},
                new Object[]{}
        );
    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int resultExpected =  service.convertRomanToArabe(this.strR);
        assertEquals(this.numbA, resultExpected);
    }
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        
    }
    
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRoman() {
        
    }
    
}
