package encryptdecrypt;

public class AlgorithmStaticFactory {
    public static Algorithms newInstance(String type) {
        return switch (type) {
            case "unicode" -> new Unicode();
            case "shift" -> new Shift();
            default -> null;
        };
    }
}
