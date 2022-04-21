import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class creation {
  static final String DB_URL = "jdbc:mysql://localhost:3306";
  static final String USER = "root";
  static final String PASS = "qwe123";

  public static void main(String[] args) {
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
      ){    
          String drdb = "DROP DATABASE IF EXISTS Lab7";
          stmt.executeUpdate(drdb);
        
          String crtdb = "CREATE DATABASE Lab7";
          stmt.executeUpdate(crtdb);
          System.out.println("Database created successfully...");  

          String usedb = "USE Lab7";
          stmt.executeUpdate(usedb);
          System.out.println("using database");

          String books = "CREATE TABLE Books (isbn CHAR(10), title CHAR(80), author CHAR(80), qty_in_stock INTEGER, price REAL, year_published INTEGER, PRIMARY KEY ( isbn ))";        
          stmt.executeUpdate(books);
          System.out.println("Created table books in given database...");  

          String cust = "CREATE TABLE Customers (cid INTEGER, cname CHAR(80), address CHAR(200), PRIMARY KEY ( cid ))";
          stmt.executeUpdate(cust);
          System.out.println("Created table customers in given database..."); 

          String orders = "CREATE TABLE Orders (ordernum INTEGER, isbn CHAR(10), cid INTEGER, " +
                  "cardnum CHAR(60), qty INTEGER, order_date DATE, ship_date DATE,"+
                  "PRIMARY KEY ( ordernum ), FOREIGN KEY (isbn) REFERENCES Books(isbn), FOREIGN KEY (cid) REFERENCES Customers(cid))";
          stmt.executeUpdate(orders);
          System.out.println("Created table orders in given database...");       
          
          String cart = "CREATE TABLE Cart (cname CHAR(80), addisbn INT, quantity INT, title CHAR(100))";
          stmt.executeUpdate(cart);
          System.out.println("Created table cart in given database..."); 

        
        }
     catch (SQLException e) {
        e.printStackTrace();}
    }
}
