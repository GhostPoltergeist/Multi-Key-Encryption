package encryption.CodingwithHarold;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("\nMulti Encryption\n");
        System.out.println("\n[x]IntegerTypes | PlainTexts[x]\n");
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.print("EncryptData: ");
        long data = scanner.nextLong();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 1; i++) {
            Runnable encryption = new Encryption(data);
            executor.execute(encryption);

            Runnable cipherText = new Cipher();
            executor.execute(cipherText);
        }
        executor.shutdown();
         while(!executor.isTerminated()){}

        System.out.println("\nExit");
     }catch (InputMismatchException ime) {System.out.println("\nThe Program can Only handle (19) Characters");}
    }
    private static void pauseIt() {
        try {
            Thread.sleep(1500);
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}