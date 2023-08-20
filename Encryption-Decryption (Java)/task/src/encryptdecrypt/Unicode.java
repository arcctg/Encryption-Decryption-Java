package encryptdecrypt;

public class Unicode extends Algorithms{

    @Override
    public char[] decrypt(char[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (char) (data[i] - key);
        }
        return data;
    }

    @Override
    public char[] encrypt(char[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (char) (data[i] + key);
        }
        return data;
    }
}
