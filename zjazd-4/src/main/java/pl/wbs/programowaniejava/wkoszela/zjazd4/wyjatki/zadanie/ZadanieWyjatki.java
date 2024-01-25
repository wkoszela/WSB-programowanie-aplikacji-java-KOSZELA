package pl.wbs.programowaniejava.wkoszela.zjazd4.wyjatki.zadanie;

public class ZadanieWyjatki {

    public static void main(String[] args) {
        runCalculator(new String[]{"10", "/", "0"});
    }

    public static void runCalculator(String[] args) {

        try {
            int num1 = Integer.parseInt(args[0]);
            String operator = args[1];
            int num2 = Integer.parseInt(args[2]);

            int result = calculate(num1, operator, num2);
            System.out.println("Wynik: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Błąd! Niepoprawne argumenty liczbowe.");
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd! " + e.getMessage());
        }
    }

    private static int calculate(int num1, String operator, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Nie można dzielić przez zero!");
                }
            default:
                throw new IllegalArgumentException("Niepoprawny operator: " + operator);
        }
    }
}
