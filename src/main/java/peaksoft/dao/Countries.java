package peaksoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static peaksoft.dao.Connect.connect;

/**
 * @author Zha_Aibek@mail.com
 */
public class Countries {
    public static void addTableCountry() {
        String sql = "CREATE TABLE countries " +
                "(id SERIAL PRIMARY KEY , " +
                " name VARCHAR(50) UNIQE NOT NULL, " +
                " politic_id INT REFERENCES politics(id))";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table successfully created...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addCountries(String name) {
        String sql = "INSERT INTO countries (name) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("add Country !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
