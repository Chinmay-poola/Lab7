import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class addtocart {
    static final String DB_URL = "jdbc:mysql://localhost/Lab7";
    static final String USER = "root";
    static final String PASS = "qwe123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        
        System.out.print("Enter the ISBN number of the boks which you want to add into your cart : ");
		String addisbn=sc.nextLine();
		addisbn=sc.nextLine();
		System.out.println("Adding "+addisbn+" to the cart");
        System.out.print("Please Enter Your Customer id : ");
		String User=sc.nextLine();
		User = sc.nextLine();
								
								
		System.out.print("\nPlease Enter The Title"); 
		String title = sc.nextLine();
		title = sc.nextLine();
								
		System.out.print("\nPlease Enter The Quantity"); 
		int qty=sc.nextInt();
								
		String sql = "Insert Into Cart Values("+'"'+User+'"'+','+'"'+addisbn+'"'+','+qty+','+'"'+title+'"'+')';
								
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();) {
				stmt.executeUpdate(sql);} 
        catch (SQLException e) {
		e.printStackTrace();}

        sc.close();
    }
}