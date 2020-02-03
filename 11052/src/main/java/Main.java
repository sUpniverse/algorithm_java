import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] cache;

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        int count = Integer.parseInt(br.readLine());

        cache = new int[count];

        int[] card = new int[count];

        String line = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        for(int i = 0; i < count; i++) {
            card[i] = Integer.parseInt(stringTokenizer.nextToken(" "));
        }

        cache[0] = card[0];

        for(int i = 1; i < count; i++) {
            int maxValue = cache[i-1] + card[0];
            for(int j = 1; j <= i ; j++) {
                if(j == i) {
                    maxValue = Math.max(maxValue,card[j]);
                    continue;
                }
                maxValue = Math.max(maxValue,cache[i-j]+card[j-1]);
            }
            cache[i]= maxValue;
        }

        System.out.println(cache[count-1]);

    }

}
