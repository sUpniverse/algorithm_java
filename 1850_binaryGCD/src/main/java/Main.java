import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        long num1 = Long.parseLong(s[0]);
        long num2 = Long.parseLong(s[1]);


        long g = 0;
        g = gcd(num1,num2);

        StringBuilder st = new StringBuilder();

        for(int i = 0 ; i < g; i++) {
            st.append(1);
        }


        System.out.println(st);
    }

    public static long gcd(long A, long B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A%B);
    }

}
