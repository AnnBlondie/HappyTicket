import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class VerificationTicket {

	private JFrame frame;
	private JTable table;
	final JButton verificationTicketButton = new JButton("17,00 ГРН ОПЛАТИТИ");
	
	public VerificationTicket() {
		initialize();
	}
	
	public void setVisible(boolean b){ //to show frame without making it public
		frame.setVisible(b);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
		frame.getContentPane().setLayout(null);
		
		JLabel verificationTicketLabel = new JLabel("Кошик");
		verificationTicketLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		verificationTicketLabel.setBounds(350, 16, 486, 52);
		frame.getContentPane().add(verificationTicketLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 900, 100);
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
				"№", "Місце", "Ціна (грн. )", ""
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
		
		verificationTicketButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		verificationTicketButton.setBounds(650, 270, 270, 30);
		frame.getContentPane().add(verificationTicketButton);
	}
	
	void addVerificationTicketListener(ActionListener listenVerificationTicketButton){
		verificationTicketButton.addActionListener(listenVerificationTicketButton);
	}
}
