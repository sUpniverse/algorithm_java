import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] line;
    static int[] dfscache;
    static int[] bfscache;
    static int N;

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());



        N = Integer.parseInt(stringTokenizer.nextToken());
        int M  = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        line = new int[N+1][N+1];
        dfscache = new int[N+1];
        bfscache = new int[N+1];

        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            line[a][b] = 1;
            line[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        bfs(V);

    }

    public static void dfs(int v) {

        dfscache[v] = 1;

        System.out.print(v+" ");
        for(int i = 1; i <= N; i++) {
            if(line[v][i] == 1) {
                if(dfscache[i] == 1) {
                    continue;
                }
                dfs(i);
            }
        }

    }

    public static void bfs(int v) {

        Queue queue = new LinkedList();

        bfscache[v] = 1;
        queue.add(v);
        while(!queue.isEmpty()) {
            int poll = (Integer) queue.poll();
            System.out.printf(poll+" ");
            for(int i = 1; i <= N; i++) {
                if(line[poll][i] == 1) {
                    if(bfscache[i] == 1) {
                        continue;
                    }
                    bfscache[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}
