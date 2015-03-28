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

        searchTrainView = new SearchTrain(this.dataBase.selectAllStations());
        foundRoutesView = new FoundRoutes();
        seatSelectionView = new SeatSelection();
        userDataView = new UserData();
        
        searchTrainView.addSearchListener(new SearchTrainListener());
        
        foundRoutesView.addBackButtonListener(new FoundRoutesBackListener());
        foundRoutesView.addFoundRoutesListener(new FoundRoutesListener());
        
        seatSelectionView.addCanselSeatSelectionListener(new CanselSeatSelectionListener());
        seatSelectionView.addReserveSeatSelectionListener(new ResearveSeatListener());
        
        userDataView.addDeleteListener(new CanselResearveSeatListener());
        userDataView.addSendListener(new ResearveSeatListener());
        
        searchTrainView.setVisible(true);
    }

    class SearchTrainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                searchTrainView.setVisible(false);
                foundRoutesView.initialize();

                foundRoutesView.setTwoWayTicket(searchTrainView.returnButtonPressed());
                Map<Train, String> there = 
                		dataBase.selectTrainFromTo(searchTrainView.sourseStation.getSelectedItem().toString(),
                        searchTrainView.destinationStation.getSelectedItem().toString(),
                        searchTrainView.oneWayDate.getSelectedItem().toString());
                Map<Train, String> back = 
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
                seatSelectionView.initialize();
                if(foundRoutesView.getTwoWayTicket()){
                	seatSelectionView.setTwoTrains(
                			foundRoutesView.thereTrainsButtonGroup.getSelection().getActionCommand(),
                			foundRoutesView.backTrainsButtonGroup.getSelection().getActionCommand());
                    dataBase.AddTrainData(seatSelectionView.getForwardTrain());

                }
                else{
                    seatSelectionView.setTrain(foundRoutesView.thereTrainsButtonGroup.getSelection()
                    		.getActionCommand());
                    dataBase.AddTrainData(seatSelectionView.getForwardTrain());
                }
                seatSelectionView.setVisible(true);
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