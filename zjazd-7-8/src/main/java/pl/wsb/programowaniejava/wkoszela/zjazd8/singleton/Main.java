package pl.wsb.programowaniejava.wkoszela.zjazd8.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.setConfiguration("Konfiguracja 1");
        singleton1.showMessage();

        Singleton singleton2 = Singleton.getInstance();
        singleton2.setConfiguration("Konfiguracja 2");
        singleton2.showMessage();

        // Sprawdzenie czy obie instancje Singletona mają tę samą konfigurację
        if (singleton1.getConfiguration().equals(singleton2.getConfiguration())) {
            System.out.println("Obie instancje Singletona mają tę samą konfigurację.");
        } else {
            System.out.println("Instancje Singletona mają różną konfigurację.");
        }
    }
    }

