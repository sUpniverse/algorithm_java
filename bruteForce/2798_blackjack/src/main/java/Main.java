import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max;
    static int N;
    static int M;
    static int[] card;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        card = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        search(0);

        System.out.println(max);


    }

    static void search(int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(!visited[i]) continue;
                sum += card[i];
            }
            if(sum > 0 && sum <= M)
                max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            search(depth+1);
            visited[i] = false;
        }

    }
}
