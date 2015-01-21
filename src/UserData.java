import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;



/**
 * Created by aandreyeva on 1/15/2015.
 */

public class UserData extends JFrame {

    private JPanel thePanel = new JPanel();
    private JLabel label1 = new JLabel ("Бронювання створене"); //Reservation #?
    private JLabel label2 = new JLabel("Час виїзду | Маршрут | Місце | Вартість");
    private JTextField textField1 = new JTextField(42);//Think how to input reservation details into this field
    private Icon d = new ImageIcon(getClass().getResource("D.png"));
    private JButton button1 = new JButton("Скасувати бронювання", d);
    private JLabel label3 = new JLabel("Email");
    private JTextField textField2 = new JTextField(21);
    private Icon s = new ImageIcon(getClass().getResource("S.png"));
    private JButton button2 = new JButton("Відправити деталі бронювання", s);

    //Constructor
    UserData(){

        this.setSize(650, 450);//window size
        Toolkit tk = Toolkit.getDefaultToolkit();//creating Toolkit object
        Dimension dim = tk.getScreenSize();
        int xPOS = (dim.width / 2) - (this.getWidth() / 2);
        int yPOS = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPOS, yPOS);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Щасливий Квиток: Завершення бронювання квитка");
        thePanel.setBackground(Color.cyan);
        thePanel.add(label1);
        thePanel.add(label2);
        thePanel.add(textField1);
        button1.setToolTipText("Натискання на цю кнопку видалить деталі бронювання");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 1;
        thePanel.add(button1, c);
        label3.setToolTipText("Введіть валідну адресу, щоб відправити деталі бронювання по електронній пошті");
        thePanel.add(label3);
        thePanel.add(textField2);
        c.gridx = 0;
        c.gridy = 2;
        thePanel.add(button2, c);
        this.add(thePanel);
        this.setVisible(true);
        textField1.requestFocus();
    }

    //Methods
    void addDeleteListener(ActionListener listenForDeleteButton){
        button1.addActionListener(listenForDeleteButton);
    }

    public int getEmail(){
        return Integer.parseInt(textField2.getText());

    }

    void addSendListener(ActionListener listenForSendButton){
        button2.addActionListener(listenForSendButton);
    }

    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }

}


