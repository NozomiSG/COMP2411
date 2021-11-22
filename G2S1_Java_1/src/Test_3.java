import java.util.Random;

public class Test_3{
    public static void main(String[] args) {
        for (int i = 0; i <= 0xFF; i++) {
            StringBuilder builder = new StringBuilder("00000000");
            String binary = Integer.toBinaryString(i);
            builder.replace(8 - binary.length(), 8, binary);
            System.out.println(builder);
        }
        St();
    }
    public static void St() {
        for (int a=0; a <= 0xff; a++) {
            String binary = Integer.toBinaryString(a);
            for (int l = binary.length(); l < 8; l++)
                binary = '0' + binary;
        }
    }
}