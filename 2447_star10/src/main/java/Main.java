import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stars = new char[n][n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            Arrays.fill(stars[i],' ');
        }


        divide(0,0,n);


        for(int i = 0; i < n; i++) {
            sb.append(stars[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int x,int y,int size) {
        if(size == 1) {
            stars[x][y] = '*';
            return;
        }

        int a = size/3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1 ) {
                    continue;
                }
                divide(x + (a*i), y + (a*j), a);
            }
        }

    }
}
