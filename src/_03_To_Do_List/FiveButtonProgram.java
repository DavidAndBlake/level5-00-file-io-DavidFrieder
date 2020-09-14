package _03_To_Do_List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FiveButtonProgram implements ActionListener
{

    private static Object BoxLayout;
    JFrame buttonFrame = new JFrame();
    JPanel buttonPanel = new JPanel();
    JButton taskButton = new JButton();
    JButton viewTasksButton = new JButton();
    JButton removeTasksButton = new JButton();
    JButton saveListButton = new JButton();
    JButton loadListButton = new JButton();
    ArrayList<String> taskList = new ArrayList<String>();
    FileWriter fw;
    BufferedReader br;


    public static void main(String[] args) throws IOException
    {
        new FiveButtonProgram().run();
    }
    void run () throws IOException
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenSizeX = screenSize.getWidth();
        double screenSizeY = screenSize.getHeight();

        taskButton.setText("Add new task");
        viewTasksButton.setText("See current tasks");
        removeTasksButton.setText("Remove a task");
        saveListButton.setText("Save List");
        loadListButton.setText("Load a list");
        buttonFrame.add(buttonPanel);
        buttonPanel.add(taskButton);
        buttonPanel.add(viewTasksButton);
        buttonPanel.add(removeTasksButton);
        buttonPanel.add(saveListButton);
        buttonPanel.add(loadListButton);
        buttonFrame.setVisible(true);
        buttonFrame.pack();
        taskButton.addActionListener((ActionListener) this);
        viewTasksButton.addActionListener((ActionListener) this);
        removeTasksButton.addActionListener((ActionListener) this);
        saveListButton.addActionListener((ActionListener) this);
        loadListButton.addActionListener((ActionListener) this);
        System.out.println(buttonFrame.getSize().width);
        buttonFrame.setLocation((int)(screenSizeX/2)-(buttonFrame.getSize().width/2),(int)(screenSizeY/2)-(buttonFrame.getSize().height*2));
        buttonFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    if (e.getSource()==taskButton){
        String newTask = JOptionPane.showInputDialog("What would you like to put in as a task?");
        taskList.add(newTask);
    }
        if (e.getSource()==viewTasksButton){
            JOptionPane.showMessageDialog(null, taskList.toArray());
        }
        if (e.getSource()==removeTasksButton){
           String removableItem = JOptionPane.showInputDialog(null,"Which task do you want to remove?");
           taskList.remove(removableItem);
        }
        if (e.getSource()==saveListButton){
            try
            {
                fw = new FileWriter("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/_03_To_Do_List/savedTasks.txt");
                String savedTask = "";
                for (int i = 0; i<taskList.size(); i++){
                    savedTask += taskList.get(i) + "\n";
                }
                fw.write(savedTask);
                fw.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource()==loadListButton){
            String filePath = JOptionPane.showInputDialog(null,"What's the path of the file you want to locate?");
            try
            {
                taskList.clear();
                br = new BufferedReader(new FileReader(filePath));
                String line = br.readLine();
//                taskList = line;
                int lineCounter = 0;
                while (line != null){
                    taskList.add(line);
                    lineCounter++;
                    System.out.println("the line # " + lineCounter + " = " + line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
