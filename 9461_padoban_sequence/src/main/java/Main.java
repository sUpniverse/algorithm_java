import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long[] cache;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int n = Integer.parseInt(br.readLine());
        int temp = 0;
        cache = new Long[101];

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            cache[0] = 0l;
            cache[1] = 1l;
            cache[2] = 1l;
            cache[3] = 1l;
            cache[4] = 2l;
            if(t > temp) {
                for(int j = 5; j <= t; j++)
                    cache[j] = cache[j-5] + cache[j-1];
            }
            temp = t;
            System.out.println(cache[t]);
        }
    }
}
