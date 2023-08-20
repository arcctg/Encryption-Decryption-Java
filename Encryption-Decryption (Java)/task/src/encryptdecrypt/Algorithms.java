package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Algorithms{
    private String out;
    private String in;
    private String mode;
    private String data;
    private int key;

    public void setAlgorithms(String out, String in, String mode, String data, int key) {
        this.out = out;
        this.in = in;
        this.mode = mode;
        this.data = data;
        this.key = key;
    }

    public void process() {
        if (!"".equals(in)) {
            data = read(in);
        }

        char[] arr = data.toCharArray();

        switch (mode) {
            case "enc" -> encrypt(arr, key);
            case "dec" -> decrypt(arr, key);
        }

        write(arr, out);
    }

    private static String read(String in) {
        File file = new File(in);
        String data = "";
        try (Scanner scanner = new Scanner(file)){
            data = scanner.nextLine();
        } catch (IOException e) {
            System.out.println("error");
            return "";
        }
        return data;
    }

    private static void write(char[] arr, String out) {
        if (!"".equals(out)) {
            File file = new File(out);
            try (FileWriter writer = new FileWriter(file)) {
                file.createNewFile();
                writer.write(arr);
            } catch (IOException e) {
                System.out.println("error");
            }
        } else {
            System.out.println(String.valueOf(arr));
        }
    }

    public abstract char[] decrypt(char[] data, int key);

    public abstract char[] encrypt(char[] data, int key);
}
