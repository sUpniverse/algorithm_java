import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,max,value;
    static ArrayList<Node>[] edges;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            edges[a] = new ArrayList<>();
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if(b == -1) {
                    break;
                }
                int c = Integer.parseInt(st.nextToken());
                edges[a].add(new Node(b,c));
            }
        }

        max = 0;
        value = 0;
        check = new boolean[n+1];
        dfs(1, 0);

        check = new boolean[n+1];
        dfs(max,0);


        System.out.println(value);
    }

    static void dfs(int x, int dis) {
        check[x] = true;
        for(Node tmp : edges[x]) {
            if(!check[tmp.num] ) {
                dfs(tmp.num, dis+tmp.dis);
            }
        }

        if(dis > value) {
            max = x;
            value = dis;
        }
    }

    static class Node {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }
}
