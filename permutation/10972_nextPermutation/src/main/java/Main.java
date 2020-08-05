import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[] visited;
    static int[] list;
    static String s;
    static int flag;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = br.readLine() +" ";


        answer = "";
        for(int i = n; i > 0; i--)
            answer += i + " ";

        if(answer.equals(s)) {
            System.out.println(-1);
            return;
        }

        answer ="";
        list = new int[n];
        visited = new boolean[n+1];
        permutation(0);


        System.out.println(answer);
    }

    static void permutation(int depth){
        if(depth == n) {
            String text = "";
            for(int a : list)
                text += a+" ";
            if(flag == 1) {
                answer = text;
                flag = 2;
                return;
            }
            if(text.equals(s))
                flag = 1;
        }

        for(int i = 1; i <= n; i++) {
            if(flag == 2) return;
            if(visited[i]) continue;
            list[depth] = i;
            visited[i] = true;
            permutation(depth+1);
            visited[i] = false;
        }
    }
}
