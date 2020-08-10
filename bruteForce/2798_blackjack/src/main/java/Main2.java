import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

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

        search(0,0,0);

        System.out.println(max);


    }

    static void search(int depth,int index, int sum) {
        if(depth == 3) {
            if(sum > 0 && sum <= M)
                max = Math.max(max, sum);
            return;
        }

        for(int i = index; i < N; i++) {
            search(depth+1,i+1,sum+card[i]);
        }

    }
}
