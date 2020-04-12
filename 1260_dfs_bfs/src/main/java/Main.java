import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] edges;
    static int N;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        int M  = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        edges = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i <edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        for(int i = 0; i <edges.length; i++) {
            Collections.sort(edges[i]);
        }

        dfs(V);
        bw.newLine();
        visited = new boolean[N+1];
        bfs(V);
        bw.close();

    }

    public static void dfs(int v) throws IOException {
        visited[v]  = true;
        bw.write(v+" ");
        for(Integer i : edges[v]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[v] = true;
        queue.add(v);
        int poll;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            bw.write(poll+" ");
            for(int i = 0; i < edges[poll].size(); i++) {
                if(!visited[edges[poll].get(i)]) {
                    queue.add(edges[poll].get(i));
                    visited[edges[poll].get(i)] = true;
                }
            }
        }
    }
}
