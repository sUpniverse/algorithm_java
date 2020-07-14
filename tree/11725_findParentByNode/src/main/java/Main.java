import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        List<Integer>[] list = new List[n+1];
        boolean[] check = new boolean[n+1];
        int[] answer = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        check[1] = true;

        while(!queue.isEmpty()) {
            int integer = queue.remove();
            for(int a : list[integer]) {
                if(!check[a]) {
                    queue.add(a);
                    check[a] = true;
                    answer[a] = integer;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);

    }
}
