package peaksoft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.dao.Connect.connect;

/**
 * @author Zha_Aibek@mail.com
 */
public class Cities {
    public static void addTableCity() {
        String sql = "CREATE TABLE cities " +
                "(id SERIAL PRIMARY KEY , " +
                " name VARCHAR(50) NOT NULL, " +
                " politic_id INT REFERENCES politics(id))";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table successfully created...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addCities(String name) {
        String sql = "INSERT INTO cities (name) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement pStmt = conn.prepareStatement(sql)) {
            pStmt.setString(1, name);
            pStmt.executeUpdate();
            System.out.println("add cities...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Cities> getAllCities() {
        return null;
    }
}
