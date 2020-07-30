import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long[] array = new long[n];

            array[0] = 1983;

            PriorityQueue<Long> max = new PriorityQueue<Long>(Collections.<Long>reverseOrder());
            PriorityQueue<Long> min = new PriorityQueue<Long>();

            for(int i = 1; i < n; i++) {
                array[i] = (array[i-1]*a+b) % 20090711;
            }

            long sum = 0;
            for(int i = 0 ; i < array.length; i++) {
                if(max.size() == min.size())
                    max.add(array[i]);
                else
                    min.add(array[i]);

                if(!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()) {
                    long num1 = min.poll();
                    long num2 = max.poll();

                    min.add(num2);
                    max.add(num1);
                }
                sum += max.peek();
            }

            sb.append(sum % 20090711).append("\n");
        }

        System.out.println(sb);
    }
}
