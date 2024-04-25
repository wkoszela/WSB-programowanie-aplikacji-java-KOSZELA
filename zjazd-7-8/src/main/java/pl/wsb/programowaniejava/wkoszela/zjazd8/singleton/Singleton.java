package pl.wsb.programowaniejava.wkoszela.zjazd8.singleton;

public class Singleton {
    private static Singleton instance;
    private String configuration;

    private Singleton() {
        // Prywatny konstruktor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Metoda do ustawiania konfiguracji
    public void setConfiguration(String config) {
        this.configuration = config;
    }

    // Metoda do pobierania konfiguracji
    public String getConfiguration() {
        return configuration;
    }

    public void showMessage() {
        System.out.println("Jestem instancją Singletona z konfiguracją: " + configuration);
    }
}


