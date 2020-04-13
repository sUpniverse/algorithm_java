import java.util.Scanner;

public class Main {

    static int[] graph;
    static boolean[] visited;
    static int count = 0;
    static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();


        while (size-- > 0){
            count = sc.nextInt();

            graph = new int[count+1];
            visited = new boolean[count+1];
            num = 0;
            for(int j = 1; j <= count; j++) {
                int a = sc.nextInt();
                graph[j] = a;
            }

            for(int k = 1; k <= count; k++) {
                if(!visited[k]) {
                    dfs(k);
                }
            }
            System.out.println(num);
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        if(visited[graph[v]]) {
            num++;
            return;
        }
        dfs(graph[v]);
    }
}
