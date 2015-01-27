import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTrain {

    private JFrame frame;
    final JComboBox<String> sourseStation = new JComboBox<String>();
    final JComboBox<String> destinationStation = new JComboBox<String>();
    final JComboBox<String> passengerAge = new JComboBox<String>();
    final JComboBox<String> passengerNuber = new JComboBox<String>();
    JRadioButton oneWayButton = new JRadioButton("Квиток в один кінець");
    JRadioButton returnButton = new JRadioButton("Туди і назад");

    private JButton searchTrainButton = new JButton("Пошук поїздів");

    public SearchTrain(String[] allStations) {
        frame = new JFrame();
        frame.setBounds(100, 100, 950, 350);
        frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel searchTrainFrameNameLabel = new JLabel("Пошук поїздів");
        searchTrainFrameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        searchTrainFrameNameLabel.setBounds(350, 16, 486, 52);
        frame.getContentPane().add(searchTrainFrameNameLabel);

        JLabel fromLabel = new JLabel("Звідки");
        fromLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        fromLabel.setBounds(29, 148, 103, 20);
        frame.getContentPane().add(fromLabel);

        sourseStation.setModel(new DefaultComboBoxModel<String>(allStations));
        sourseStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        sourseStation.setBounds(139, 144, 231, 26);
        frame.getContentPane().add(sourseStation);

        JLabel toLabel = new JLabel("Куди");
        toLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        toLabel.setBounds(29, 203, 92, 20);
        frame.getContentPane().add(toLabel);

        destinationStation.setModel(new DefaultComboBoxModel<String>(allStations));
        destinationStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        destinationStation.setBounds(139, 199, 231, 26);
        frame.getContentPane().add(destinationStation);

        JLabel passengerLabel = new JLabel("Пасажир");
        passengerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerLabel.setBounds(29, 269, 109, 20);
        frame.getContentPane().add(passengerLabel);

        passengerAge.setModel(new DefaultComboBoxModel<String>(new String[]{"Дорослий", "Студент", "Дитячий", "Пенсіонер"}));
        passengerAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerAge.setBounds(139, 265, 231, 25);
        frame.getContentPane().add(passengerAge);

        passengerNuber.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        passengerAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passengerNuber.setBounds(403, 266, 51, 25);
        frame.getContentPane().add(passengerNuber);

        oneWayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        oneWayButton.setSelected(true);
        oneWayButton.setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        oneWayButton.setBounds(24, 80, 319, 29);
        frame.getContentPane().add(oneWayButton);

        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        returnButton.setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        returnButton.setOpaque(true);
        returnButton.setBounds(368, 80, 231, 29);
        frame.getContentPane().add(returnButton);

        ButtonGroup oneWayReturnButtonGroup = new ButtonGroup();
        oneWayReturnButtonGroup.add(oneWayButton);
        oneWayReturnButtonGroup.add(returnButton);

        JLabel departureDateLabel = new JLabel("Дата відправлення:");
        departureDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        departureDateLabel.setBounds(457, 140, 257, 20);
        frame.getContentPane().add(departureDateLabel);

        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setModel(new DefaultComboBoxModel(new String[]{"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
        comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox_4.setBounds(650, 140, 270, 25);
        frame.getContentPane().add(comboBox_4);
        
        final JLabel arrivalDateLabel = new JLabel("Дата повернення:");
        arrivalDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        arrivalDateLabel.setBounds(457, 202, 247, 25);
        arrivalDateLabel.setVisible(false);
        frame.getContentPane().add(arrivalDateLabel);
  
        final JComboBox comboBox_5 = new JComboBox();
        comboBox_5.setModel(new DefaultComboBoxModel(new String[]{"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
        comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox_5.setBounds(650, 199, 270, 20);
        comboBox_5.setVisible(false);
        frame.getContentPane().add(comboBox_5);
        
        oneWayButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	arrivalDateLabel.setVisible(false);
	        	comboBox_5.setVisible(false);
			}        	
        });

        returnButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
	        	arrivalDateLabel.setVisible(true);
	        	comboBox_5.setVisible(true);
			}
        });
        
        searchTrainButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchTrainButton.setBounds(650, 270, 270, 30);
        frame.getContentPane().add(searchTrainButton);
   
    }

    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
    }

    void addOneWayButtonListener(ActionListener listenForOneWayButton){
    	oneWayButton.addActionListener(listenForOneWayButton);
    }
    
    void addReturnButtonListener(ActionListener listenForReturnButton){
    	returnButton.addActionListener(listenForReturnButton);
    }

    void addSearchTrainListener(ActionListener listenForSearchTrainButton) {
        searchTrainButton.addActionListener(listenForSearchTrainButton);
    }

}
