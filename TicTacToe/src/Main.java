//Summary: Tic Tac Toe program
//File   : TicTacToe Main.java
//Author : Gina Quinn
//Date   : 09-17-2017
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.initialize();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
