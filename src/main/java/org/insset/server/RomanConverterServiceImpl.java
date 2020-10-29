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
    public String convertArabeToRoman(Integer number) throws IllegalArgumentException {
        int nombre = number;
        if (nombre < 1 || nombre> 1999)
        {
            return "Le nombre saisi n'est pas valide entre 1 et 1999";
        }
        String calcul = "";
        
        while (nombre >=1000)
        {
         calcul += "M";
         nombre -= 1000;
        }
        while (nombre >=900)
        {
         calcul += "CM";
         nombre -= 900;
        }
        while (nombre >= 500)
        {
         calcul += "D";
         nombre -= 500;
        }
        while (nombre >=400)
        {
         calcul +="CD";
         nombre -=400;
        }
        while (nombre >=100)
        {
         calcul +="C";
         nombre -=100;
        }
        while (nombre >=90)
        {
         calcul +="XC";
         nombre -=90;
        }
        while (nombre >=50)
        {
         calcul +="L";
         nombre -=50;
        }
        while (nombre >=40)
        {
         calcul +="XL";
         nombre -=40;
        }
        while (nombre >=10)
        {
         calcul +="X";
         nombre -=10;
        }
        while (nombre >=9)
        {
         calcul +="IX";
         nombre -=9;
        }
        while (nombre >=5)
        {
         calcul +="V";
         nombre -=5;
        }
        while (nombre >=4)
        {
         calcul +="IV";
         nombre -=4;
        }
        while (nombre >=1)
        {
         calcul +="I";
         nombre -=1;
        }
        return calcul;
    }

}
