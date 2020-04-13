import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int N;
    static int M;
    static final int RED = 1;
    static final int BLUE = -1;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i =0; i<t; i++) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);

            graph = new ArrayList[N+1];
            visited = new int[N+1];
            check = true;

            for(int l = 0; l <= N; l++) {
                graph[l]  = new ArrayList<>();
            }

            for(int j = 0; j < M; j ++) {
                split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                graph[a].add(b);
                graph[b].add(a);
            }

            for(int k = 1; k <= N; k++) {
                if(visited[k] == 0){
                    dfs(k,RED);
                }
                if(!check) {
                    break;
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }

    static void dfs(int v,int color) {
        visited[v] = color;
        for(int i : graph[v]) {
            if(visited[v] == visited[i]) {
                check = false;
                return;
            }
            if(visited[i] == 0) {
                dfs(i, -color);
            }
        }
    }
}
