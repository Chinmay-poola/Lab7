import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class updatezefile {
    static final String DB_URL = "jdbc:mysql://localhost/Lab7";
    static final String USER = "root";
    static final String PASS = "qwe123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
    System.out.println("Enter your cid : ");
	int cid=sc.nextInt();
	System.out.println("Your Entered cid was : "+cid);
	System.out.println("Enter your password");
	String pass=sc.nextLine();
	pass=sc.nextLine();
						
						
	System.out.println("Your entered password is : "+pass);
	System.out.print("Enter your new address : ");
	String newAddress=sc.nextLine();
	System.out.println("Your entered address is : "+newAddress);
						
	String sql = "UPDATE customers set address="+'"'+newAddress+'"'+"Where pass="+'"'+pass+'"'+" AND cid="+cid;
						
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
		stmt.executeUpdate(sql);
		} catch (SQLException e) {
		e.printStackTrace();} 
    sc.close();
    }
}

