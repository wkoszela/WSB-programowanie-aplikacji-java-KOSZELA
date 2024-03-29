package pl.wbs.programowaniejava.wkoszela.zjazd4.czas.zadanie24;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityLocalTime {

    public static void main(String[] args) throws Exception {
        timeCalculate(new String[]{"Warszawa"});
    }
    public static void timeCalculate(String[] args) throws Exception {

        String timezones = "/Users/wkoszela/Programowanie/WSB-programowanie-aplikacji-java-KOSZELA/zjazd-4/src/main/java/pl/wbs/programowaniejava/wkoszela/zjazd4/czas/zadanie24/timezones";
        String city = args[0];

        Map<String, String> timezonePerCity = Files.readAllLines(Path.of(timezones))
                .stream()
                .filter(Objects::nonNull)
                .map(cityTimezone -> cityTimezone.split(","))
                .filter(cityTimezone -> cityTimezone.length == 2)
                .collect(Collectors.toMap(v -> v[0], v -> v[1]));


        ZoneId timezone = Optional.ofNullable(timezonePerCity.get(city))
                .map(t -> ZoneId.of(t))
                .orElseThrow();

        System.out.printf("Local time in %s: %s", city, OffsetDateTime.now().atZoneSameInstant(timezone).toLocalDateTime());
    }
}
