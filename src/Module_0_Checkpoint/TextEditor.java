package Module_0_Checkpoint;

import _05_Serialization.SaveData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor implements ActionListener
{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton saveButton = new JButton();
    private JButton loadButton = new JButton();
    JTextArea textArea = new JTextArea(30,50);
    static double screenWidth;
    static double screenHeight;
    FileWriter fw = new FileWriter("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/Module_0_Checkpoint/TextFile.txt");
    FileReader fr = new FileReader("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/Module_0_Checkpoint/TextFile.txt");


    public static void main(String[] args) throws IOException
    {
        new TextEditor();
    }

    TextEditor() throws IOException
    {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        textArea.setLineWrap(true);
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setLocation((int) (screenWidth / 4.0), (int) (screenHeight / 4));
        frame.add(panel);
        panel.add(buttonPanel);
        panel.add(textArea);
        panel.setSize(frameWidth * 2/3, frameHeight);
        panel.setBackground(Color.white);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.setSize(frameWidth * 1/3, frameHeight);
        buttonPanel.setBackground(Color.gray);
        saveButton.setText("Save");
        loadButton.setText("Load");
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       if (e.getSource()== saveButton){
           try
           {
               fw.write(textArea.getText());
           } catch (IOException ex)
           {
               ex.printStackTrace();
           }
       }
       if (e.getSource()== loadButton){
           int c 
            textArea.setText(fr);
       }
    }
}
//  1.  Create a new Java class called TextEditor
//
//  2.  Create a user interface using the picure as a guide. You will need
//        a JFrame, JPanel, JButtons, and a JTextArea. Think of a JTextArea as
//        a multi-line JTextField. You can set the size of the JTextArea when creating
//        the object by passing the demensions in as parameters.
//
//        3. When the Save button is clicked, save the text in the JTextArea to a file. You can
//        prompt the user for the name of the file.
//
//        4. When the Load button is clicked, prompt the user for a file to load (JOptionPane or JFileChooser).
//        Load the text of the file and display it in the JTextArea.