import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Here necessarily inherited from JFrame
public class BookReader {

  // Fields should be private
  private FileDialog fileDialog;
  private BookReaderCallback callback;

  // Nested callback interface
  public interface BookReaderCallback {
    // Method will be invoked when a text file is read successfully by the end of
    void onReadComplete(String text);
  }

// In the constructor pass the parent frame
// Instantiate it is not necessary in this class
  public BookReader(Frame parent) {
    fileDialog = new FileDialog(parent, "Select book", FileDialog.LOAD);
  }
  
  public void readBook() {

    // Show () deprecated so call "setVisible"
    fileDialog.setVisible(true);

    if (fileDialog.getDirectory() == null || fileDialog.getFile() == null) {
      return;
    }

    Scanner in = null;
    String text = "";
    try {
      in = new Scanner(new File(fileDialog.getDirectory(),
          fileDialog.getFile()));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (in.hasNext()) {
      text += in.nextLine() + "\n";
    }
    in.close();
    // Read the file, and now through the object class obratnogo call
    // notifitsiruem calling class about the text read and pass it the result
    if (callback != null) {
      callback.onReadComplete(text);
    }

  }

  public void setCallback(BookReaderCallback callback) {
    this.callback = callback;
  }
}