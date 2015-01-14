import java.awt.EventQueue;

public class Main {

		public static void main(String[] args){
			
			DataBase db = new DataBase("postgres", "12345", "jdbc:postgresql://localhost:5432/HappyTickets");
			//not sure all this initiations are necessary. Maybe will be better to initiate them in controller constructor
			SearchTrain searchTrainView = new SearchTrain();
			FoundRoutes foundRoutesView = new FoundRoutes();
			SeatSelection seatSelectionView = new SeatSelection();
			VerificationTicket verificationTicketView = new VerificationTicket();
			UserData userDataView = new UserData();
			
			ProcessController processController = new ProcessController(db, searchTrainView, foundRoutesView, 
					seatSelectionView, verificationTicketView, userDataView);
			
			//db.selectAllTrains();
			//db.selectTrainFromTo("Львів","Одеса");
			//db.selectTrainFromTo("Київ Пасажирський","Харків");

			db.closeDB();

	}
}
