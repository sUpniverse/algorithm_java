import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

    static int n;
    static long max;
    static long min;
    static int[] numbers;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }


        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        bruteForce(1, numbers[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void bruteForce(int depth,long value) {
        if(depth == n) {
            min = Math.min(min,value);
            max = Math.max(max,value);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                long result = 0;
                if(i == 0) {
                    result = add(value, numbers[depth]);
                } else if(i == 1) {
                    result = subtract(value, numbers[depth]);
                } else if(i == 2) {
                    result = multiply(value, numbers[depth]);
                } else if(i == 3) {
                    result = divide(value, numbers[depth]);
                }
                operators[i]--;
                bruteForce(depth+1, result);
                operators[i]++;
            }
        }
    }


    static long add(long a, long b) {
        return a+b;
    }

    static long subtract(long a, long b) {
        return a-b;
    }

    static long multiply(long a, long b) {
        return a*b;
    }

    static long divide(long a, long b) {
        return a/b;
    }


}
