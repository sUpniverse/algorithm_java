import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] cache;
    static int[][] house;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        house = new int[n][3];
        cache = new int[n][3];

        answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());

        }

        cache[0][0] = house[0][0];
        cache[0][1] = house[0][1];
        cache[0][2] = house[0][2];

        for(int i = 1 ; i < n; i++) {
            cache[i][0] = Math.min(cache[i-1][1],cache[i-1][2]) + house[i][0];
            cache[i][1] = Math.min(cache[i-1][0],cache[i-1][2]) + house[i][1];
            cache[i][2] = Math.min(cache[i-1][0],cache[i-1][1]) + house[i][2];
        }

        System.out.println(Math.min(Math.min(cache[n-1][0],cache[n-1][1]),cache[n-1][2]));
    }

}
