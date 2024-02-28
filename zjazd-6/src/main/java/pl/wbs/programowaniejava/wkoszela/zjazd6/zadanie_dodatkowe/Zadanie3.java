package pl.wbs.programowaniejava.wkoszela.zjazd6.zadanie_dodatkowe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Zadanie3 {


    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:3306/booking_system";
        final String user = "postgres";
        final String password = "password";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj ID studenta do usunięcia: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Studenci WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();

                System.out.println("Student został usunięty.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
