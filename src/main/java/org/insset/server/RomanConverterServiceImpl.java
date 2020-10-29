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
import java.util.Calendar;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String date) throws IllegalArgumentException {
        // Format d'entrée souhaité : 22021596
        // 22 Février 1596

        // ---------------------------------------------
        // 1 - Empêcher un mauvais format
        // ---------------------------------------------
        if (date.length() != 10)
            return "La date n'est pas valide.";

        // ---------------------------------------------
        // 2 - Séparer les blocs
        // ---------------------------------------------
        String jour = "" + date.substring(0, 2);
        String mois = "" + date.substring(3, 5);
        String annee = "" + date.substring(6, 10);

        // ---------------------------------------------
        // 3 - Vérifier la présence de chiffre uniquement
        // ---------------------------------------------
        char[] contenu;

        contenu = jour.toCharArray();
        for (char lettre : contenu)
        {
            if (!Character.isDigit(lettre))
                return "Le jour n'est pas valide.";
        }

        contenu = mois.toCharArray();
        for (char lettre : contenu)
        {
            if (!Character.isDigit(lettre))
                return "Le mois n'est pas valide.";
        }

        contenu = annee.toCharArray();
        for (char lettre : contenu)
        {
            if (!Character.isDigit(lettre))
                return "L'année n'est pas valide.";
        }

        // ---------------------------------------------
        // 4 - Vérifier si les blocs sont corrects
        // ---------------------------------------------
        // Mois ------------------------------
        if (Integer.parseInt(mois) < 1 || Integer.parseInt(mois) > 12)
            return "Le mois n'est pas valide.";

        // Jour ------------------------------
        // Janvier 01 - Mars 03 - Mai 05 - Juillet 07 - Aout 08 - octobre 10 - decembre 12
        if (Integer.parseInt(mois) == 1 || Integer.parseInt(mois) == 3 ||
                Integer.parseInt(mois) == 5 || Integer.parseInt(mois) == 7 ||
                Integer.parseInt(mois) == 8 || Integer.parseInt(mois) == 10 ||
                Integer.parseInt(mois) == 12)
        {
            if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 31)
                return "Le jour n'est pas valide.";
        }

        // Avril 04 - Juin 06 - septembre 09 - Novembre 11
        if (Integer.parseInt(mois) == 4 || Integer.parseInt(mois) == 6 ||
                Integer.parseInt(mois) == 9 || Integer.parseInt(mois) == 11)
        {
            if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 30)
                return "Le jour n'est pas valide.";
        }

        // Février
        if (Integer.parseInt(mois) == 2)
        {
            boolean anneeBissextile = false;

            if ((Integer.parseInt(annee) % 4 == 0 && Integer.parseInt(annee) % 100 != 0) ||
                    Integer.parseInt(annee) % 400 == 0)
                anneeBissextile = true;

            if (anneeBissextile)
            {
                if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 29)
                    return "Le jour n'est pas valide.";
            }
            else
            {
                if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 28)
                    return "Le jour n'est pas valide.";
            }
        }

        // Année ------------------------------
        if (Integer.parseInt(annee) < 1000 ||
                Integer.parseInt(annee) > Calendar.getInstance().get(Calendar.YEAR))
            return "L'année n'est pas valide.";

        // ---------------------------------------------
        // 5 - Convertir le jour
        // ---------------------------------------------
        int nombreJour = Integer.parseInt(jour);
        String calculJour = "";

        while (nombreJour >= 10)
        {
            calculJour += "X";
            nombreJour -= 10;
        }

        while (nombreJour >= 9)
        {
            calculJour += "IX";
            nombreJour -= 9;
        }

        while (nombreJour >= 5)
        {
            calculJour += "V";
            nombreJour -= 5;
        }

        while (nombreJour >= 4)
        {
            calculJour += "IV";
            nombreJour -= 4;
        }

        while (nombreJour >= 1)
        {
            calculJour += "I";
            nombreJour -= 1;
        }

        // ---------------------------------------------
        // 6 - Convertir le mois
        // ---------------------------------------------
        int nombreMois = Integer.parseInt(mois);
        String calculMois = "";

        while (nombreMois >= 10)
        {
            calculMois += "X";
            nombreMois -= 10;
        }

        while (nombreMois >= 9)
        {
            calculMois += "IX";
            nombreMois -= 9;
        }

        while (nombreMois >= 5)
        {
            calculMois += "V";
            nombreMois -= 5;
        }

        while (nombreMois >= 4)
        {
            calculMois += "IV";
            nombreMois -= 4;
        }

        while (nombreMois >= 1)
        {
            calculMois += "I";
            nombreMois -= 1;
        }

        // ---------------------------------------------
        // 7 - Convertir l'année
        // ---------------------------------------------
        int nombreAnnee = Integer.parseInt(annee);
        String calculAnnee = "";

        while (nombreAnnee >= 1000)
        {
            calculAnnee += "M";
            nombreAnnee -= 1000;
        }

        while (nombreAnnee >= 900)
        {
            calculAnnee += "CM";
            nombreAnnee -= 900;
        }

        while (nombreAnnee >= 500)
        {
            calculAnnee += "D";
            nombreAnnee -= 500;
        }

        while (nombreAnnee >= 400)
        {
            calculAnnee += "CD";
            nombreAnnee -= 400;
        }

        while (nombreAnnee >= 100)
        {
            calculAnnee += "C";
            nombreAnnee -= 100;
        }

        while (nombreAnnee >= 90)
        {
            calculAnnee += "XC";
            nombreAnnee -= 90;
        }

        while (nombreAnnee >= 50)
        {
            calculAnnee += "L";
            nombreAnnee -= 50;
        }

        while (nombreAnnee >= 40)
        {
            calculAnnee += "XL";
            nombreAnnee -= 40;
        }

        while (nombreAnnee >= 10)
        {
            calculAnnee += "X";
            nombreAnnee -= 10;
        }

        while (nombreAnnee >= 9)
        {
            calculAnnee += "IX";
            nombreAnnee -= 9;
        }

        while (nombreAnnee >= 5)
        {
            calculAnnee += "V";
            nombreAnnee -= 5;
        }

        while (nombreAnnee >= 4)
        {
            calculAnnee += "IV";
            nombreAnnee -= 4;
        }

        while (nombreAnnee >= 1)
        {
            calculAnnee += "I";
            nombreAnnee -= 1;
        }

        return calculJour + "/" + calculMois + "/" + calculAnnee;
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
