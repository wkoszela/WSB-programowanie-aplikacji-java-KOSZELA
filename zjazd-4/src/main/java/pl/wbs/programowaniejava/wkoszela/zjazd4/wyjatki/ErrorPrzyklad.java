package pl.wbs.programowaniejava.wkoszela.zjazd4.wyjatki;

import static java.lang.Integer.MAX_VALUE;

public class ErrorPrzyklad {

    public static void main(String[] args) {

        try {

            int[] intArray = new int[MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.err.println("Wystąpił błąd braku pamięci: " + e.getMessage());
        }
    }


}
