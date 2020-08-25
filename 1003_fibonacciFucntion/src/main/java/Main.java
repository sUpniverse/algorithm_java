import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        int[][] cache = new int[41][2];

        cache[0][0] = 1;
        cache[0][1] = 0;
        cache[1][0] = 0;
        cache[1][1] = 1;

        for(int j = 2; j <= 40; j++) {
            cache[j][0] = cache[j-2][0] + cache[j-1][0];
            cache[j][1] = cache[j-2][1] + cache[j-1][1];
        }


        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cache[n][0]).append(" ").append(cache[n][1]).append("\n");
        }

        System.out.println(sb);
    }


}
