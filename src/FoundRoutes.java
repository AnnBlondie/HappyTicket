import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;


public class FoundRoutes {

    private JFrame frame;
    private JScrollPane scrollPane;
    private boolean twoWayTicket;
    private JScrollPane backScrollPane;
    private JButton foundRoutesButton = new JButton("Далі");
    ButtonGroup thereTrainsButtonGroup = new ButtonGroup();
    ButtonGroup backTrainsButtonGroup = new ButtonGroup();
    JButton backButton = new JButton("Повернутися");


    public FoundRoutes() {
    	initialize();
    }
    
    public void setVisible(boolean b) {//to show frame without making it public
        frame.setVisible(b);
    }

    public void initialize(){
        frame = new JFrame();
        frame.setBounds(100, 100, 950, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.getHSBColor(0.5f, 0.2f, 0.8f));
        frame.getContentPane().setLayout(null);

        JLabel foundRoutsFrameNameLabel = new JLabel("Знайдені Маршрути");
        foundRoutsFrameNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
        foundRoutsFrameNameLabel.setBounds(277, 16, 471, 43);
        frame.getContentPane().add(foundRoutsFrameNameLabel);

        String s=String.format("%6s  %40s  %20s  %30s  %13s  %13s", 
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

        backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backButton.setBounds(40, 270, 270, 30);
        frame.getContentPane().add(backButton);

        foundRoutesButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        foundRoutesButton.setBounds(650, 270, 270, 30);
        frame.getContentPane().add(foundRoutesButton);
    }

    public void setTwoWayTicket(Boolean b){
    	twoWayTicket=b;
    }
    
    public boolean getTwoWayTicket(){
    	return twoWayTicket;
    }
  
    //set panes of there and back routes 
    public void addRoute(Map<Train, String> there, Map<Train, String> back) {
    	addPaneContain(there, scrollPane, thereTrainsButtonGroup);
    	addPaneContain(back, backScrollPane, backTrainsButtonGroup);
        scrollPane.setBounds(30, 90, 900, Math.min(30*there.size(),80));
        backScrollPane.setBounds(30, 100+Math.min(30*there.size(),80), 900, Math.min(30*back.size(),80));
        backScrollPane.setVisible(twoWayTicket);
    }

    //fulfilling pane
    private void addPaneContain(Map<Train, String> map, JScrollPane pane, ButtonGroup buttonGroup){
    	int i = 0;
        for (Train key: map.keySet()) {
            JLabel train = new JLabel(map.get(key));
            train.setFont(new Font("Tahoma", Font.PLAIN, 15));
            train.setBounds(30, 30*i, 880, 30);
            JRadioButton rb = new JRadioButton(key.getTrainNumber());
            rb.setActionCommand(key.getTrainNumber());
            rb.setSelected(false);
            rb.setVisible(true);
            rb.setFont(new Font("Tahoma", Font.PLAIN, 15));
            rb.setOpaque(true);
            rb.setBounds(10, 5+30*i, 70, 18);
            buttonGroup.add(rb);
            pane.add(rb);
            pane.add(train, i);
            i++;
        }
    }
    
    void addBackButtonListener(ActionListener listenFoundRoutesBackButton) {
    	backButton.addActionListener(listenFoundRoutesBackButton);
    }
    
    void addFoundRoutesListener(ActionListener listenForFoundRoutesButton) {
        foundRoutesButton.addActionListener(listenForFoundRoutesButton);
    }
}