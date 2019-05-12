
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class TestBasicFile {
    public static void main(String[] args) throws IOException
    {
        boolean fileOpened = false;
        BasicFile f = new BasicFile();
        
        String selectionOptions = "1. Open File\n"
                                + "2. Copy File\n"
                                + "3. Append to a Text File\n"
                                + "4. Overwrite Text File\n"
                                + "5. Display Attributes\n"
                                + "6. Display Contents\n"
                                + "7. Search File for Text";     
        
        while(true)
        {
            String s = JOptionPane.showInputDialog(null,selectionOptions);           
            int i = Integer.parseInt(s);
            
            switch(i)
            {
                case 1:
                    f.openFile();
                    fileOpened = true;
                    break;
                case 2:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    f.copyFile();
                    break;
                case 3:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    f.appendFile();
                    break;
                case 4:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    f.copyFile();
                    break;
                case 5:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    display(f.fileAttributes(), "File Attributes");
                    break;
                case 6:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    display(f.getContents(), "File Contents");
                    break;
                case 7:
                    if (fileOpened == false)
                    {
                        fileNotOpenedMessage();
                        break;
                    }
                    String text = JOptionPane.showInputDialog(null,"Text to locate"); 
                    display(f.locateText(text), "Search Results");
                    break;
            }
        }
        
    }
    
    private static void display(String message, String title)
    {
        JTextArea text = new JTextArea(message,30,50);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void fileNotOpenedMessage()
    {
        JOptionPane.showMessageDialog(null, "A file needs to be opened in order to complete this operation", "File not found", JOptionPane.INFORMATION_MESSAGE);
    }    
}
