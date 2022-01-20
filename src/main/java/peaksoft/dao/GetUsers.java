package peaksoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static peaksoft.dao.Connect.connect;

/**
 * @author Zha_Aibek@mail.com
 */
public class GetUsers {
    public static int getCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("From (/name Table/)");
        String SQL = "SELECT COUNT (*)" + sc.nextLine();
        int count = 0;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
