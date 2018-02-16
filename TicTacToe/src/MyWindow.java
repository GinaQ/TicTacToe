import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyWindow extends JFrame {
    
    JTextField myDisplay = new JTextField();
    private JButton[] b;
   
    public void initialize() {
        setSize(500, 500);
        setLocation(200, 100);
        setTitle("Tic-Tac-Toe");
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        contentPane.add(panel, "Center");
        Font myFont = new Font("Courier New", Font.BOLD, 18);
        myDisplay.setEditable(false);
        myDisplay.setFont(myFont);
        myDisplay.setText("Play Tic-Tac-Toe: O's Turn!");
        contentPane.add(myDisplay, "North");
        
        ButtonListener listener = new ButtonListener();
        //Initialize the button array
        b = new JButton[9];
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
            b[i].setName("" + i);
            b[i].addActionListener(listener);
            panel.add(b[i]);
        }
    }
    
    class ButtonListener implements ActionListener {
        private int count;                      // counter for number of button presses
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            Object source = e.getSource();
            JButton button = (JButton) source;  // type casting source to button
            processButtonPress(button, count);  // send button pressed and count to processing method
        }
    }
    
    // Receives button pressed and counter
    public void processButtonPress(JButton button, int count) {
        boolean solved = false;                 // game not solved yet
        
        // change the button properties
        button.setBackground(Color.white);
        button.setEnabled(false);
        Font myFont = new Font("Courier New", Font.BOLD, 56);
        button.setFont(myFont);
        
        // create a string array to receive values from the getValue method
        String[] values;
        
        //  process X's turn
        if (count%2 == 0 ){
            button.setText("X");
            values = getValues(b);
            if (count > 5) solved = judgeMove(values);
            if (solved == true) {
                myDisplay.setText("X Won!!!");
                disableButtons(b);
            }
            else myDisplay.setText("O's Turn!");
        }
        // process O's turn
        else {
            button.setText("O");
            values = getValues(b);
            if (count > 4) solved = judgeMove(values);
            if (solved == true) {
                myDisplay.setText("O Won!!!");
                disableButtons(b);
            }
            else myDisplay.setText("X's Turn!");
        }
        // if all buttons are pressed and no winner, then it is a tie game
        if (count == 9 && solved == false){
            myDisplay.setText("Tie Game");
        }
    }
    
    // Creates a string array to hold the text values of each button in the button array
    // Receives button array
    public String[] getValues(JButton[] b){
        String[] v = new String[9];
        
        for (int i = 0; i < 9; i++) {
            if (b[i].getText().equals("O") || b[i].getText().equals("X"))
                v[i] = b[i].getText();
            else v[i] = "Invalid";
        }
        return v;
    }
    
    // Evaluates table after move to decide if there is a winner
    // Receives string array of the button text values
    public boolean judgeMove(String[] t) {
        if ((t[0].equals(t[1]) && t[1].equals(t[2]) && !t[0].equals("Invalid")) ||
                (t[3].equals(t[4]) && t[4].equals(t[5]) && !t[3].equals("Invalid")) ||
                (t[6].equals(t[7]) && t[7].equals(t[8]) && !t[6].equals("Invalid")) ||
                (t[0].equals(t[3]) && t[3].equals(t[6]) && !t[0].equals("Invalid")) ||
                (t[1].equals(t[4]) && t[4].equals(t[7]) && !t[1].equals("Invalid")) ||
                (t[2].equals(t[5]) && t[5].equals(t[8]) && !t[2].equals("Invalid")) ||
                (t[0].equals(t[4]) && t[4].equals(t[8]) && !t[0].equals("Invalid")) || 
                (t[2].equals(t[4]) && t[4].equals(t[6]) && !t[2].equals("Invalid"))) {
            return true;
        }
        return false;
    }
    
    // If a winner is declared, the remaining buttons are disabled. 
    public void disableButtons(JButton[] b) {
        for (int i = 0; i < 9; i++) {
            b[i].setEnabled(false);
        }
    }
}
