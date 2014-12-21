import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class SeachTrain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeachTrain window = new SeachTrain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeachTrain() {
		initialize();
	}




	/**
	 * Initialize the contents of the frame.
	 */

	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 893, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Звідки");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 147, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Куди");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(46, 202, 51, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Київ", "Дарниця", "Миргород", "Полтава Київська", "Харків-Пас"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(96, 145, 231, 26);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Харків-Пас", "Полтава Київська", "Миргород", "Дарниця", "Київ"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(96, 200, 231, 26);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Пасажир");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(15, 268, 78, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Дорослий", "Студент", "Дитячий", "Пенсіонер"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_2.setBounds(96, 266, 231, 26);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_3.setBounds(349, 266, 51, 26);
		frame.getContentPane().add(comboBox_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Квиток в один кінець");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(24, 80, 226, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Туди і назад");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(257, 80, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Дата відправлення:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(457, 147, 165, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_4.setBounds(623, 145, 204, 26);
		frame.getContentPane().add(comboBox_4);
		
		JLabel label = new JLabel("Дата повернення:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(467, 202, 155, 20);
		frame.getContentPane().add(label);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"18/12/2014", "19/12/2014", "20/12/2014", "21/12/2014", "22/12/2014", "23/12/2014"}));
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_5.setBounds(623, 200, 204, 26);
		frame.getContentPane().add(comboBox_5);
		
		JButton btnNewButton = new JButton("Пошук поїздів");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Search for train. Please wait..");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(658, 265, 169, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("Пошук поїздів");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		label_1.setBounds(371, 16, 197, 52);
		frame.getContentPane().add(label_1);
	} 
}
