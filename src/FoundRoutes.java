import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class FoundRoutes {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton foundRoutesButton = new JButton("Далі");

	public FoundRoutes() {
		initialize();
	}
	
	public void setVisible(boolean b){//to show frame without making it public
		frame.setVisible(b);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Знайдені Маршрути");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblNewLabel.setBounds(277, 16, 471, 43);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 120, 763, 188);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[10][6],
			new String[] {"№ поїзда", "Звідки / Куди", "Дата", "Відправлення / Прибуття", "Тривалість", "Вільних місць"}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(209);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		scrollPane.setViewportView(table);
		
		foundRoutesButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		foundRoutesButton.setBounds(510, 330, 220, 29);
		frame.getContentPane().add(foundRoutesButton);
	}
	
	public void addRoute(String s[][]){
		int i=0;
		while(i<s.length){
			table.setValueAt(s[i][0], i, 0);
			table.setValueAt(s[i][1], i, 1);
			table.setValueAt(s[i][2], i, 2);
			table.setValueAt(s[i][3], i, 3);
			table.setValueAt(s[i][4], i, 4);
			table.setValueAt(s[i][5], i, 5);
			i++;
		}
	}
	
	void addFoundRoutesListener(ActionListener listenForFoundRoutesButton){
		foundRoutesButton.addActionListener(listenForFoundRoutesButton);
	}
}
