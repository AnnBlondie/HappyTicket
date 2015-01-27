import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;


public class FoundRoutes {

    private JFrame frame;
    private JScrollPane scrollPane;
    private boolean twoWayTicket=false;
    private JScrollPane backScrollPane;
    private JButton foundRoutesButton = new JButton("Далі");
    ButtonGroup thereTrainsButtonGroup = new ButtonGroup();
    ButtonGroup backTrainsButtonGroup = new ButtonGroup();

    public FoundRoutes() {
        frame = new JFrame();
        frame.setBounds(100, 100, 950, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        frame.getContentPane().setLayout(null);

        JLabel foundRoutsFrameNameLabel = new JLabel("Знайдені Маршрути");
        foundRoutsFrameNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
        foundRoutsFrameNameLabel.setBounds(277, 16, 471, 43);
        frame.getContentPane().add(foundRoutsFrameNameLabel);

        String s=String.format("%6s  %40s  %20s  %25s  %13s  %13s", 
        		"№ ","Звідки / Куди   ","Дата","Відправлення / Прибуття","Тривалість","Вільних місць");
        JLabel columsName = new JLabel(s);
        columsName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        columsName.setBounds(30, 70, 900, 20);
        frame.add(columsName);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane);
        backScrollPane = new JScrollPane();
        frame.getContentPane().add(backScrollPane);

        scrollPane.setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        scrollPane.setOpaque(true);

        foundRoutesButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        foundRoutesButton.setBounds(650, 270, 270, 30);
        frame.getContentPane().add(foundRoutesButton);
    }

    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
    }

    public void setTwoWayTicket(Boolean b){
    	twoWayTicket=b;
    }
  
    public void addRoute(Map<String, String> there, Map<String, String> back) {
    	addPaneContain(there, scrollPane, thereTrainsButtonGroup);
    	addPaneContain(back, backScrollPane, backTrainsButtonGroup);
        scrollPane.setBounds(30, 90, 900, 30*there.size());
        backScrollPane.setBounds(30, 100+30*there.size(), 900, 30*back.size());
        backScrollPane.setVisible(twoWayTicket);
    }

    private void addPaneContain(Map<String, String> map, JScrollPane pane, ButtonGroup buttonGroup){
    	int i = 0;
        for (String key: map.keySet()) {
            JLabel train = new JLabel(map.get(key));
            train.setFont(new Font("Tahoma", Font.PLAIN, 15));
            train.setBounds(0, 30*i, 700, 30);
            train.setVisible(true);
            JRadioButton rb = new JRadioButton("");
            rb.setSelected(false);
            rb.setVisible(true);
            rb.setOpaque(true);
            rb.setBounds(870, 10+30*i, 17, 15);
            buttonGroup.add(rb);
            pane.add(rb);
            pane.add(train, i);
            i++;
        }
    }
    
    void addFoundRoutesListener(ActionListener listenForFoundRoutesButton) {
        foundRoutesButton.addActionListener(listenForFoundRoutesButton);
    }
}
