package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator
{
    public static void main(String[] args)
    {
        /*
         * The following is an example of how to list all of the files in a directory.
         * Once the program is running, the directory is chosen using the JFileChooser.
         */
        File directory = new File("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/_04_Directory_Iteration");
        File[] files = directory.listFiles();
        if (files != null)
        {
            for (File f : files)
            {
                System.out.println(f.getAbsolutePath());//FrileWriter fw = new FileWriter(f, true);
                if (f.getAbsolutePath().contains(".java"))
                {
                    try (FileWriter fw = new FileWriter(f, true))
                    {
                        fw.write("//Copyright © 2020 David Frieder");
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /*
     * Your task is to write a program that iterates through the src folder of this current Java Project.
     * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
     * Be aware of possible directories inside of directories.
     * (e.g //Copyright © 2019 FirstName LastName)
     */
    //LOOK AT INTRO TO FILE IO FOR EXAMPLE, UNDER SECTION LABELED WRITE TO A FILE
    //Need to figure out how to reference each file one at a time. Write a for loop, create an int that checks the number of total files.

}

//Copyright © 2020 David Frieder//Copyright © 2020 David Frieder