import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class order {
    static final String DB_URL = "jdbc:mysql://localhost/Lab7";
    static final String USER = "root";
    static final String PASS = "qwe123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        String checkout="Select * from Cart";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery(checkout);) {
           while (rs.next()) {
               String orderIsbn=rs.getString("isbn");
               int cid=rs.getInt("cid");
               int qty=rs.getInt("qty");
               
               String sql="INSERT INTO orders (isbn,qty,cid) Values ("+orderIsbn+'"'+','+qty+','+cid+')';
               stmt.executeUpdate(sql);
            }  	  
             } catch (SQLException e) {
                e.printStackTrace();
             }

    sc.close();
    }
}