import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*;
import java.util.Scanner;
 
public class NotePadeDD extends JFrame{
    private JEditorPane textArea = new JEditorPane();
    JTextPane jTextPanel = new JTextPane();
    JTextArea theText = new JTextArea();
    JPanel contentPanel;
    BorderLayout borderLayout = new BorderLayout();
    JMenu jMenuFile = new JMenu();
    JMenuBar jMenuBar = new JMenuBar();
    JLabel statusBar = new JLabel();
    JMenu File = new JMenu();
    JMenuItem open = new JMenuItem();
    JMenuItem save = new JMenuItem();
    JMenuItem exit = new JMenuItem();
 
    JMenu View= new JMenu();
    JMenuItem bold = new JMenuItem();
    JMenuItem italic = new JMenuItem();
 
    JMenu Copytext= new JMenu();
    JMenuItem copy = new JMenuItem();
    JMenuItem past = new JMenuItem();
    JMenuItem cut = new JMenuItem();
 
        JMenu Textoption= new JMenu();
    JMenuItem textj= new JMenuItem();
    JMenuItem texti= new JMenuItem();
    JMenuItem textp= new JMenuItem();
 
    JMenu Help= new JMenu();
    JMenuItem popi = new JMenuItem();
 
 
    public NotePadeDD() throws Exception {
        this.setSize (500,500);
        this.setTitle("Блокнот");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.textArea.setFont(new Font("", Font.PLAIN, 14));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
 
        jMenuBar.add(File);
        jMenuBar.add(Copytext);
        jMenuBar.add(Textoption);
        jMenuBar.add(Help);
        setJMenuBar(jMenuBar);
 
 
                File.setText("Фаил");
        open.setText("Открыть");
        File.add(open);
        save.setText("Сохранить");
        File.add(save);
        exit.setText("Выход");
        File.add(exit);
 
        exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
           {
                JOptionPane.showMessageDialog(exit, "Всего хорошего");
                System.exit(0);
               
 
            }
        });
   save.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser save = new JFileChooser();
		int option = save.showSaveDialog(save);
		if (option == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
				out.write(textArea.getText());
				out.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
                }
        }
      }
    });
 
 
    open.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
         JFileChooser open = new JFileChooser();
                        int option = open.showOpenDialog(open);
                        if (option == JFileChooser.APPROVE_OPTION) {
                                theText.setText("");
                                try {
                                        Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                                        while (scan.hasNext())
                                                textArea.setText(scan.nextLine() + "\n");
                                } catch (Exception ex) {
                                        System.out.println(ex.getMessage());
                                }
                        }
      }
    });
 
                
                Copytext.setText("Копирование");
        copy.setText("Копировать");
        Copytext.add(copy);
        past.setText("Вставить");
        Copytext.add(past);
        cut.setText("Вырезать");
        Copytext.add(cut);
                copy.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });
        past.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });
        cut.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });
 
 
                 Textoption.setText("Изменение шрифта");
        textj.setText("Жирный");
        Textoption.add(textj);
        texti.setText("Курсивный");
        Textoption.add(texti);
        textp.setText("Стандартный");
        Textoption.add(textp);
        texti.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae) {
                textArea.setFont(new Font ("TAHOMA", Font.ITALIC, 14));
            }
        });
        textj.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent ae) {
               textArea.setFont(new Font ("", Font.BOLD, 14));
            }
        });
        textp.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent ae) {
               textArea.setFont(new Font ("", Font.PLAIN, 14));
            }
        });
 
 
                Help.setText("Помощь");
        popi.setText("Подсказка");
        Help.add(popi);
        popi.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(exit, "Было сделано специально для сдачи лабараторной работы. Всем удачи. для сайта <A href='/go.php?uri=http://www.javatalks.ru");
            }
        });
    }
 
    public static void main (String args[]) throws Exception{
        NotePadeDD app = new NotePadeDD();
        app.setVisible(true);
           }
}