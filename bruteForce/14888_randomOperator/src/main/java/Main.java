import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long max;
    static long min;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> operatorList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operatorList = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            int b = Integer.parseInt(st.nextToken());
            while (b -- > 0) {
                operatorList.add(i);
            }
        }

        visited = new boolean[operatorList.size()];

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

        for(int i = 0; i < operatorList.size(); i++) {
            if(!visited[i]) {
                int operator = operatorList.get(i);
                long result = 0;
                if(operator == 0) {
                    result = add(value, numbers[depth]);
                } else if(operator == 1) {
                    result = subtract(value, numbers[depth]);
                } else if(operator == 2) {
                    result = multiply(value, numbers[depth]);
                } else if(operator == 3) {
                    result = divide(value, numbers[depth]);
                }
                visited[i] = true;
                bruteForce(depth+1, result);
                visited[i] = false;
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
