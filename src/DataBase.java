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

    //to fulfill combo box in first view
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
	
    //to create data for second view - UNDONE(need to show only free seats)
    public Map<Train, String> selectTrainFromTo(String stationFrom, String stationTo, String date) {
        Map<Train, String> result = new HashMap<Train, String>();
        try {
            Statement st = db.createStatement();
 			String s ="SELECT train.train_id,F.departure_time as D1,T.arrival_time as A2," +
 					" T.arrival_time-F.departure_time as TF" +
 					" FROM train, train_station F, train_station T" +
 					" WHERE train.train_id=F.train_id" +
 					" AND train.train_id=T.train_id" +
 					" AND F.station_id IN" +
 					" (SELECT station_id FROM station WHERE station_name='"+stationFrom+"')" +
 					" AND T.station_id IN" +
 					" (SELECT station_id FROM station WHERE station_name='"+stationTo+"')" +
 					" AND T.station_number>F.station_number;";
 			ResultSet rs = st.executeQuery(s); 
 			String timeInWay ="";
 			while(rs.next()){
				timeInWay=rs.getString("TF");
 				if(timeInWay.charAt(0)=='-'){//correction time in case midnight passing
 					timeInWay=timeInWay.replaceAll(timeInWay.substring(4,6), 
 							""+(60-Integer.parseInt(timeInWay.substring(4,6))));
 					timeInWay=timeInWay.replaceAll(timeInWay.substring(1,3),
 							""+(23-Integer.parseInt(timeInWay.substring(1,3))));
 					timeInWay=timeInWay.substring(1,timeInWay.length());
 				}
 				result.put(new Train(rs.getString("train_id")), String.format("%38s %15s %25s %15s %2s", 
                		stationFrom + "/" + stationTo, date, rs.getString("D1") + "/" + rs.getString("A2"), 
                		timeInWay ,""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        try {
        	for(Train t:result.keySet()){
	            Statement st = db.createStatement();
	 			String s ="SELECT wagon_type, SUM(seats_num) as SU" +
	 					" FROM wagon" +
	 					" WHERE wagon.train_id='"+t.getTrainNumber() +
	 					"' GROUP BY wagon_type;";
	 			ResultSet rs = st.executeQuery(s); 
	 			String wag =" ";
	 			while(rs.next()){
					wag=wag+rs.getString("wagon_type")+" "+rs.getString("SU")+" ";
	            }
	 			result.put(t, result.get(t)+wag);
	 		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //to create data for third view - UNDONE(need to show only wagons with free seats)
    public void AddTrainData(Train train){
    	//adding all train's wagons
    	try {
			Statement st = db.createStatement();
			String s="SELECT wagon_type, wagon_num FROM wagon  WHERE train_id='"+train.getTrainNumber()+"';";
			ResultSet rs = st.executeQuery(s);
			while(rs.next()){
				train.addWagon(rs.getString("wagon_type"), Integer.parseInt(rs.getString("wagon_num")));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
		//adding array of free seats to every wagon - UNDONE
    	try {
        	for(Train.Wagon w: train.getWagons()){
				Statement st = db.createStatement();
				String s="SELECT seats_num FROM wagon WHERE train_id='"+train.getTrainNumber()+
						"' AND wagon_num="+w.getNumber()+";";
				ResultSet rs = st.executeQuery(s);
				while(rs.next()){
					int[] seats = new int[Integer.parseInt(rs.getString("seats_num"))];
					w.setFreeSeats(seats);
				}
        	}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}   
    }

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