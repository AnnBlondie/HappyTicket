//import java.util.;
import java.awt.EventQueue;
import java.sql.*;
import org.postgresql.Driver;


public class Main {
		public static void main(String[] args){
			//0. e-mail and login input - allow administrator to insert train and trace 
			
			//1. first GUI - basic parameters search - from-to, date
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SeachTrain window = new SeachTrain();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//2. second GUI - results of search and possibility to peek train
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FoundRoutes window = new FoundRoutes();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//3. third GUI - wagon-seat proposition, price generation
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SeatSelection window = new SeatSelection();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			//4. fourth GUI - fulfilling passanger's personal data, creating reservation
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VerificationTicket window = new VerificationTicket();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});	
			
			
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
					System.out.print(rs.getString("type"));
					System.out.println();
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}   
			finally{//close connection  
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
