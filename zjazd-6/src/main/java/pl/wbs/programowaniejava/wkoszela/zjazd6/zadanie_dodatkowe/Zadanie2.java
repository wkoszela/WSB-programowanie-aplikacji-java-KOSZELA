package pl.wbs.programowaniejava.wkoszela.zjazd6.zadanie_dodatkowe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:3306/booking_system";
        final String user = "postgres";
        final String password = "password";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj ID studenta: ");
            int id = scanner.nextInt();

            System.out.println("Podaj nowy wiek: ");
            int wiek = scanner.nextInt();

            String sql = "UPDATE Studenci SET wiek = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, wiek);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();

                System.out.println("Wiek studenta został zaktualizowany.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

