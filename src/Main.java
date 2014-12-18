//import java.util.;
import java.sql.*;
import org.postgresql.Driver;


public class Main {
		public static void main(String[] args){
		Customer customer1 = new Customer("customer@email");
	    Date date = new Date(919111111);
	
		Reservation reservation = new Reservation(customer1, 721, date, 1, "Ivanov");
		String s = reservation.toString();
		System.out.println(s);	
				
		//database connection
		String username = "postgres";
		String password = "12345";
		String url = "jdbc:postgresql://localhost:5432/HappyTickets"; 
				  
		Connection db = null;
		try {
			db = DriverManager.getConnection(url, username, password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("select * from train");
			while(rs.next()){
				System.out.print(rs.getString("train_id"));
				System.out.print(" ");
				System.out.print(rs.getString("train_num"));
				System.out.print(" ");
				System.out.print(rs.getString("type"));
				System.out.println();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
		finally{//Обязательно необходимо закрыть соединение
			try {
				if(db != null)
					db.close();
			} 
			catch (SQLException e) {// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
