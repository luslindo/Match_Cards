package memMatch;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Practical Test ");
        //add the panel
        //frame.add(new CheckerBoard());
        //frame.add(new Dice());
        frame.add(new Table());
        frame.setVisible(true);
    }
}
