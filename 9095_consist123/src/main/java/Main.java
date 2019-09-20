import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cache[];
    static int cache2[];

    public static void main(String[] agrs) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
        int test = Integer.parseInt(bufferedReader.readLine());
        
        cache2= new int[test+1];
        int max = 0;

        for(int i = 1; i <= test; i ++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            cache2[i] = n;
            max = Math.max(max,n);
        }
            cache = new int[max+1];
            topDown(max);

        for(int i = 1; i <= test; i ++) {
            System.out.println(cache[cache2[i]]);
        }
    }

    public static int bottomUp(int n){
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;

        for(int i = 4; i <= n; i++) {
            if(cache[i] != 0) return cache[i];
            cache[i] = cache[i-3] + cache[i-2] + cache[i-1];
        }

        return cache[n];
    }

    public static int topDown(int n) {
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;

        if(cache[n] != 0) return cache[n];
        cache[n] = topDown(n-3) + topDown(n-2) + topDown(n-1);
        return cache[n];
    }
}
