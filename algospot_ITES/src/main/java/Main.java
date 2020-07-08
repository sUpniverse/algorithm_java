import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long pre = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            sb.append(calculate(k, n)).append("\n");
        }

        System.out.println(sb);

    }

    static int calculate(int k, int n) {
        pre = 1983;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int sum = 0;

        for(int head = 0; head < n; head++) {
            int a = getNext();
            sum += a;
            queue.add(a);

            while (sum > k) {
                Integer poll = queue.poll();
                sum -= poll;
            }

            if(sum == k) {
                count++;
            }
        }

        return count;
    }

    static int getNext() {
        int ret = (int)(pre % 10000) + 1;
        pre = (pre * 214013 + 2531011) % (long) Math.pow(2, 32);
        return ret;
    }

}
