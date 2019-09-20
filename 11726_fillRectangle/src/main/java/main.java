import java.io.BufferedReader;
import java.io.InputStreamReader;

//1 or 2를 사용해서 n을 구성할 수 있느 경우의
public class main {

    static int cache[];

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int n = Integer.parseInt(br.readLine());

        cache = new int[n+1];


        System.out.println(bottomUp(n));


    }

    public static int topDown(int n) {
        if(n == 0 || n == 1) return 1;
        if(cache[n] > 0) return cache[n];
        cache[n] = topDown(n-2) + topDown(n-1);
        cache[n] %= 10007;
        return cache[n];
    }

    public static int bottomUp(int n) {
        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= n; i++) {
           cache[i] = (cache[i-2] + cache[i-1]) % 10007;
        }

        return cache[n];
    }

}
