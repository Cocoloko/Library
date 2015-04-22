import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class CreateJFrame
{

public static void createGUI()
{

try {
      UIManager.setLookAndFeel((LookAndFeel) Class.forName(UIManager.getCrossPlatformLookAndFeelClassName()).newInstance());
    } catch (InstantiationException | IllegalAccessException| ClassNotFoundException | UnsupportedLookAndFeelException e) {

    }
    
    JPanel content = new JPanel(new FlowLayout());
    
//Create JFrame
JFrame frame = new JFrame("LIBRARY");
frame.setContentPane(content);
frame.pack();
    // Center the on the screen
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    JTextArea textArea = new JTextArea(50,50);
    content.add(textArea);
    textArea.setLineWrap(true);

    /*
    //Create JScrollPane
   JScrollPane sbrText = new JScrollPane(textArea);
   sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   */
    
//Create JFrame ActionListener
frame.addWindowListener(new WindowListener() 
{
public void windowActivated(WindowEvent event)
{
}
public void windowClosed(WindowEvent event)
{
}
public void windowClosing(WindowEvent event)
{
Object[] options = {"Yes", "No"};
int n = JOptionPane.showOptionDialog(event.getWindow(), "Close the window?",
"Confirmation", JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

if (n == 0){
event.getWindow().setVisible(false);
System.exit(0);
}
}
public void windowDeactivated(WindowEvent event)
{
}
public void windowDeiconified(WindowEvent event)
{
}
public void windowIconified(WindowEvent event) 
{
}
public void windowOpened(WindowEvent event) 
{
}
});


//Create Font
Font font = new Font("Verdana", Font.PLAIN, 11);
JMenuBar menuBar = new JMenuBar();

//Create File Menu
JMenu fileMenu = new JMenu("File");
fileMenu.setFont(font);

//Create Add Menu
JMenu addMenu = new JMenu("Add");
addMenu.setFont(font);
fileMenu.add(addMenu);

//Create ReadMenuItem
JMenuItem readMenuItem = new JMenuItem("Read");
readMenuItem.setFont(font);
fileMenu.add(readMenuItem);

//Create Add genres menuItem
JMenuItem addgMenuItem = new JMenuItem("Add genres");
addgMenuItem.setFont(font);
addMenu.add(addgMenuItem);

//Create Add author MenuItem
JMenuItem addaMenuItem = new JMenuItem("Add author");
addaMenuItem.setFont(font);
addMenu.add(addaMenuItem); 

//Create Add series menuItem
JMenuItem addsMenuItem = new JMenuItem("Add series");
addsMenuItem.setFont(font);
addMenu.add(addsMenuItem);

//Create Separator
addMenu.addSeparator();

//Create Add book MenuItem
JMenuItem addbMenuItem = new JMenuItem("Add book");
addbMenuItem.setFont(font);
addMenu.add(addbMenuItem);


//Create Exit Menu
JMenu exitMenu = new JMenu("Exit");
exitMenu.setFont(font);


//Create Exit MenuItem
JMenuItem exitMenuItem = new JMenuItem("Exit");
exitMenuItem.setFont(font);
exitMenu.add(exitMenuItem);

//exitMenuItem ActionListener
exitMenuItem.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
System.exit(0);

}
});

//addbMenuItem ActionListener
addbMenuItem.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
FileChooser fileChooser = new FileChooser();
fileChooser.fileCh();
}
});

//addgMenuItem ActionListener
addgMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
CreateGenres createGenres = new CreateGenres();
createGenres.createGenres();
}
});

//addaMenuItem ActionListener
addaMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
new CreateAuthors();
}
});

//addsMenuItem ActionListener
addsMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
DirectoryChooserS directoryChooserS = new DirectoryChooserS();
directoryChooserS.directoryChS();
}
});

//readMenuItem ActionListener
readMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
        // Create object BookReader
        BookReader bookReader = new BookReader(frame);
        // Method will be called from the class BookReader once a file is read
        bookReader.setCallback(new BookReader.BookReaderCallback() {

          // Method will be called from the class BookReader once a file is read
          public void onReadComplete(String text) {
            // Replace the text in the Label
            textArea.setText(text);
          }
        });
        // Start "reading room " :)
        bookReader.readBook();

      }
});

//Create refrenceMenu
JMenu referenceMenu = new JMenu("Reference");
referenceMenu.setFont(font);

//Create aboutMenuItem
JMenuItem aboutMenuItem = new JMenuItem("About");
aboutMenuItem.setFont(font);
referenceMenu.add(aboutMenuItem);

menuBar.add(fileMenu);
menuBar.add(referenceMenu);
menuBar.add(exitMenu);
    
frame.setJMenuBar(menuBar);

frame.setPreferredSize(new Dimension(800, 600));
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
JFrame.setDefaultLookAndFeelDecorated(true);

}
}
