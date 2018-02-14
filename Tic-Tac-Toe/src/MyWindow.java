//File   : p1GinaQ MyWindow.java
//Author : Gina Quinn
//Date   : 09-06-2017

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyWindow extends JFrame {
    private JTextField display; 
    JButton firstNameButton;
    JButton lastNameButton;
    JButton myComputerButton;
    
    public void initialize() {
        setSize(700,500);
        setTitle("p1 Gina Quinn");
        setLocation(200,100);
        Container contentPane = getContentPane();   //content pane is the layout manager ->border layout is default
        display = new JTextField();
        display.setText("Hello World");
        contentPane.add("North", display);
        
        firstNameButton = new JButton("First");
        lastNameButton = new JButton("Last");
        myComputerButton = new JButton("My Computer");

        JPanel southPanel = new JPanel();     //this is a container for graphic components
        southPanel.add(firstNameButton);
        southPanel.add(lastNameButton);
        southPanel.add(myComputerButton);
        
        contentPane.add("South", southPanel);
        
        ButtonListener buttonListener = new ButtonListener();
        firstNameButton.addActionListener(buttonListener);
        //southButton2.addActionListener(buttonListener);  //or make new action
        lastNameButton.addActionListener(buttonListener);
        //any object from any class that implements action listener may be added to the contentPane
        myComputerButton.addActionListener(buttonListener);
        
        
    }
    
    class ButtonListener implements ActionListener {    
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource(); //returns a reference of the button
            if (source == firstNameButton) {
                display.setText("My first name is Gina");    
            } else if (source == lastNameButton){
                display.setText("My last name is Quinn");
            } else if (source == myComputerButton) {
                display.setText("My computer is Lenovo Yoga 720 with Windows 10 OS");
            }
        }
    }
}
