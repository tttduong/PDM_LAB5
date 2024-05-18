
//            "jdbc:sqlserver://DESKTOP-EJIGPN3\\SQLEXPRESS;" +
//                    "databaseName=OnlineExaminationSystem;" +
//                    "user=sa;password=123456;encrypt=true;" +
//                    "trustServerCertificate=true;";

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnectSQL {
    public static void showQuery(String query, JTable resultTable) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("123456");
            ds.setServerName("DESKTOP-EJIGPN3\\SQLEXPRESS");
            ds.setPortNumber(1433);
            ds.setDatabaseName("DTB");
            ds.setEncrypt(false);

            con = ds.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(
                        null,
                        "No data found.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                resultTable.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(
                        null,
                        "Query executed successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error executing query: " + e.getMessage(),
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
        } finally {
            // Close the ResultSet, PreparedStatement, and Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
            closeConnect(con);
        }
    }


    private static void closeConnect(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
