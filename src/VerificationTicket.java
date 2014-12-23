import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.ScrollPane;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;


public class VerificationTicket {

	private JFrame frame;
	private JTable table;

	
	public VerificationTicket() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 948, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Кошик");
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(45, 27, 111, 44);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 102, 828, 103);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, "\u0421\u043A\u0430\u0441\u0443\u0432\u0430\u0442\u0438 \u0437\u0430\u043C\u043E\u0432\u043B\u0435\u043D\u043D\u044F"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u2116", "\u041C\u0456\u0441\u0446\u0435", "\u0426\u0456\u043D\u0430 (\u0433\u0440\u043D. )", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(430);
		table.getColumnModel().getColumn(2).setPreferredWidth(119);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("17,00 ГРН ОПЛАТИТИ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton.setBounds(573, 279, 263, 44);
		frame.getContentPane().add(btnNewButton);
	}
}
