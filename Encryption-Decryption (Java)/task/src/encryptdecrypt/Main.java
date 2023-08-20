package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        String data = "";
        String in = "";
        String out = "";
        int key = 0;
        String alg = "shift";

        for (int i = 0; i <= args.length - 1; i += 2) {
            switch (args[i]) {
                case "-mode" -> mode = args[i + 1];
                case "-key" -> key = Integer.parseInt(args[i + 1]);
                case "-data" -> data = args[i + 1];
                case "-in" -> in = args[i + 1];
                case "-out" -> out = args[i + 1];
                case "-alg" -> alg = args[i + 1];
            }
        }

        Algorithms algorithms = AlgorithmStaticFactory.newInstance(alg);
        algorithms.setAlgorithms(out, in, mode, data, key);
        algorithms.process();
    }

//    private static void crypt(String mode, String data, int key, String in, String out, String alg) {
//        if (!"".equals(in)) {
//            data = read(in);
//        }
//
//        char[] arr = data.toCharArray();
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (char) ("enc".equals(mode) ? arr[i] + key : arr[i] - key);
//        }
//
//        write(arr, out);
//    }
//
//    private static String read(String in) {
//        File file = new File(in);
//        String data = "";
//        try (Scanner scanner = new Scanner(file)){
//            data = scanner.nextLine();
//        } catch (IOException e) {
//            System.out.println("error");
//            return "";
//        }
//        return data;
//    }
//
//    private static void write(char[] arr, String out) {
//        if (!"".equals(out)) {
//            File file = new File(out);
//            try (FileWriter writer = new FileWriter(file)) {
//                file.createNewFile();
//                writer.write(arr);
//            } catch (IOException e) {
//                System.out.println("error");
//            }
//        } else {
//            System.out.println(String.valueOf(arr));
//        }
//    }
}