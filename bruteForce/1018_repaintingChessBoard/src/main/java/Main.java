import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char W = 'W';
    static char B = 'B';
    static char[] bArray = {'B','W','B','W','B','W','B','W'};
    static char[] wArray = {'W','B','W','B','W','B','W','B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int wCount = 0;
        int mCount = 0;

        char[][] map  = new char[n][m];

        for(int i = 0; i < n; i++) {
            String a = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = a.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i+7 < n; i++) {
            for(int j = 0; j+7 < m; j++) {
                int count1 = getCount(i, j, B, map);
                int count2 = getCount(i, j, W, map);
                answer = Math.min(answer,Math.min(count1, count2));
            }
        }

        System.out.println(answer);

    }

    static int getCount(int n, int m, char t, char[][] map) {
        int count = 0;
        int num = 0;
        if(t == B) num = 1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i+num) % 2 == 0){
                    if(map[i+n][j+m] != wArray[j]) count++;
                }
                else {
                    if(map[i+n][j+m] != bArray[j]) count++;
                }
            }
        }
        return count;
    }
}
