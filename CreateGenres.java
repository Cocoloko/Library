import javax.swing.*;
import java.io.*;

public class CreateGenres{

public CreateGenres(){}

public static void createGenres(){

javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
         
JFrame frame = new JFrame();

String dirName = JOptionPane.showInputDialog("Enter a name for the genre");

File dir = new File("Genres/", dirName);
dir.mkdir();
dir.mkdirs();
if(dir.exists()){
JOptionPane.showMessageDialog(frame, "Directory genre was successfully created !", "That's right !", JOptionPane.PLAIN_MESSAGE);
}else{
JOptionPane.showMessageDialog(frame, "An attempt to create a genre directory failed!", "Something wrong!", JOptionPane.ERROR_MESSAGE);
} 
  }
        });
    }
}