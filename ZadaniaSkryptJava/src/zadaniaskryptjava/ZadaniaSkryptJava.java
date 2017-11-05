package zadaniaskryptjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ZadaniaSkryptJava {

    public static void zadanie11() {
        String input = JOptionPane.showInputDialog("Enter a string");
        String newString = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                newString += Character.toString(Character.toUpperCase(input.charAt(i)));
            } else {
                newString += input.charAt(i);
            }
        }
        JOptionPane.showMessageDialog(null, newString);
        System.exit(0);

    }

    public static void zadanie12(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        System.out.println(result);
    }

    public static void zadanie13() {
        int input = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
        int result = 0;
        while (input <= 0) {
            input = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
        }
        if (input % 2 == 0) {
            input--;
        }
        while (input >= 1) {
            result += input;
            input -= 2;
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }

    public static void zadanie14(int number) {
        String result = "";
        int memory = number;
        int rest;
        System.out.println("Liczba: " + number);
        while (number >= 1) {
            rest = number % 2;
            switch (rest) {
                case 0:
                    result = "0" + result;
                    break;
                case 1:
                    result = "1" + result;
                    break;
            }

            number /= 2;

        }
        System.out.println("1. (" + result + ") binarna reprezentacja argumentu,");

        number = memory;
        result = "";

        while (number >= 1) {
            rest = number % 8;
            switch (rest) {
                case 0:
                    result = "0" + result;
                    break;
                case 1:
                    result = "1" + result;
                    break;
                case 2:
                    result = "2" + result;
                    break;
                case 3:
                    result = "3" + result;
                    break;
                case 4:
                    result = "4" + result;
                    break;
                case 5:
                    result = "5" + result;
                    break;
                case 6:
                    result = "6" + result;
                    break;
                case 7:
                    result = "7" + result;
                    break;

            }

            number /= 8;

        }
        System.out.println("2. (" + result + ") ósemkowa reprezentacja argumentu,");

        number = memory;
        result = "";

        while (number >= 1) {
            rest = number % 16;
            switch (rest) {
                case 0:
                    result = "0" + result;
                    break;
                case 1:
                    result = "1" + result;
                    break;
                case 2:
                    result = "2" + result;
                    break;
                case 3:
                    result = "3" + result;
                    break;
                case 4:
                    result = "4" + result;
                    break;
                case 5:
                    result = "5" + result;
                    break;
                case 6:
                    result = "6" + result;
                    break;
                case 7:
                    result = "7" + result;
                    break;
                case 8:
                    result = "8" + result;
                    break;
                case 9:
                    result = "9" + result;
                    break;
                case 10:
                    result = "A" + result;
                    break;
                case 11:
                    result = "B" + result;
                    break;
                case 12:
                    result = "C" + result;
                    break;
                case 13:
                    result = "D" + result;
                    break;
                case 14:
                    result = "E" + result;
                    break;
                case 15:
                    result = "F" + result;
                    break;

            }

            number /= 16;

        }
        System.out.println("3. (" + result + ") szesnastkowa reprezentacja argumentu.");

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //zadanie11();        
        //zadanie12(new BigInteger("10"));
        //zadanie13();
        //zadanie14(100000);
        /*
        Rational rational = new Rational(-4,5);
        Rational rational1 = new Rational(4,5);
        System.out.println(rational.compareTo(rational1));
        System.out.println(rational.getNumerator());
        System.out.println(rational.getDenominator());
        System.out.println(rational.getSing());        
        System.out.println(rational1.getNumerator());
        System.out.println(rational1.getDenominator());
        System.out.println(rational1.getSing());
        System.out.println("");
        rational =rational.addition(rational1);
        System.out.println(rational.getNumerator());
        System.out.println(rational.getDenominator());
        System.out.println(rational.getSing());
        System.out.println("");
        rational =rational.subtraction(rational1);
         */
 /*
        System.out.println(rational.toString());
        System.out.println(rational1.toString());
        rational =rational.division(rational1);        
        System.out.println(rational.toString());
        System.out.println(rational1.toString());
         */
 /*
        Polynomial w[] = new Polynomial[3];
        w[0] = new LinearFunction(2, 1);
        w[1] = new QuadraticFunction(1, -2, 2);
        w[2] = new QuadraticFunction(1, 0, -1);
        for (int i =0 ; i<3; i++){
        System.out.println(w[i].getZeroOfAFunction());
        }
         */
 /* 
        Queue k = new Queue();
        try {
            k.toQueue(new Integer(7));
            k.toQueue(new String("Ala ma kota"));
            k.toQueue(new Double(3.14));
            k.toQueue(new Double(3.14));
            
            for (int i = 1; i <= 5; ++i) {
                System.out.println((k.fromQueue()).toString());
            }
        } catch (Overflow bd) {
            System.out.println("Przepełniona kolejka!");
        } catch (Insufficiency bd) {
            System.out.println("Pusta kolejka!");
        }
         */
 /*
        try {
            Formula wyr = new Formula("(3*((6/3)-1))");
            wyr = new Formula("(2+2)");
            wyr = new Formula("(((3+2)+2)-2)");
            wyr = new Formula("(3*((6/2)-1))");
            System.out.println("" + wyr.calculation());
        } catch (DivisionByZero db) {
            System.out.println("Dzielenie przez zero");
        } catch (IncorrectlyConstructedFormula db) {
            System.out.println("Niepoprawnie skonstruowane wyrażenie");
        }
         */
 /*
        TextEditor textEditor = new TextEditor("Marcinek ma dwa kotki"); // UTF- 8 
        textEditor.saveToFile();
         */
 /*
         GzipCompression gzip = new GzipCompression();
         gzip.compress();
         gzip.decompress();
         */
        
        
    }
}
