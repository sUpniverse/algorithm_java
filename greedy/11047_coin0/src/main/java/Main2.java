import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int[] coin  = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }


        int count = 0;
        int i = n-1;
        while (k > 0) {
            if(k >= coin[i]) {
                count += k / coin[i];
                k %= coin[i];
            }
            i--;
        }

        System.out.println(count);

    }

}
