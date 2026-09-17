import java.io.*;

public class Example6File {
    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("logs\\data.dat"));

        dos.writeInt(10);
        dos.writeDouble(100.345);
        dos.writeChar('t');

        DataInputStream dis = new DataInputStream(new FileInputStream("logs\\data.dat"));

        int i = dis.readInt();
        double d = dis.readDouble();
        char c = dis.readChar();

        System.out.println("int value: "+ i);
        System.out.println("double value: "+ d);
        System.out.println("character value: "+ c);
    }
}

