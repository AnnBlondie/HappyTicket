import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProcessController {
    //parameters - our model-class object (DataBase) and all views
    private DataBase dataBase;
    private SearchTrain searchTrainView;
    private FoundRoutes foundRoutesView;
    private SeatSelection seatSelectionView;
    private UserData userDataView;

    public ProcessController(DataBase dataBase) {

        this.dataBase = dataBase;
        //initializing first view with list of stations from our database
        searchTrainView = new SearchTrain(this.dataBase.selectAllStations());
        foundRoutesView = new FoundRoutes();
        seatSelectionView = new SeatSelection();
        UserData userDataView = new UserData();
        
        //adding listener to react on first view's button
        searchTrainView.addSearchTrainListener(new SearchTrainerListener());
        
        //adding listeners to react on second view's buttons
        foundRoutesView.addBackButtonListener(new FoundRoutesBackListener());
        foundRoutesView.addFoundRoutesListener(new FoundRoutesListener());
        
        //adding listeners to react on third view's buttons
        seatSelectionView.addCanselSeatSelectionListener(new CanselSeatSelectionListener());
        seatSelectionView.addReserveSeatSelectionListener(new ResearveSeatListener());
        
        //show first view
        searchTrainView.setVisible(true);
    }

    //creating second view by first view's data - UNDONE (need to add time and free seat count)
    class SearchTrainerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                searchTrainView.setVisible(false);
                foundRoutesView.setTwoWayTicket(searchTrainView.returnButton.isSelected());
                Map<String, String> there = 
                		dataBase.selectTrainFromTo(searchTrainView.sourseStation.getSelectedItem().toString(),
                        searchTrainView.destinationStation.getSelectedItem().toString(),
                        searchTrainView.oneWayDate.getSelectedItem().toString());
                Map<String, String> back = 
                		dataBase.selectTrainFromTo(searchTrainView.destinationStation.getSelectedItem().toString(),
                		searchTrainView.sourseStation.getSelectedItem().toString(),
                		searchTrainView.returnDate.getSelectedItem().toString());
                foundRoutesView.initialize();
                foundRoutesView.addRoute(there,back);
                foundRoutesView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }
 
    //return back from second view to first
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
  
    //creating third view by second view's data - UNDONE (need to add in some way wagon type and selections)
    class FoundRoutesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                foundRoutesView.setVisible(false);
                
                if(foundRoutesView.getTwoWayTicket()){
                	seatSelectionView.setTwoWayTicket(
                			foundRoutesView.thereTrainsButtonGroup.getSelection().getActionCommand(),
                			foundRoutesView.backTrainsButtonGroup.getSelection().getActionCommand());
                }
                else{
                    seatSelectionView.setTrainNumber(foundRoutesView.thereTrainsButtonGroup.getSelection()
                    		.getActionCommand());
                }
                seatSelectionView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }

    //return back from third view to second
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

    //creating fourth view by third view's data - UNDONE
    class ResearveSeatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                seatSelectionView.setVisible(false);
               	userDataView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }
    
    //return back from forth view to third - UNDONE
    class CanselResearveSeatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
               	userDataView.setVisible(false);
            	seatSelectionView.setVisible(true);
            } catch (Exception e) {
                //do nothing
            }
        }
    }
    
}
