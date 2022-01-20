package peaksoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static peaksoft.dao.Connect.connect;

/**
 * @author Zha_Aibek@mail.com
 */
public class Politics {
    public static void addTablePolitic() {
        String sql = "CREATE TABLE politics " +
                "(id SERIAL PRIMARY KEY , " +
                " name VARCHAR(100) NOT NULL, " +
                " age INT)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table successfully created...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addPolitics(String name, int age) {
        String sql = "INSERT INTO politics(name, age) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            System.out.println("Politics add !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
