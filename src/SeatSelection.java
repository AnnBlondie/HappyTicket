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
	private final JLabel label = new JLabel("\u041F\u043E\u0457\u0437\u0434");

	public SeatSelection() {
		initialize();
	}

	public void setVisible(boolean b){//to show frame without making it public
		frame.setVisible(b);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(247, 59, 81, 41);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(333, 59, 99, 36);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("\u041E\u0431\u0435\u0440\u0456\u0442\u044C \u0432\u0430\u0433\u043E\u043D");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 137, 121, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(164, 150, 145, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u041C\u0456\u0441\u0446\u0435");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(378, 137, 54, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(433, 150, 115, 26);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u041F\u0440\u0456\u0437\u0432\u0438\u0449\u0435");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(80, 209, 81, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(164, 225, 150, 22);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u0406\u043C'\u044F");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(388, 209, 37, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(433, 225, 115, 22);
		frame.getContentPane().add(textArea_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u0426\u0456\u043D\u0430: 17,00 \u0413\u0420\u041D");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(110, 275, 177, 50);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u0417\u0430\u0440\u0435\u0437\u0435\u0440\u0432\u0443\u0432\u0430\u0442\u0438");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Search for train. Please wait..");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(115, 370, 194, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0412\u0456\u0434\u043C\u0456\u043D\u0438\u0442\u0438");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(378, 370, 170, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
}
