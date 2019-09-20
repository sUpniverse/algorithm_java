import java.util.Scanner;

// n-1 을 1로 만드는 최소횟수 +1, n/2를 1로 만드는 최소횟수 +1, n/3을 1로 만드는 최소횟수 +1
public class main {

    static int[] cache;

    public static void main(String[] agrs) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cache = new int[n+1];

        int count = topDown(n);

        System.out.println(count);
    }

    public static int topDown(int n) {

        if(n == 1) return 0;

        if (cache[n] > 0) return cache[n];

        cache[n]  = topDown(n-1) + 1;
        if( n % 2 == 0)
            cache[n] = Math.min(cache[n],topDown(n/2)+1);
        if( n % 3 == 0)
            cache[n]  = Math.min(cache[n],topDown(n/3)+1);

        return cache[n];

    }

    public static int bottomUp (int n) {

        for(int i = 2; i <= n; i++) {
            cache[i]  = cache[i-1] + 1;
            if( i % 2 == 0)
                cache[i] = Math.min(cache[i],cache[i/2]+1);
            if( i % 3 == 0)
                cache[i]  = Math.min(cache[i],cache[i/3]+1);
        }

        return cache[n];
    }
}
