import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int n  = Integer.parseInt(split[0]);
        int k  = Integer.parseInt(split[1]);

        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = n-1; i >= 0; i--) {
            if(k >= array[i]) {
                count += k / array[i];
                k %= array[i];
                if(k == 0) {
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
