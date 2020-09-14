package _02_File_Encrypt_Decrypt;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor
{
    /*
     * Encryption is the process of encoding a message or information
     * in such a way that only authorized parties can access it and
     * those who are not authorized cannot.
     *
     * A simple shift cipher works by shifting the letters of a message
     * down based on a key. If our key is 4 then:
     *
     * a b c d e f g h i j k l m n o p q r s t u v w x y z
     *
     * becomes:
     *
     * e f g h i j k l m n o p q r s t u v w x y z a b c d
     *
     * "Hello World" changes to "Lipps Asvph"
     *
     * Create a program that takes a message and a key from the user.
     * Use the key to shift each letter in the users input and save the final result to a file.
     */

    //	Create a program that takes the string "Hello World" and shifts it forward in the ASCII code by 4 spaces %26
//	Write the results to a file
    public static void main(String[] args)
	{
		String fileMessage = new String("Patty cake patty cake, baker's man.");
		String encryptedString = new String("");
		for (int i = 0; i < fileMessage.length(); i++)
		{
			//type two if statements that create a range of letters for the ascii values to go through, then
			// have the values - 26 if the value goes out of bounds.
			char forwardShiftingLetter = fileMessage.charAt(i);
			if (forwardShiftingLetter == ' ')
			{
//				i++;
			}
			if (forwardShiftingLetter >= 'a' && forwardShiftingLetter <= 'z' || forwardShiftingLetter >= 'A' && forwardShiftingLetter <= 'Z')
			{
				forwardShiftingLetter += 4;
			}
			if (forwardShiftingLetter > 'z' && forwardShiftingLetter > 'a' || forwardShiftingLetter < 'a' && forwardShiftingLetter > 'Z')
			{
				forwardShiftingLetter -= 26;
				System.out.println("Going back 26");
			}
			System.out.println("forwardShiftingLetter = " + forwardShiftingLetter);
			encryptedString += forwardShiftingLetter;
		}
		System.out.println(encryptedString);
		try
		{
			FileWriter fw = new FileWriter("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/_02_File_Encrypt_Decrypt/EncryptedMessage");
		fw.write(encryptedString);
		fw.close();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Sorry, the file writer didn't work");
		}


    }
}
