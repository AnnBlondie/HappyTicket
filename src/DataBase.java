import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import org.postgresql.Driver;

public class DataBase {

	private Connection db = null;

    public DataBase(String username, String password, String url) {
        try {
            db = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public String[] selectAllStations(){
		ArrayList<String> resultList= new ArrayList<String>();
		try {
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT station_name  FROM station");
			while(rs.next()){
				resultList.add(rs.getString("station_name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
		String[] result = new String[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
    //to create data for second view - need addition(to show free seats number for every train)
    public Map<String, String> selectTrainFromTo(String stationFrom, String stationTo) {
        Map<String, String> result = new HashMap<String, String>();
        try {
            Statement st = db.createStatement();
            String s = "SELECT train.train_id, F.arrival_time as A1,F.departure_time as D1,T.arrival_time as A2,T.departure_time as D2  " +
                    "FROM train, train_station F, train_station T " +
                    "WHERE train.train_id=F.train_id " +
                    "AND train.train_id=T.train_id " +
                    "AND F.station_id IN  " +
                    "(SELECT station_id FROM station WHERE station_name='" + stationFrom + "') " +
                    "AND T.station_id IN " +
                    "(SELECT station_id FROM station WHERE station_name='" + stationTo + "');";
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
               result.put(rs.getString("train_id"), String.format("%6s %35s %25s %15s %10s %10s", 
                		rs.getString("train_id"), stationFrom + "/" + stationTo,"",
                		rs.getString("D1") + "/" + rs.getString("A2"),"",""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //to create data for third view - no need

    //to create data for forth view - select free seat for exact train

    //to create data for fifth view - no need

    //final fulfilling user data - insert in dataBase in Customer and Reservation, closing connection

    public void closeDB() {
        try {
            if (db != null)
                db.close();
        } catch (SQLException e) {// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
