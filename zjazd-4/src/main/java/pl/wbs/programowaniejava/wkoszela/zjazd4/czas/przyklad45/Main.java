package pl.wbs.programowaniejava.wkoszela.zjazd4.czas.przyklad45;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.printf("##### Local%n");

        // Winter
        LocalDateTime winterLocal = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        // Summer
        LocalDateTime summerLocal = LocalDateTime.parse("2022-07-01T00:00:00");

        System.out.println("Winter Local: " + winterLocal);
        System.out.println("Summer Local: " + summerLocal);

        System.out.printf("%n##### Same instant%n");

        // Zones
        ZoneId warsawZone = ZoneId.of("Europe/Warsaw");
        ZoneId londonZone = ZoneId.of("Europe/London");

        ZonedDateTime winterWarsawZone = ZonedDateTime.of(winterLocal, warsawZone);
        ZonedDateTime summerWarsawZone = ZonedDateTime.of(summerLocal, warsawZone);

        System.out.println("Winter Warsaw Zoned: " + winterWarsawZone);
        System.out.println("Summer Warsaw Zoned: " + summerWarsawZone);

        System.out.println("Winter Warsaw Offset: " + winterWarsawZone.toOffsetDateTime());
        System.out.println("Summer Warsaw Offset: " + summerWarsawZone.toOffsetDateTime());

        System.out.println("Winter London Zoned: " + winterWarsawZone.withZoneSameInstant(londonZone));
        System.out.println("Summer London Zoned: " + summerWarsawZone.withZoneSameInstant(londonZone));

        System.out.println("Winter London Offset: " + winterWarsawZone.withZoneSameInstant(londonZone).toOffsetDateTime());
        System.out.println("Summer London Offset: " + summerWarsawZone.withZoneSameInstant(londonZone).toOffsetDateTime());

        System.out.printf("%n##### Same local%n");

        System.out.println("Winter Warsaw Zoned: " + winterWarsawZone);
        System.out.println("Summer Warsaw Zoned: " + summerWarsawZone);

        System.out.println("Winter London Zoned (same local): " + winterWarsawZone.withZoneSameLocal(londonZone));
        System.out.println("Summer London Zoned (same local): " + summerWarsawZone.withZoneSameLocal(londonZone));
    }
}
