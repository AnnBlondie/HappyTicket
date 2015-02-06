import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SeatSelection {

    private JFrame frame;
    private Train forwardTrain= new Train("");
    private Train backTrain=new Train("");
    private boolean twoWayTicket;
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

    public SeatSelection() {
        initialize();
    }

    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
    }
    
    public void setTrain(String forwardTrainNumber){
    	twoWayTicket=false;
    	forwardTrain=new Train(forwardTrainNumber);
    	initialize();
    }
    
    public void setTwoTrains(String forwardTrainNumber, String backTrainNumber){
    	twoWayTicket=true;
    	forwardTrain=new Train(forwardTrainNumber);
    	backTrain=new Train(backTrainNumber);
    	initialize();
    }
    
    public Train getForwardTrain(){
    	return forwardTrain;
    }
    
    public Train getBackTrain(){
    	return backTrain;
    }
    
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 950, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        frame.getContentPane().setLayout(null);

        JLabel seatSelectionLabel = new JLabel("Вибір місця");
        seatSelectionLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        seatSelectionLabel.setBounds(350, 16, 486, 52);
        frame.getContentPane().add(seatSelectionLabel);

        JLabel trainNumberLabel = new JLabel("Поїзд №" +forwardTrain.getTrainNumber());
        trainNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        trainNumberLabel.setBounds(40, 70, 133, 41);
        frame.getContentPane().add(trainNumberLabel);
        
        JLabel wagonLabel = new JLabel("Оберіть вагон");
        wagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        wagonLabel.setBounds(40, 100, 177, 50);
        frame.getContentPane().add(wagonLabel);

        wagonBox.setModel(new DefaultComboBoxModel<String>(new String[]{"К", "П", "Л", "С1", "С2"}));
        wagonBox.setBounds(200, 110, 40, 26);
        frame.getContentPane().add(wagonBox);
        
        JComboBox<String> wagonBox2 = new JComboBox<String>();
        wagonBox2.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        wagonBox2.setBounds(240, 110, 40, 26);
        frame.getContentPane().add(wagonBox2);

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
        
        JLabel backTrainNumberLabel = new JLabel("Поїзд №" +this.backTrain.getTrainNumber());
        backTrainNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        backTrainNumberLabel.setBounds(440, 70, 133, 41);
        backTrainNumberLabel.setVisible(twoWayTicket);
        frame.getContentPane().add(backTrainNumberLabel);
        
        JLabel backWagonLabel = new JLabel("Оберіть вагон");
        backWagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backWagonLabel.setBounds(440, 100, 177, 50);
        backWagonLabel.setVisible(twoWayTicket);
        frame.getContentPane().add(backWagonLabel);

        backWagonBox.setModel(new DefaultComboBoxModel<String>(new String[]{"К", "П", "Л", "С1", "С2"}));
        backWagonBox.setBounds(600, 110, 40, 26);
        backWagonBox.setVisible(twoWayTicket);
        frame.getContentPane().add(backWagonBox);
        
        JComboBox<String> backWagonBox2 = new JComboBox<String>();
        backWagonBox2.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        backWagonBox2.setBounds(640, 110, 40, 26);
        backWagonBox2.setVisible(twoWayTicket);
        frame.getContentPane().add(backWagonBox2);
        
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
