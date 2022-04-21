import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class removefromcart {
    static final String DB_URL = "jdbc:mysql://localhost/Lab7";
    static final String USER = "root";
    static final String PASS = "qwe123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  

        System.out.print("Please Enter Your Customer id : ");
        String User=sc.nextLine();
        User = sc.nextLine();
        
        System.out.print("Please enter the ISBN of the book you want to delete"); 
        String isbn= sc.nextLine();
                                        
        String sql="Delete From Cart c Where c.isbn = "+'"'+isbn+'"'+" And c.cid = "+User;
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
            stmt.executeUpdate(sql);}

        catch (SQLException e) {
            e.printStackTrace();}

        sc.close();
    }
}







