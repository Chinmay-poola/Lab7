import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class addbook {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/online_shop?characterEncoding=utf8";
	   static final String USER = "root";
	   static final String PASS = "watch@123";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Add a new book in the inventory");
		System.out.print("Enter the isbn of the new book which you want to add : ");
		String isbn=sc.nextLine();
		isbn=sc.nextLine();
						
		System.out.print("Enter the title of the new book which you want to add : ");
		String title=sc.nextLine();
		title=sc.nextLine();
						
		System.out.print("Enter the author of the new book which you want to add : ");
		String author=sc.nextLine();
		author=sc.nextLine();
						
		System.out.print("Enter the price of the new book which you want to add : ");
		float price=sc.nextFloat();
		price=sc.nextFloat();
						
		System.out.print("Enter the year of publishing of the book : ");
		int year=sc.nextInt();
		year=sc.nextInt();
						
		System.out.print("Enter stock of the book : ");
		int stock=sc.nextInt();
		stock=sc.nextInt();
						
		String sql="INSERT INTO Books (isbn,title,author,price,year_published,stock) Values ("+'"'+isbn+'"'+','+'"'+title+'"'+','+'"'+author+'"'+','+price+','+year+','+stock;
							
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();) {
				stmt.executeUpdate(sql);} 
		catch (SQLException e) {
			e.printStackTrace();}
						
		System.out.println("Inserted the book in the inventory");
        sc.close();
	}
}