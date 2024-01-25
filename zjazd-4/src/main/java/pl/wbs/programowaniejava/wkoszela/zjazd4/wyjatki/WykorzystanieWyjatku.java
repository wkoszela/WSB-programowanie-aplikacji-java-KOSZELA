package pl.wbs.programowaniejava.wkoszela.zjazd4.wyjatki;

public class WykorzystanieWyjatku {

    public static void main(String[] args) {
//        throw new WlasnyWatek("Nie możliwa operacja - wyjatek");
        safeParseInt("Example");
    }

    public static Integer safeParseInt(String value) {
        try {
            return Integer.parseInt("i");
        } catch (NumberFormatException ex) {
            System.out.println("Failed to parse integer: " + ex.getMessage());
        } finally {
            System.out.println("Finished integer parsing");
        }
        return null;
    }
}
