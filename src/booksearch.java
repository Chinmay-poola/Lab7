import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class booksearch {
  static final String DB_URL = "jdbc:mysql://localhost/Lab7";
  static final String USER = "root";
  static final String PASS = "qwe123";

  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book");						
		String name = sc.nextLine();
		name = sc.nextLine();
		System.out.println("The name of the book you entered is : "+name+";");
		String sql = "SELECT * FROM Books where title="+'"'+name+'"';
								
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
			    System.out.print("ISBN : " + rs.getString("isbn"));
				System.out.print(", TITLE : " + rs.getString("title"));
				System.out.print(", INDEX  : " + rs.getInt("idx"));
				System.out.print(", AUTHOR : " + rs.getString("author"));
	            System.out.print(", PRICE : " + rs.getInt("price"));
	            System.out.print(", YEAR Published : " + rs.getInt("year_published"));
	            System.out.println(", STOCK : " + rs.getInt("stock"));
				}  	  
				} 
                catch (SQLException e) {
				e.printStackTrace();} 
        sc.close();
    }
}


