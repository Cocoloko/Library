import javax.swing.JFrame;
import javax.swing.JDialog;

public class Window extends JFrame
{
public Window()
{
}

public static void main(String[] args)
{
//Method createGUI
CreateJFrame frame = new CreateJFrame();
frame.createGUI();

javax.swing.SwingUtilities.invokeLater(new Runnable()
{
public void run()
{
JFrame.setDefaultLookAndFeelDecorated(true);
JDialog.setDefaultLookAndFeelDecorated(true);
new Window();
}
});
}
}   