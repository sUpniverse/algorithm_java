import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] cache = new int[2][100001];
        int[][] sticker = new int[2][100001];

        int n;
        int m;

        n = sc.nextInt();

        for(int k = 0; k < n; k++) {
            m = sc.nextInt();

            for(int i = 0; i < 2; i++) {
                for(int j = 1; j <= m; j++) {
                    if(j < m) {
                        sticker[i][j] = sc.nextInt();
                        continue;
                    }
                    sticker[i][j] = Integer.parseInt(sc.next().trim());
                }
            }

            cache[0][1] = sticker[0][1];
            cache[1][1] = sticker[1][1];

            for(int i = 2; i <= m; i++) {
                cache[0][i] = Math.max(cache[1][i-1],cache[1][i-2]) + sticker[0][i];
                cache[1][i] = Math.max(cache[0][i-1],cache[0][i-2]) + sticker[1][i];
            }

            System.out.println(Math.max(cache[0][m],cache[1][m]));
        }
    }
}
