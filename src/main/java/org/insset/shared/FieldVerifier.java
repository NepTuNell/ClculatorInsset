package org.insset.shared;

import java.util.Calendar;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(Integer nbr) {
        
        if (nbr < 0) {
            return false;
        } 
      
        return true;
    }

    public static boolean isValidRoman(String nbr) {
        if (nbr.trim().length() == 0) {
            return false;
        }
        
        char[] expected  = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};    
        char[] caracters = nbr.toCharArray();
        Boolean exist = false;

        for (char i: caracters) {
            exist = false;
            for (char j: expected) {
                if (i == j) {
                    exist = true;
                }
            }

            if (false == exist) {
                return false;
            }
        }
        
        return true;
    }

    public static boolean isValidDate(String date) {
        // ---------------------------------------------
        // 1 - Empêcher un mauvais format
        // ---------------------------------------------
        if (date.length() != 10)
            return false;
        
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
                return false;
        }

        contenu = mois.toCharArray();
        for (char lettre : contenu)
        {
            if (!Character.isDigit(lettre))
                return false;
        }

        contenu = annee.toCharArray();
        for (char lettre : contenu)
        {
            if (!Character.isDigit(lettre))
                return false;
        }
        
        // ---------------------------------------------
        // 4 - Vérifier si les blocs sont corrects
        // ---------------------------------------------
        // Mois ------------------------------
        if (Integer.parseInt(mois) < 1 || Integer.parseInt(mois) > 12)
            return false;

        // Jour ------------------------------
        // Janvier 01 - Mars 03 - Mai 05 - Juillet 07 - Aout 08 - octobre 10 - decembre 12
        if (Integer.parseInt(mois) == 1 || Integer.parseInt(mois) == 3 ||
                Integer.parseInt(mois) == 5 || Integer.parseInt(mois) == 7 ||
                Integer.parseInt(mois) == 8 || Integer.parseInt(mois) == 10 ||
                Integer.parseInt(mois) == 12)
        {
            if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 31)
                return false;
        }

        // Avril 04 - Juin 06 - septembre 09 - Novembre 11
        if (Integer.parseInt(mois) == 4 || Integer.parseInt(mois) == 6 ||
                Integer.parseInt(mois) == 9 || Integer.parseInt(mois) == 11)
        {
            if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 30)
                return false;
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
                    return false;
            }
            else
            {
                if (Integer.parseInt(jour) < 1 || Integer.parseInt(jour) > 28)
                    return false;
            }
        }

        // Année ------------------------------
        if (Integer.parseInt(annee) < 1000 ||
                Integer.parseInt(annee) > 2020)
            return false;
        
        return true;
    }
}
