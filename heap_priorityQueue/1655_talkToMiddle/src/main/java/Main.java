import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        while (T-- > 0) {
            if(max.size() == min.size())
                max.add(Integer.parseInt(br.readLine()));
            else
                min.add(Integer.parseInt(br.readLine()));

            // min에서 제일 작은 녀석 > max에서 제일 큰 녀석이 성립하면, max의 제일 큰 녀석은 중간값 이다.
            // 그렇지 않은 경우 (max의 최대 min의 최소보다 크기때문에 둘을 바꾼다)
            while (!max.isEmpty() && !min.isEmpty() && min.peek() < max.peek()) {
                int minValue = min.poll();
                int maxValue = max.poll();

                min.add(maxValue);
                max.add(minValue);
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
