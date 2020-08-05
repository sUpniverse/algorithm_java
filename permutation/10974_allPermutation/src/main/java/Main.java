import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new int[n];
        visited = new boolean[n+1];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int count) {

        if(count == n) {
            for(int i : list)
                sb.append(i +" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            list[count] = i;
            visited[i] = true;
            permutation(count+1);
            visited[i] = false;
        }
    }

}
