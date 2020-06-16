import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int f  = Integer.parseInt(split[0]);
        int s  = Integer.parseInt(split[1]);
        int g  = Integer.parseInt(split[2]);
        int u  = Integer.parseInt(split[3]);
        int d  = Integer.parseInt(split[4]);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[f+1];
        int[] array = new int[f+1];

        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int a = queue.remove();
            if(a == g) {
                System.out.println(array[g]);
                return;
            }

            if(a+u <= f && !visited[a+u]) {
                queue.add(a+u);
                visited[a+u] = true;
                array[a+u] = array[a] + 1;
            }

            if(a-d > 0 && !visited[a-d]) {
                queue.add(a-d);
                visited[a-d] = true;
                array[a-d] = array[a] + 1;
            }
        }
        System.out.println("use the stairs");


    }
}
