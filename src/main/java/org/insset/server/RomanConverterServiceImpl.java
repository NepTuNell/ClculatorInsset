/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Map;
import java.util.TreeMap;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        Map<String, Integer> nombresRomain;
        nombresRomain = new TreeMap<>();
        nombresRomain.put("I", 1);
        nombresRomain.put("V", 5);
        nombresRomain.put("X", 10);
        nombresRomain.put("L", 50);
        nombresRomain.put("C", 100);
        nombresRomain.put("D", 500);
        nombresRomain.put("M", 1000);

        int newValue = 0;
        int length = nbr.trim().length();      
        char[] caracters = nbr.toCharArray();
        boolean isChecked = false;
        
        for (int i = 0; i < caracters.length; i++) {
            String caracter1 = String.valueOf(caracters[i]);
                  
            if (!isChecked) {
                if ((i+1) < length) {
                    String caracter2 = String.valueOf(caracters[i+1]);
                    if (nombresRomain.get(caracter1) < nombresRomain.get(caracter2)) {
                        newValue += nombresRomain.get(caracter2) - nombresRomain.get(caracter1);
                        isChecked = true;
                    } else {
                        newValue += nombresRomain.get(caracter1);
                        isChecked = false;
                    }
                } else {
                    newValue += nombresRomain.get(caracter1);
                    isChecked = false;
                }
            } else {
                isChecked = false;
            }

        }
        
        return newValue;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String("XVXX");
    }

}
