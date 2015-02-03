import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SeatSelection {

    private JFrame frame;
    private String trainNumber;
    private String backTrainNumber;
    private boolean twoWayTicket = false;
    JComboBox<String> wagonBox = new JComboBox<String>();
    JComboBox<String> seatBox = new JComboBox<String>();
    JTextArea surname = new JTextArea();
    JTextArea name = new JTextArea();
    

    JComboBox<String> backWagonBox = new JComboBox<String>();
    JComboBox<String> backSeatBox = new JComboBox<String>();
    JTextArea backSurname = new JTextArea();
    JTextArea backName = new JTextArea();
    JButton reserveButton = new JButton("Зарезервувати");
    JButton canselButton = new JButton("Відмінити");
    JLabel trainNumberLabel = new JLabel();
    JLabel backTrainNumberLabel = new JLabel();



    public SeatSelection(int i) {
        initialize();
    }

    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
    }
    
    public void setTrainNumber(String trainNumber){
    	this.trainNumber=trainNumber;
    	trainNumberLabel.setText("Поїзд №" +this.trainNumber);
    }
    
    public void setTwoWayTicket(String backTrainNumber){
    	twoWayTicket=true;
    	this.backTrainNumber=backTrainNumber;
    	backTrainNumberLabel.setText("Поїзд №" +this.backTrainNumber);
    	initialize();
    }
    
    public String getTrainNumber(){
    	return trainNumber;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 950, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        frame.getContentPane().setLayout(null);

        JLabel seatSelectionLabel = new JLabel("Вибір місця");
        seatSelectionLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        seatSelectionLabel.setBounds(350, 16, 486, 52);
        frame.getContentPane().add(seatSelectionLabel);

        trainNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        trainNumberLabel.setBounds(40, 70, 133, 41);
        frame.getContentPane().add(trainNumberLabel);
        
        JLabel wagonLabel = new JLabel("Оберіть вагон");
        wagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        wagonLabel.setBounds(40, 100, 177, 50);
        frame.getContentPane().add(wagonLabel);

        wagonBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        wagonBox.setBounds(200, 110, 87, 26);
        frame.getContentPane().add(wagonBox);

        JLabel seatLabel = new JLabel("Оберіть місце");
        seatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        seatLabel.setBounds(40, 130, 126, 50);
        frame.getContentPane().add(seatLabel);

        seatBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        seatBox.setBounds(200, 140, 87, 26);
        frame.getContentPane().add(seatBox);

        JLabel surnameLabel = new JLabel("Прізвище");
        surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        surnameLabel.setBounds(40, 160, 240, 50);
        frame.getContentPane().add(surnameLabel);

        surname.setBounds(200, 170, 150, 26);
        frame.getContentPane().add(surname);

        JLabel nameLabel = new JLabel("Ім'я");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setBounds(40, 190, 68, 50);
        frame.getContentPane().add(nameLabel);

        name.setBounds(200, 200,  150, 26);
        frame.getContentPane().add(name);
        
        //right part - data for return ticket 
        
        backTrainNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        backTrainNumberLabel.setBounds(440, 70, 133, 41);
        backTrainNumberLabel.setVisible(twoWayTicket);
        frame.getContentPane().add(backTrainNumberLabel);
        
        JLabel backWagonLabel = new JLabel("Оберіть вагон");
        backWagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backWagonLabel.setBounds(440, 100, 177, 50);
        backWagonLabel.setVisible(twoWayTicket);
        frame.getContentPane().add(backWagonLabel);

        backWagonBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        backWagonBox.setBounds(600, 110, 87, 26);
        backWagonBox.setVisible(twoWayTicket);
        frame.getContentPane().add(backWagonBox);

        JLabel backSeatLabel = new JLabel("Оберіть місце");
        backSeatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backSeatLabel.setBounds(440, 130, 126, 50);
        backSeatLabel.setVisible(twoWayTicket);
        frame.getContentPane().add(backSeatLabel);

        backSeatBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        backSeatBox.setBounds(600, 140, 87, 26);
        backSeatBox.setVisible(twoWayTicket);
        frame.getContentPane().add(backSeatBox);

        //price and control buttons

        JLabel priceLabel = new JLabel("Ціна: "+17*(1+((twoWayTicket) ? 1 : 0))+",00 грн");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        priceLabel.setBounds(750, 190, 286, 50);
        frame.getContentPane().add(priceLabel);

        canselButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        canselButton.setBounds(40, 270, 270, 30);
        frame.getContentPane().add(canselButton);

        reserveButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        reserveButton.setBounds(650, 270, 270, 30);
        frame.getContentPane().add(reserveButton);

    }

    void addReserveSeatSelectionListener(ActionListener listenForResearveSeatButton) {
        reserveButton.addActionListener(listenForResearveSeatButton);
    }

    void addCanselSeatSelectionListener(ActionListener listenCanselSeatSelectionButton) {
        canselButton.addActionListener(listenCanselSeatSelectionButton);
    }
}

