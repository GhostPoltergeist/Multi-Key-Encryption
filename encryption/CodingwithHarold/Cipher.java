package encryption.CodingwithHarold;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
@SuppressWarnings("ALL")
public class Cipher implements Runnable {

    String name;
    int shift;
    String ciphertext = "";

    public void run() {
        pauseIt();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nName: ");
        name = scanner.nextLine();
        System.out.print("\n[x]Recommended [2] or [5]\n");
        System.out.print("ShiftValue: ");
        shift = scanner.nextInt();
        char alphabet;
        for(int i=0; i < name.length(); i++)
        {
            alphabet = name.charAt(i);

            if(alphabet >= 'a' && alphabet <= 'z')
            {
                alphabet = (char) (alphabet + shift);
                if(alphabet > 'z') {
                    alphabet = (char) (alphabet+'a'-'z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }

            else if(alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet + shift);

                if(alphabet > 'Z') {
                    alphabet = (char) (alphabet+'A'-'Z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }
            else {
                ciphertext = ciphertext + alphabet;
            }

        }
        System.out.println("CipherText: " + ciphertext);
        System.out.println("SHIFT: " + shift);
        pauseIt();
        writeitDown();
        pauseIt();
    }
    private static void pauseIt() {
        try {
            Thread.sleep(3500);
        }catch (InterruptedException IE) {System.out.println(IE);}
    }
    public void writeitDown() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//ZXZ/Desktop/CipherEncryption.txt"));
            writer.write("@GhostPoltergeist (c) - 2022 | CodingwithHarold");
            writer.write("\n");
            writer.write("\n");
            writer.write("Log File");
            writer.write("\n");
            writer.write("DataInserted: " + name);
            writer.write("\n");
            writer.write("CipherText: " + ciphertext);
            writer.write("\n");
            writer.write("Shift: " + shift);
            writer.write("\n");
            writer.close();
        }catch (IOException io) {io.printStackTrace();}
    }
}