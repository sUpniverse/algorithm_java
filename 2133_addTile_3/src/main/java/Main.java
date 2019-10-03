import java.util.Scanner;

public class Main {

    static int[] cache;
    static int MAX_VALUE = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        cache = new int[MAX_VALUE];

        int answer = 0;

        if(answer % 2 == 0){
            cache[0] = 1;
            cache[2] = 3;

            for(int i = 4; i < n+1; i+=2) {
                cache[i] = cache[i-2] * 3;
                for(int j = 4; j <= i; j+=2) {
                    cache[i] += cache[i-j] * 2;
                }
            }

            answer = cache[n];
        }

        System.out.println(answer);

    }
}
