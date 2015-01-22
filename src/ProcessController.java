import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessController {
	//parameters - our model-class object (DataBase) and all views
	private DataBase dataBase;
	private SearchTrain searchTrainView;
	private FoundRoutes foundRoutesView;
	private SeatSelection seatSelectionView;
	private VerificationTicket verificationTicketView;
	private UserData userDataView;
	
	public ProcessController(DataBase dataBase){
		
		this.dataBase=dataBase;
		SearchTrain searchTrainView = new SearchTrain();
		FoundRoutes foundRoutesView = new FoundRoutes();
		SeatSelection seatSelectionView = new SeatSelection();
		VerificationTicket verificationTicketView = new VerificationTicket();
		this.searchTrainView=searchTrainView;
		this.foundRoutesView=foundRoutesView;
		this.seatSelectionView=seatSelectionView;
		this.verificationTicketView=verificationTicketView;
		
		//adding listener to react on first view's button. Initialized with object of specific class
		this.searchTrainView.addSearchTrainListener(new SearchTrainerListener());
		this.foundRoutesView.addFoundRoutesListener(new FoundRoutesListener());
		this.seatSelectionView.addCanselSeatSelectionListener(new CanselSeatSelectionListener());
		this.seatSelectionView.addReserveSeatSelectionListener(new ResearveSeatListener());
		this.verificationTicketView.addVerificationTicketListener(new VerificationTicketListener());
		this.searchTrainView.setVisible(true);
	}
	
	//specific class for connecting first and second views
	class SearchTrainerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				searchTrainView.setVisible(false);
				String[][] s = dataBase.selectTrainFromTo(searchTrainView.sourseStation.getSelectedItem().toString(),
						searchTrainView.destinationStation.getSelectedItem().toString());

				//here result of train searching by DataBase's method selectTrainFromTo are 
				//fulfilled text fields in next view
				foundRoutesView.addRoute(s);
				
				foundRoutesView.setVisible(true);
			}
			catch(Exception e){
				//do nothing
			}
		}
	}
	
	class FoundRoutesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				foundRoutesView.setVisible(false);
								
				seatSelectionView.setVisible(true);
			}
			catch(Exception e){
				//do nothing
			}
		}
	}

	class CanselSeatSelectionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{	
				seatSelectionView.setVisible(false);
				foundRoutesView.setVisible(true);
			}
			catch(Exception e){
				//do nothing
			}
		}
	}
	
	class ResearveSeatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{	
				seatSelectionView.setVisible(false);
				verificationTicketView.setVisible(true);
			}
			catch(Exception e){
				//do nothing
			}
		}
	}
	
	class VerificationTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{	
				verificationTicketView.setVisible(false);
				UserData userDataView = new UserData();
				//this.userDataView=userDataView;

			}
			catch(Exception e){
				//do nothing
			}
		}
		
	}
}
