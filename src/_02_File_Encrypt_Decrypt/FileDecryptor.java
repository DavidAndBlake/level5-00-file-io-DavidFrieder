package _02_File_Encrypt_Decrypt;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor
{
    /*
     * Decryption is the process of taking encoded or encrypted text or other data
     * and converting it back into text that you or the computer can read and understand.
     *
     * The shift cipher is decrypted by using using the key and shifting back up,
     * at the end of our encryption example we had our alphabet as:
     *
     *
     * e f g h i j k l m n o p q r s t u v w x y z a b c d
     *
     * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
     *
     * a b c d e f g h i j k l m n o p q r s t u v w x y z
     *
     * "Lipps Asvph" returns to "Hello World"
     *
     * Create a program that opens the file created by FileEncryptor and decrypts
     * the message, then display it to the user in a JOptionPane.
     */
//	Finish FileEncryptor first
//	Open the file
//	use the ASCII char table to shift the characters
    public static void main(String[] args)
    {
    	String decryptedMessage = new String();
    	try
		{
			FileReader fr = new FileReader("/Users/davidfrieder/Desktop/level5-00-file-io-DavidFrieder/src/_02_File_Encrypt_Decrypt/EncryptedMessage");
			int c = fr.read();
			while (c != -1){
				if (c == ' ')
				{
				}
				if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
				{
					c -= 4;
				}
				if (c > 'z' && c > 'a' || c < 'a' && c > 'Z')
				{
					c += 26;
					System.out.println("Going forward 26");
				}
				System.out.println((char)c);
				decryptedMessage += (char)c;
				c = fr.read();
			}
			fr.close();
			JOptionPane.showMessageDialog(null,"The decrypted message is " + decryptedMessage);
		}
    	catch (IOException e)
		{
			System.out.println("Couldn't read the file");
		}

//    	String decryptingMessage =
//    	for (int i = 0; i < fr.)
//    	char decryptingLetter

    }

}
