package pl.wsb.programowaniejava.wkoszela.zjazd8.singleton;

public class Singleton {
    // Prywatne statyczne pole przechowujące instancję Singletona
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Jestem instancją Singletona!");
    }
}

