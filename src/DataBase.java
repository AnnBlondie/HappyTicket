import java.sql.*;
import org.postgresql.Driver;
import java.awt.EventQueue;

public class DataBase {

	private String userName;
	private String password;
	private String url;
	private Connection db = null;

	
	public DataBase(String username, String password, String url){
		setUserName(username);
		setPassword(password);
		setUrl(url);
		try {
			db = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void selectAllTrains(){
		try {
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
	}
	
	public void selectTrainFromTo(String stationFrom, String stationTo){
		try {
			Statement st = db.createStatement();
			String s = "SELECT train.train_id, F.arrival_time as A1,F.departure_time as D1,T.arrival_time as A2,T.departure_time as D2  "+
					"FROM train, train_station F, train_station T "+
					"WHERE train.train_id=F.train_id "+
					"AND train.train_id=T.train_id "+
					"AND F.station_id IN  "+
					"(SELECT station_id FROM station WHERE station_name='"+stationFrom+"') "+
					"AND T.station_id IN "+
					"(SELECT station_id FROM station WHERE station_name='"+stationTo+"');";
			ResultSet rs = st.executeQuery(s);
			while(rs.next()){
				System.out.print("Потяг номер ");
				System.out.println(rs.getString("train_id")+":\n на станцїї "+stationFrom+" "+rs.getString("A1")+
						" "+rs.getString("D1")+";\n на станцїї "+stationTo+" "+rs.getString("A2")+
						" "+rs.getString("D2")+" ");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	
	public void closeDB(){
		try {
			if(db != null)
			db.close();
		} 
		catch (SQLException e) {// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
