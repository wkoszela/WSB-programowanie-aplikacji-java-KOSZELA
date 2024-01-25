package pl.wbs.programowaniejava.wkoszela.zjazd4.wyjatki;

public class PropagacjaWyjatku {
    public static void main(String[] args) {
        try {
            performTask();
        } catch (NullPointerException e) {
            System.err.println("Główna metoda obsługuje wyjątek: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void performTask() throws NullPointerException {
        String str = null;

        // Próba dostępu do metody na obiekcie null
        int length = str.length();

        System.out.println("Długość stringa: " + length);
    }
}
