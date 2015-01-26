import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SeatSelection {

    private JFrame frame;
    JComboBox<String> wagonBox = new JComboBox<String>();
    JComboBox<String> seatBox = new JComboBox<String>();
    JTextArea surname = new JTextArea();
    JTextArea name = new JTextArea();
    JButton reserveButton = new JButton("Зарезервувати");
    JButton canselButton = new JButton("Відмінити");

    public SeatSelection() {
        initialize();
    }

    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
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

        JLabel label = new JLabel("Поїзд");
        label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label.setBounds(40, 70, 133, 41);
        frame.getContentPane().add(label);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(100, 70, 99, 36);
        frame.getContentPane().add(textArea);

        JLabel wagonLabel = new JLabel("Оберіть вагон");
        wagonLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        wagonLabel.setBounds(40, 130, 177, 50);
        frame.getContentPane().add(wagonLabel);

        wagonBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        wagonBox.setBounds(200, 140, 102, 26);
        frame.getContentPane().add(wagonBox);

        JLabel seatLabel = new JLabel("Оберіть місце");
        seatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        seatLabel.setBounds(400, 130, 126, 50);
        frame.getContentPane().add(seatLabel);

        seatBox.setModel(new DefaultComboBoxModel<String>(new String[]{"1", "2", "3", "4", "5"}));
        seatBox.setBounds(550, 140, 87, 26);
        frame.getContentPane().add(seatBox);

        JLabel surnameLabel = new JLabel("Прізвище");
        surnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        surnameLabel.setBounds(40, 190, 240, 50);
        frame.getContentPane().add(surnameLabel);

        surname.setBounds(200, 200, 150, 26);
        frame.getContentPane().add(surname);

        JLabel nameLabel = new JLabel("Ім'я");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setBounds(400, 190, 68, 50);
        frame.getContentPane().add(nameLabel);

        name.setBounds(550, 200, 115, 26);
        frame.getContentPane().add(name);

        JLabel priceLabel = new JLabel("Ціна: 17,00 грн");
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

