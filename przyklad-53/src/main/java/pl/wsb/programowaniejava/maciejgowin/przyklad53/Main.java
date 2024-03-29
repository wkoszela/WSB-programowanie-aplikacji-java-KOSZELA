package pl.wsb.programowaniejava.maciejgowin.przyklad53;

import java.sql.Connection;
import java.util.Locale;

import static pl.wsb.programowaniejava.maciejgowin.przyklad53.Configuration.createSchema;
import static pl.wsb.programowaniejava.maciejgowin.przyklad53.Configuration.getConnection;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try (Connection connection = getConnection(); AirportManager airportManager = new AirportManager(connection)) {

            createSchema(connection);

            // List airports
            System.out.printf("Check (1): %s%n", airportManager.getAirports());

            // Delete airports
            airportManager.deleteAirports();

            // List airports
            System.out.printf("Check (2): %s%n", airportManager.getAirports());

            // Add airports
            airportManager.addAirport(new Airport("WRO", "Wroclaw", 1.1, 11.11));
            airportManager.addAirport(new Airport("DUB", "Dublin", 2.2, 22.22));
            airportManager.addAirport(new Airport("PRG", "Prague", 3.3, 33.33));

            // List airports
            System.out.printf("Check (3): %s%n", airportManager.getAirports());

            // Get airport by code
            System.out.printf("Check (4): %s%n", airportManager.getAirport("WRO"));
            System.out.printf("Check (5): %s%n", airportManager.getAirport("BCN"));

            // Update airport
            airportManager.updateAirport(new Airport("WRO", "Wroclaw Miasto Spotkan", 1.1, 11.11));

            // List airports
            System.out.printf("Check (6): %s%n", airportManager.getAirports());
        } catch(Exception e) {
            System.out.printf("Failed: %s%n", e.getMessage());
        }
    }
}
