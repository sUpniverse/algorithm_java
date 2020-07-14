import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];

        for(int i = 0; i < n+1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        int[] answer = new int[n+1];

        queue.add(1);
        check[1] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for(int a : arrayLists[index]) {
                if(!check[a])  {
                    check[a] = true;
                    queue.add(a);
                    answer[a] = index;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < n+1; i++)
            sb.append(answer[i]).append("\n");

        System.out.println(sb);

    }
}
