import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class FoundRoutes {

	JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;

	public FoundRoutes() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Знайдені Маршрути");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblNewLabel.setBounds(277, 16, 271, 43);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 120, 763, 188);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u2116 \u043F\u043E\u0457\u0437\u0434\u0430", "\u0417\u0432\u0456\u0434\u043A\u0438 / \u041A\u0443\u0434\u0438", "\u0414\u0430\u0442\u0430", "\u0412\u0456\u0434\u043F\u0440\u0430\u0432\u043B\u0435\u043D\u043D\u044F / \u041F\u0440\u0438\u0431\u0443\u0442\u0442\u044F", "\u0422\u0440\u0438\u0432\u0430\u043B\u0456\u0441\u0442\u044C", "\u0412\u0456\u043B\u044C\u043D\u0438\u0445 \u043C\u0456\u0441\u0446\u044C"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
		table.getColumnModel().getColumn(3).setPreferredWidth(209);
		table.getColumnModel().getColumn(4).setPreferredWidth(111);
		table.getColumnModel().getColumn(5).setPreferredWidth(137);
		scrollPane.setViewportView(table);
	}
}
