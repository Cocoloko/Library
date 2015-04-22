import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDialog;


import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
 
public class CreateAuthors extends JFrame {
 
    public CreateAuthors() {
         
        super("Select a genre");
 
        Font font = new Font("Verdana", Font.PLAIN, 18); 
 
        String dirname = "Genres/";
        String dirName = JOptionPane.showInputDialog("Enter the name of the author");
File f1 = new File(dirname);

String genresStrings[] = f1.list();

for(int i = 0; i < genresStrings.length; i++){

File dir = new File(dirname + "/" + genresStrings[i], dirName);
dir.mkdir();
dir.mkdirs();

 Container content = getContentPane();
 
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
         
        final JLabel label = new JLabel(" ");
        label.setAlignmentX(LEFT_ALIGNMENT);
        label.setFont(font);
        content.add(label);
 
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                        String item = (String)box.getSelectedItem();
                        
                        
                   javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
         
JFrame frame = new JFrame();


if(dir.exists()){
JOptionPane.showMessageDialog(frame, "Directory for the books of the author has been successfully created!", "That's right !", JOptionPane.PLAIN_MESSAGE);
}else{
JOptionPane.showMessageDialog(frame, "An attempt to create a directory for the books of the author had failed!", "Something wrong!", JOptionPane.ERROR_MESSAGE);
} 
}
});     
         
}
};
        
        JComboBox comboBox = new JComboBox(genresStrings);
        comboBox.setFont(font);
        comboBox.setAlignmentX(LEFT_ALIGNMENT);
        comboBox.addActionListener(actionListener);
        content.add(comboBox);
 
        setPreferredSize(new Dimension(250, 100));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
  
}      
}
}