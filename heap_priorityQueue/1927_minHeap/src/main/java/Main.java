import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue queue = new PriorityQueue();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(queue.poll()).append("\n");
                continue;
            }
            queue.add(a);
        }

        System.out.println(sb);
    }
}
