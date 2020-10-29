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
public class RomanConverterServiceImplIt {

    private final String str;
    private final int result;
    
    public RomanConverterServiceImplIt(final String str, final int result) {
        this.str = str;
        this.result = result;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[]{"X", 10},
                new Object[]{"D", 500}
                
        );
    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe1() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int res = service.convertRomanToArabe(this.str);
        assertEquals(res, this.result);
    }
    
    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe2() {
        RomanConverterServiceImpl service = new RomanConverterServiceImpl();
        int res = service.convertRomanToArabe(this.str);
        assertEquals(res, this.result);
    }
    
    
}
