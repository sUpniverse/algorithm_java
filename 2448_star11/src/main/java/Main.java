import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        array = new char[n][2*n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(array[i],' ');
        }

        divide(0,n-1,n);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <n; i++) {
            sb.append(array[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int x, int y, int size) {
        if(size == 3) {
            array[x][y] = '*';
            array[x+1][y+1] = '*';
            array[x+1][y-1] = '*';
            array[x+2][y-1] = '*';
            array[x+2][y+1] = '*';
            array[x+2][y] = '*';
            array[x+2][y+2] = '*';
            array[x+2][y-2] = '*';
            return;
        }

        int n = size/2;

        divide(x, y, n);
        divide(x+n,y-n,n);
        divide(x+n, y+n, n);
    }


}
