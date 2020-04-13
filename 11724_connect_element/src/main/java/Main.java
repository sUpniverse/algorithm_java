import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[][] graph;
    static int[] dfscache;
    static int[] bfscache;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        dfscache = new int[N+1];
        bfscache = new int[N+1];

        for(int i = 0;  i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;

        }

        for(int i = 1; i <= N; i++) {
            if(dfscache[i] == 1) {
                continue;
            }
            cnt++;
            dfs(i);
        }
        System.out.println(cnt);
    }


    public static void dfs(int n) {

        dfscache[n] = 1;
        for(int i = 1; i <= N; i++) {
            if(graph[n][i] == 1) {
                if(dfscache[i] == 1) {
                    continue;
                }
                dfscache[i] = 1;
                dfs(i);
            }
        }
    }
}