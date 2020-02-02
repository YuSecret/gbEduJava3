import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        //createTable("NewTable");
        //dropTable("NewTable");
        //uodateRecord("students", "5008", "4");
        //insertRecord("students", "XXX",50);
        //deleteRecord("students", "5014");
        selectRecord("students");
    }

    public static void createTable(String tableName) {
        String sql = String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT,n TEXT,score INTEGER);", tableName);
        System.out.println(sql);
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void dropTable(String tableName) {
        String sql = String.format("DROP TABLE %s", tableName);
        System.out.println(sql);
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void uodateRecord(String tableName, String id, String newVal) {
        String sql = String.format("UPDATE %s set score = %s where id = %s", tableName, newVal, id);
        System.out.println(sql);
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertRecord(String tableName, String newVal1, int newVal2) {
        String sql = String.format("INSERT INTO %s (name, score) values('%s', %s)", tableName, newVal1, newVal2);
        System.out.println(sql);
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void selectRecord(String tableName) {
        String sql = String.format("SELECT * FROM %s ", tableName);
        System.out.println(sql);
        try {
            connect();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name")+" "+ rs.getString("score"));
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRecord(String tableName, String id) {
        String sql = String.format("DELETE FROM %s where id = %s", tableName, id);
        System.out.println(sql);
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Lesson2/mydb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
