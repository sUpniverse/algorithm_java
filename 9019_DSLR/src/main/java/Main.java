import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int start,end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t =  Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<Integer>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            Arrays.fill(command, "");

            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty() && !visited[end]) {
                int a = queue.poll();
                int D = (a*2) % 10000;
                int S = (a == 0)? 9999 : a-1;
                int L = (a % 1000) * 10 + (a/1000);
                int R = (a / 10) + (a % 10) * 1000;

                if(!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    command[D] = command[a] + "D";
                }
                if(!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    command[S] = command[a] + "S";
                }
                if(!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    command[L] = command[a] + "L";
                }
                if(!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    command[R] = command[a] + "R";
                }

            }

            System.out.println(command[end]);
        }
    }
}
