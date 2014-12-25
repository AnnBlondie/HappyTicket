import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserData {

	private JFrame frame;

	public UserData() {
		initialize();
	}

	public void setVisible(boolean b){//to show frame without making it public
		frame.setVisible(b);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0412\u0432\u0435\u0434\u0456\u0442\u044C \u0412\u0430\u0448\u0456 \u0414\u0430\u043D\u0456");
		label.setFont(new Font("Tahoma", Font.BOLD, 27));
		label.setBounds(123, 16, 324, 50);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 95, 62, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(142, 107, 228, 26);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("\u041E\u043F\u043B\u0430\u0442\u0438\u0442\u0438");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(174, 181, 157, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
