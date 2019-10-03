import java.util.Scanner;

public class Main {

    static int[] cache;
    static int MAX_VALUE = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cache = new int[MAX_VALUE];

        for(int i = 1; i <= n ; i++) {
            cache[i] = i;
            for(int j = 1; j*j <= i; j++) {
                cache[i] = Math.min(cache[i],cache[i - (j*j)] + 1);
            }
        }
        System.out.println(cache[n]);
    }
}
