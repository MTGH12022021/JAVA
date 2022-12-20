package database;

import java.io.*;

public class readfile {
    public readfile(){
        File file = new File("D:\\Java\\Code\\Project\\Final\\sqlchat.sql");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int c;
            while((c = fileInputStream.read()) != -1){
                System.out.print((char)c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }  catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new readfile();
    }
}
