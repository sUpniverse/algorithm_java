import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int num1 = Integer.parseInt(s[0]);
        int num2 = Integer.parseInt(s[1]);

        int l = 0;
        for(int i = 1 ; i < Integer.max(num1, num2)+1; i++) {
            if ((num1 % i) == 0 && (num2 % i) == 0) {
                l = Integer.max(l, i);
            }
        }
//        int i  = 1;
//        while(i < Integer.MAX_VALUE) {
//            if((i%num1) == 0 && (i%num2) == 0) {
//                g = Integer.min(g, i);
//                break;
//            }
//            i++;
//        }

        System.out.println(l);
//        System.out.println(num1*num2/l);
    }
}
