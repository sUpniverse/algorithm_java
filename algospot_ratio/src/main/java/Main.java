import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            flag = false;

            long answer = apply(N, M);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static long calculate(long total, long win) {
        return win*100/total;
    }

    static long apply(int total, int win) {
        long low = 0;
        long high = 2000000000;
        long destination = calculate(total, win);
        if(destination == calculate(total+high, win+high))
            return -1;

        while (low +1 < high) {
            long mid = (low+high)/2;
            int cal = (int) calculate(total+mid, win+mid);
            if(destination == cal) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
