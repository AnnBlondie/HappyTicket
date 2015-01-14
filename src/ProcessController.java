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
	
	public ProcessController(DataBase dataBase, SearchTrain searchTrainView, FoundRoutes foundRoutesView, 
			SeatSelection seatSelectionView, VerificationTicket verificationTicketView, UserData userDataView){
		
		this.dataBase=dataBase;
		this.searchTrainView=searchTrainView;
		this.foundRoutesView=foundRoutesView;
		this.seatSelectionView=seatSelectionView;
		this.verificationTicketView=verificationTicketView;
		this.userDataView=userDataView;
		
		//adding listener to react on first view's button. Initialized with object of specific class
		this.searchTrainView.addSearchTrainListener(new SearchTrainerListener());
		
		this.searchTrainView.setVisible(true);
	}
	
	//specific class for connecting first and second views
	class SearchTrainerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				searchTrainView.setVisible(false);
				//here result of train searching by DataBase's method selectTrainFromTo will 
				//fulfilled text fields in next view
				foundRoutesView.setVisible(true);
			}
			catch(Exception e){
				//do nothing
			}
		}
	}
}
