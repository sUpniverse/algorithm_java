import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cardListOfS = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            cardListOfS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardListOfS);


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());



        int[] answer = new int[m];

        for(int i = 0; i < m; i++) {
            int l = 0;
            int r = n-1;
            int a = Integer.parseInt(st.nextToken());
            while(l <= r) {
                int mid = (l + r) / 2;
                if(a == cardListOfS[mid]) {
                    answer[i] = 1;
                    break;
                } else if(a > cardListOfS[mid]) {
                    l = mid+1;
                } else {
                    r = mid -1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            System.out.print(answer[i]+" ");
        }
    }

}
