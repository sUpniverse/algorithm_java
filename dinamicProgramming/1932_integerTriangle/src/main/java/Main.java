import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        int[][] cache = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++)
                triangle[i][j] = Integer.parseInt(st.nextToken());
        }

        cache[0][0] = triangle[0][0];

        for(int i = 1; i <n; i++) {
            cache[i][0] = cache[i-1][0] + triangle[i][0];
            cache[i][i] = cache[i-1][i-1] + triangle[i][i];
            for(int j = 1; j < i; j++) {
                cache[i][j] = Math.max(cache[i-1][j-1],cache[i-1][j]) + triangle[i][j];
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, cache[n-1][i]);
        }
        System.out.println(answer);
    }
}
