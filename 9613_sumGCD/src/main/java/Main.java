import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        for(int i = 0; i < size; i++) {
            String[] s = br.readLine().split(" ");
            long sum = 0;
            for(int j = 1; j < s.length - 1; j++) {
                for(int k = j+1; k < s.length; k++) {
                    sum += gcd(Integer.parseInt(s[j]),Integer.parseInt(s[k]));
                }
            }
            System.out.println(sum);
        }
    }

    public static long gcd(int A, int B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A%B);
    }
}
