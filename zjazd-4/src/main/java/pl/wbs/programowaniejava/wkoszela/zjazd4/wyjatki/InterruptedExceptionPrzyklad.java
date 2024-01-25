package pl.wbs.programowaniejava.wkoszela.zjazd4.wyjatki;

public class InterruptedExceptionPrzyklad {

    public static void main(String[] args) {
            Thread myThread = new Thread(() -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Startowanie zadania: " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // Obsługa przerwania wątku
                    System.err.println("Wątek przerwany!");
                    e.printStackTrace();
                }
            });

            myThread.start();

            // Czekaj 10 sekundy, a następnie przerwij wątek
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myThread.interrupt();
        }
    }

