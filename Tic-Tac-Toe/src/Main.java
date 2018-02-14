//Summary: This basic program displays a window with interactive buttons.
//File   : p1GinaQ Main.java
//Author : Gina Quinn
//Date   : 09-06-2017


import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        //This creates a new JFrame window and sets the window specifications
        MyWindow window = new MyWindow();   //creating dynamic memory for this class. Address stored in pointer "window".
        window.initialize();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //require for EVERY GUI programming
        window.setVisible(true);            //rendering: displaying on the screen
      
    }
}
