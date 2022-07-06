package encryption.CodingwithHarold;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("ALL")
public class Encryption implements Runnable {
    private long firstData;
    private String whiteSpace;
    int anotherData, anotherData1;
    String binaryData, hexData, octalData;
    Integer hash;

    Encryption(long firstData) {
        this.firstData = firstData;
    }

    @Override
    public void run() {
        binaryData = Integer.toBinaryString((int) firstData);
        hexData = Integer.toHexString((int) firstData);
        octalData = Integer.toOctalString((int) firstData);
        hash = (int) firstData;
        anotherData1 = Integer.lowestOneBit((int) firstData);
        anotherData = Integer.highestOneBit((int) firstData);


        Thread.currentThread().setName("Initialization");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Binary" + Thread.currentThread().getName() + "Binary(Data) = " + binaryData);
        System.out.println("Hex" + Thread.currentThread().getName() + "Hex(Data) = " + hexData);
        System.out.println("Octal" + Thread.currentThread().getName() + "Octal(Data) = " + octalData);
        pauseIt();
        System.out.println("HashCode" + Thread.currentThread().getName() + "HashCode(Data) = " + hash.hashCode());
        System.out.println("LowestOneBit" + Thread.currentThread().getName() + "LowestOneBit(Data) = " + anotherData1);
        System.out.println("HighestOneBit" + Thread.currentThread().getName() + "HighestOneBit(Data) = " + anotherData);
        pauseIt();
        writeitDown();
    }
    private static void pauseIt() {
        try {
            Thread.sleep(1500);
        }catch (InterruptedException IE) {System.out.println(IE);}
    }
    public void writeitDown() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//ZXZ/Desktop/Identification.txt"));
            writer.write("@GhostPoltergeist (c) - 2022 | CodingwithHarold");
            writer.write("\n");
            writer.write("\n");
            writer.write("Log File");
            writer.write("\n");
            writer.write("DataInserted: " + firstData);
            writer.write("\n");
            writer.write("\n");
            writer.write("itsBinary: " + binaryData);
            writer.write("\n");
            writer.write("itsHex: " + hexData);
            writer.write("\n");
            writer.write("itsOctal: " + octalData);
            writer.write("\n");
            writer.write("HashCode: " + hash);
            writer.write("\n");
            writer.write("LowestOneBit: " + anotherData1);
            writer.write("\n");
            writer.write("HighestOneBit: " + anotherData);
            writer.write("\n");
            writer.close();
        }catch (IOException io) {io.printStackTrace();}
     }
}
