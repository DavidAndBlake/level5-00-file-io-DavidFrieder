package _01_File_Recorder;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.

    public static void main(String[]args) throws IOException
    {
        FileWriter fw;
        try
        {
            System.out.println(new File("src/_01_File_Recorder/TestFile.txt").getAbsolutePath());
            fw = new FileWriter(("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/_01_File_Recorder/test.txt")); //program didn't recognize file name
            String messageFromUser = JOptionPane.showInputDialog("Type your message here.");
            fw.write(messageFromUser);
            fw.close();
        } catch (IOException e)
        {
            System.out.println("Program didn't recognize file name");
        }
    }

}
