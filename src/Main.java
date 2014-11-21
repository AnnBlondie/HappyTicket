//import java.util.;
import java.sql.*;
import org.postgresql.Driver;


public class Main {
		public static void main(String[] args){
		Customer customer1 = new Customer("adult");
	    //Date date = new Date(92, 1, 10);
	    // date.setTime(10000);
	    Date date = new Date(1111111111);
	
		//java.util.Date date = new java.util.Date(now);
	
		Reservation reservation = new Reservation(customer1, 1, date, 1, "Ivanov");
		String s = reservation.toString();
		System.out.println(s);	
		Ticket ticket = new Ticket(reservation);
		
		
		//database connection
		String username = "postgres";
		String password = "12345";
		String url = "jdbc:postgresql://localhost:5432/library"; 
		try {
		      Class.forName("org.postgresql.Driver");
		         System.out.println("Driver loading success!");
		     } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		     } 
		  
		  Connection db = null;
		  try {
		   db = DriverManager.getConnection(url, username, password);
		         System.out.println("Connection success!");
		         Statement st = db.createStatement();
		         ResultSet rs = st.executeQuery("select * from librarian");
		         while(rs.next()){
		                System.out.print(rs.getString("name"));//Последовательно для каждой строки выводим значение из колонки ColumnName   
		                System.out.print(" ");
		                System.out.print(rs.getString("lastname"));
		                System.out.println();
		           }
		     } catch (Exception e) {
		         e.printStackTrace();
		     }   
		  finally{
		            //Обязательно необходимо закрыть соединение
		            try {
		                 if(db != null)
		                 db.close();
		            } catch (SQLException e) {
		                 // TODO Auto-generated catch block
		                 e.printStackTrace();
		            }
		       }
		}
}
