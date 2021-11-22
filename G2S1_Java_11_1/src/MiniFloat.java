public class MiniFloat {
    public static void main(String[] args) {
        System.out.println(numIntegralMiniFloats());
    }
    public static float miniFloatFromString(String s) {

        float ans = (float) Math.pow(-1, Integer.parseInt(s.substring(0,1)));
        float p = 0, f = 1;

        for (int n=4, a=0; n>1; n--, a++)
            p += Math.pow(2, a) * Integer.parseInt(s.substring(n,n+1));
        p -= Integer.parseInt(s.substring(1,2))*127;

        for (int m=5, b=1; m<8; m++, b++)
            f += (1/Math.pow(2, b)) * Integer.parseInt(s.substring(m,m+1));

        ans *= Math.pow(2, p) * f;
        return ans;
    }

    public static int  numIntegralMiniFloats() {
        int count = 0;
        for (int a=0; a <= 0xff; a++) {
            String binary = Integer.toBinaryString(a);
            for (int l = binary.length(); l < 8; l++)
                binary = '0' + binary;
            float local = miniFloatFromString(binary);
            if (local == (float)(int)local) {
                count++;
            }
        }
        return count;
    }
}