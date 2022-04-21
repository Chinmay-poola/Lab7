import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class custinfo {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop?characterEncoding=utf8";
	   static final String USER = "root";
	   static final String PASS = "watch@123";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Looking all the customer information");
		String sql="SELECT * FROM customers";
						
						
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
	            System.out.print("cid : " + rs.getString("cid"));
			    System.out.print(", cname : " + rs.getString("cname"));
		        System.out.println(", address  : " + rs.getString("address"));}  	  
		} 
        catch (SQLException e){
			e.printStackTrace();}
		sc.close();
		}
}
