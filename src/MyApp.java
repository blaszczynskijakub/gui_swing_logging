
import javax.swing.SwingUtilities;


public class MyApp implements Runnable {
    public void run() {
        new GUI();



    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new MyApp());
    }
}