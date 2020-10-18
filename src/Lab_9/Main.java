package Lab_9;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        DataOutputStream decipheredWrite    = new DataOutputStream(new FileOutputStream(args[1]));
        DataOutputStream processedWrite     = new DataOutputStream(new FileOutputStream(args[2]));
        DataInputStream cipheredRead        = new DataInputStream(new FileInputStream(args[0]));
        DataInputStream decipheredRead      = new DataInputStream(new FileInputStream(args[1]));
        //Extra TaSk    \_(0w0)_/
        DataOutputStream decipheredWrite2   = new DataOutputStream(new FileOutputStream(args[4]));
        DataInputStream processedRead       = new DataInputStream(new FileInputStream(args[2]));
        byte key = Byte.parseByte(args[3]);
        byte new_key=Byte.parseByte(args[5]);  //ключ дешифрования (byte).
        while (cipheredRead.available() > 0) { // Запись расшифрованных данных в args[1]
            decipheredWrite.writeByte(cipheredRead.readByte() ^ key);

        }
        while (decipheredRead.available() > 0) {
            //Считать переменную типа int и вычесть 205
            processedWrite.writeInt((int) (decipheredRead.readInt() - 205));
            //Считать переменную типа long и прибавить 205
            processedWrite.writeLong((long) (decipheredRead.readLong() + 205));
            //Считать переменную типа byte и умножить на 205
            processedWrite.writeByte((byte) (decipheredRead.readByte() * 205));
        }
        while (processedRead.available()>0){
            decipheredWrite2.writeByte(processedRead.readByte()^new_key);
        }
    }
}