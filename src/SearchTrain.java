import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SearchTrain extends JFrame {

    final JComboBox<String> sourseStation = new JComboBox<String>();
    final JComboBox<String> destinationStation = new JComboBox<String>();
    final JComboBox<String> passengerAge = new JComboBox<String>();
    final JComboBox<String> passengerNuber = new JComboBox<String>();
    
    //this should be redone
    JComboBox oneWayDate = new JComboBox();
    final JComboBox returnDate = new JComboBox();

    private JRadioButton oneWayButton = new JRadioButton("Квиток в один кінець");
    private JRadioButton returnButton = new JRadioButton("Туди і назад");

    private JButton searchTrainButton = new JButton("Пошук поїздів");

    public SearchTrain(String[] allStations) {
    	initialize(allStations);
    }
    
    private void initialize(String[] allStations){
        this.setBounds(100, 100, 950, 350);
        this.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel searchTrainFrameNameLabel = new JLabel("Пошук поїздів");
        searchTrainFrameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        searchTrainFrameNameLabel.setBounds(350, 16, 486, 52);
        this.getContentPane().add(searchTrainFrameNameLabel);

        JLabel fromLabel = new JLabel("Звідки");
        fromLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        fromLabel.setBounds(29, 148, 103, 20);
        this.getContentPane().add(fromLabel);

        sourseStation.setModel(new DefaultComboBoxModel<String>(allStations));
        sourseStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sourseStation.setBounds(139, 144, 231, 26);
        this.getContentPane().add(sourseStation);

        JLabel toLabel = new JLabel("Куди");
        toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        toLabel.setBounds(29, 203, 92, 20);
        this.getContentPane().add(toLabel);

        destinationStation.setModel(new DefaultComboBoxModel<String>(allStations));
        destinationStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        destinationStation.setBounds(139, 199, 231, 26);
        this.getContentPane().add(destinationStation);

        //what for?
        JLabel passengerLabel = new JLabel("Пасажир");
        passengerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerLabel.setBounds(29, 269, 109, 20);
        this.getContentPane().add(passengerLabel);
        
        //what for?
        passengerAge.setModel(new DefaultComboBoxModel<String>(new String[]{"Дорослий", "Студент", "Дитячий", "Пенсіонер"}));
        passengerAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerAge.setBounds(139, 265, 231, 26);
        this.getContentPane().add(passengerAge);

        //what for?
        passengerNuber.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        passengerAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerNuber.setBounds(403, 266, 51, 25);
        this.getContentPane().add(passengerNuber);

        oneWayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        oneWayButton.setSelected(true);
        oneWayButton.setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        oneWayButton.setBounds(100, 80, 319, 29);
        this.getContentPane().add(oneWayButton);

        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        returnButton.setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        returnButton.setOpaque(true);
        returnButton.setBounds(600, 80, 231, 29);
        this.getContentPane().add(returnButton);

        ButtonGroup oneWayReturnButtonGroup = new ButtonGroup();
        oneWayReturnButtonGroup.add(oneWayButton);
        oneWayReturnButtonGroup.add(returnButton);

        JLabel departureDateLabel = new JLabel("Дата відправлення:");
        departureDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        departureDateLabel.setBounds(457, 148, 257, 20);
        this.getContentPane().add(departureDateLabel);

        oneWayDate.setModel(new DefaultComboBoxModel(new String[]{"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
        oneWayDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        oneWayDate.setBounds(650, 144, 231, 26);
        this.getContentPane().add(oneWayDate);
        
        final JLabel arrivalDateLabel = new JLabel("Дата повернення:");
        arrivalDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        arrivalDateLabel.setBounds(457, 203, 247, 25);
        arrivalDateLabel.setVisible(false);
        this.getContentPane().add(arrivalDateLabel);
  
        returnDate.setModel(new DefaultComboBoxModel(new String[]{"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
        returnDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        returnDate.setBounds(650, 199, 231, 26);
        returnDate.setVisible(false);
        this.getContentPane().add(returnDate);
        
        oneWayButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	arrivalDateLabel.setVisible(false);
	        	returnDate.setVisible(false);
			}        	
        });

        returnButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	arrivalDateLabel.setVisible(true);
	        	returnDate.setVisible(true);
			}
        });
        
        searchTrainButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchTrainButton.setBounds(650, 270, 270, 30);
        this.getContentPane().add(searchTrainButton);
   
    }

    void addOneWayButtonListener(ActionListener listenForOneWayButton){
    	oneWayButton.addActionListener(listenForOneWayButton);
    }
    
    void addReturnButtonListener(ActionListener listenForReturnButton){
    	returnButton.addActionListener(listenForReturnButton);
    }

    void addSearchListener(ActionListener listenForSearchTrainButton) {
        searchTrainButton.addActionListener(listenForSearchTrainButton);
    }

    public boolean returnButtonPressed(){
    	return returnButton.isSelected();
    }
    
    public boolean oneWayButtonPressed(){
    	return oneWayButton.isSelected();
    }
}