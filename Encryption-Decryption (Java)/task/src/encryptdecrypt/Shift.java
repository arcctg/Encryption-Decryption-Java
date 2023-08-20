package encryptdecrypt;

public class Shift extends Algorithms{

    @Override
    public char[] decrypt(char[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            int ch = data[i] - key;

            if (Character.isLowerCase(data[i])) {
                data[i] = (char) (ch < 97 ? ch + 26 : ch);
            } else if (Character.isUpperCase(data[i])) {
                data[i] = (char) (ch < 65 ? ch + 26 : ch);
            }
        }
        return data;
    }

    @Override
    public char[] encrypt(char[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            int ch = data[i] + key;

            if (Character.isLowerCase(data[i])) {
                data[i] = (char) (ch > 122 ? ch - 26 : ch);
            } else if (Character.isUpperCase(data[i])) {
                data[i] = (char) (ch > 90 ? ch - 26 : ch);
            }
        }
        return data;
    }
}
