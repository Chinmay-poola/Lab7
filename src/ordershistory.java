import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ordershistory {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop?characterEncoding=utf8";
	   static final String USER = "root";
	   static final String PASS = "watch@123";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


    System.out.println("Showing the status of all your orders");
	System.out.println();
	System.out.print("Enter Your customer id number : ");
	int custId=sc.nextInt();
						
	String sql = "SELECT * from orders WHERE cid="+custId;
											
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
	            System.out.print("order_date : " + rs.getString("order_date"));
			    System.out.print(", isbn : " + rs.getString("isbn"));
                System.out.print(", qty  : " + rs.getString("qty"));
	            System.out.print(", ship_date  : " + rs.getString("ship_date"));
	            System.out.println(", cardnum : " + rs.getString("cardnum"));}  	  
				} 
    catch (SQLException e) {
        e.printStackTrace();}
    sc.close();
    }
}