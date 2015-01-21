import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;


public class SeatSelection {

	private JFrame frame;
	private final JLabel label = new JLabel("Поїзд");
	JComboBox<String> wagonBox = new JComboBox<String>();
	JComboBox<String> seatBox = new JComboBox<String>();
	JTextArea surname = new JTextArea();
	JTextArea name = new JTextArea();
	JButton reserveButton = new JButton("Зарезервувати");
	JButton canselButton = new JButton("Відмінити");

	public SeatSelection() {
		initialize();
	}

	public void setVisible(boolean b){//to show frame without making it public
		frame.setVisible(b);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 705, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(195, 59, 133, 41);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(333, 59, 99, 36);
		frame.getContentPane().add(textArea);
		
		JLabel wagonLabel = new JLabel("Оберіть вагон");
		wagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		wagonLabel.setBounds(40, 137, 177, 50);
		frame.getContentPane().add(wagonLabel);
		
		wagonBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		wagonBox.setBounds(240, 150, 102, 26);
		frame.getContentPane().add(wagonBox);
		
		JLabel seatLabel = new JLabel("Місце");
		seatLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		seatLabel.setBounds(411, 137, 126, 50);
		frame.getContentPane().add(seatLabel);
		
		seatBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
		seatBox.setBounds(552, 150, 87, 26);
		frame.getContentPane().add(seatBox);
		
		JLabel surnameLabel = new JLabel("Прізвище");
		surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		surnameLabel.setBounds(66, 209, 140, 50);
		frame.getContentPane().add(surnameLabel);
		
		surname.setBounds(209, 225, 133, 22);
		frame.getContentPane().add(surname);
		
		JLabel nameLabel = new JLabel("Ім'я");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLabel.setBounds(421, 209, 68, 50);
		frame.getContentPane().add(nameLabel);
		
		name.setBounds(524, 225, 115, 22);
		frame.getContentPane().add(name);
		
		JLabel priceLabel = new JLabel("Ціна: 17,00 грн");
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		priceLabel.setBounds(110, 275, 286, 50);
		frame.getContentPane().add(priceLabel);
		
		reserveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		reserveButton.setBounds(53, 370, 256, 41);
		frame.getContentPane().add(reserveButton);
		
		canselButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		canselButton.setBounds(378, 370, 261, 41);
		frame.getContentPane().add(canselButton);
	}
	
	void addReserveSeatSelectionListener(ActionListener listenForResearveSeatButton){
		reserveButton.addActionListener(listenForResearveSeatButton);
	}
	
	void addCanselSeatSelectionListener(ActionListener listenCanselSeatSelectionButton){
		canselButton.addActionListener(listenCanselSeatSelectionButton);
	}
}

