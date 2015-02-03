import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProcessController {
    //parameters - our model-class object (DataBase) and all views
    private DataBase dataBase;
    private SearchTrain searchTrainView;
    private FoundRoutes foundRoutesView;
    private SeatSelection seatSelectionView;
    private VerificationTicket verificationTicketView;
    private UserData userDataView;

    public ProcessController(DataBase dataBase) {

        this.dataBase = dataBase;
        searchTrainView = new SearchTrain(this.dataBase.selectAllStations());
        foundRoutesView = new FoundRoutes();
        seatSelectionView = new SeatSelection(1);
        verificationTicketView = new VerificationTicket();
        UserData userDataView = new UserData();
        
        //adding listeners to react on first view's buttons. Initialized with object of specific class
        searchTrainView.addOneWayButtonListener(new OneWayButtonListener());
        searchTrainView.addReturnButtonListener(new ReturnButtonListener());
        searchTrainView.addSearchTrainListener(new SearchTrainerListener());
        
        foundRoutesView.addBackButtonListener(new FoundRoutesBackListener());
        foundRoutesView.addFoundRoutesListener(new FoundRoutesListener());
        seatSelectionView.addCanselSeatSelectionListener(new CanselSeatSelectionListener());
        seatSelectionView.addReserveSeatSelectionListener(new ResearveSeatListener());
        verificationTicketView.addVerificationTicketListener(new VerificationTicketListener());
        searchTrainView.setVisible(true);
    }

    //specific class for connecting first and second views
    class OneWayButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
                foundRoutesView.setTwoWayTicket(false);
            } catch (Exception e) {
                //do nothing
            }
		}
    }
    
    class ReturnButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
                foundRoutesView.setTwoWayTicket(true);
            } catch (Exception e) {
                //do nothing
            }
		}
    }
    
    class SearchTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                searchTrainView.setVisible(false);
                Map<String, String> there = 
                		dataBase.selectTrainFromTo(searchTrainView.sourseStation.getSelectedItem().toString(),
                        searchTrainView.destinationStation.getSelectedItem().toString(),
                        searchTrainView.oneWayDate.getSelectedItem().toString());
                Map<String, String> back = 
                		dataBase.selectTrainFromTo(searchTrainView.destinationStation.getSelectedItem().toString(),
                		searchTrainView.sourseStation.getSelectedItem().toString(),
                		searchTrainView.returnDate.getSelectedItem().toString());

                foundRoutesView.addRoute(there,back);
                foundRoutesView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }

    class FoundRoutesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                foundRoutesView.setVisible(false);
                seatSelectionView.setTrainNumber(foundRoutesView.thereTrainsButtonGroup.getSelection()
                		.getActionCommand());
                if(foundRoutesView.getTwoWayTicket()){
                	seatSelectionView.setTwoWayTicket(
                			foundRoutesView.backTrainsButtonGroup.getSelection().getActionCommand());
                }
                seatSelectionView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }
    
    class FoundRoutesBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                foundRoutesView.setVisible(false);
                searchTrainView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }
    
    class CanselSeatSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                seatSelectionView.setVisible(false);
                foundRoutesView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }

    class ResearveSeatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                seatSelectionView.setVisible(false);
                verificationTicketView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }

    class VerificationTicketListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                verificationTicketView.setVisible(false);
                //UserData userDataView = new UserData();
               //	userDataView.setVisible(true);

            } catch (Exception e) {
                //do nothing
            }
        }

    }
}
