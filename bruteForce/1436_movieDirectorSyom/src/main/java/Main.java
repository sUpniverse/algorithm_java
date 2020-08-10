import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long i = 0;
        int num = 0;
        while (true) {
            long a = i;
            int count = 0;
            while (a > 0) {
                if(a % 10 == 6) {
                    count++;
                    if(count == 3) {
                        num++;
                        break;
                    }
                } else count = 0;
                a /= 10;
            }
            if(num == n) break;
            i++;
        }
        System.out.println(i);
    }
}
