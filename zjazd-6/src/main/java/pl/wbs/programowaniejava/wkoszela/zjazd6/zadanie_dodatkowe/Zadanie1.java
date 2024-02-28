package pl.wbs.programowaniejava.wkoszela.zjazd6.zadanie_dodatkowe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:3306/booking_system";
        final String user = "postgres";
        final String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj imię: ");
            String imie = scanner.nextLine();

            System.out.println("Podaj nazwisko: ");
            String nazwisko = scanner.nextLine();

            System.out.println("Podaj wiek: ");
            int wiek = scanner.nextInt();

            String sql = "INSERT INTO Studenci (imie, nazwisko, wiek) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, imie);
                pstmt.setString(2, nazwisko);
                pstmt.setInt(3, wiek);
                pstmt.executeUpdate();

                System.out.println("Student został dodany.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}