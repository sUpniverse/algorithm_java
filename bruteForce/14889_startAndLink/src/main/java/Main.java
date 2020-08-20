import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] team;
    static int n;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        team = new boolean[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        couple(0,0);

        System.out.println(min);
    }

    static void couple(int depth,int index) {
        if(depth == n/2) {
            int start = 0;
            int link = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(team[i] && team[j])
                        start += map[i][j];
                    if(!team[i] && !team[j])
                        link += map[i][j];
                }
            }
            min = Math.min(min, Math.abs(start-link));
            return;
        }

        for(int i = index; i < n; i++) {
            if(!team[i]) {
                team[i] = true;
                couple(depth+1,i+1);
                team[i] = false;
            }
        }
    }
}
