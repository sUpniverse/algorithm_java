import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();

        int[][] dp = new int[string1.length+1][string2.length+1];

        for(int i = 0; i <= string1.length; i++) {
            for(int j = 0; j <= string2.length; j++) {
            if(i == 0 || j == 0) {
                dp[i][j] = 0;
                continue;
            }
                if(string1[i-1] == (string2[j-1])){
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[string1.length][string2.length]);
    }

}
