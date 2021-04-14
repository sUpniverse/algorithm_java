import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class    Main {

    static int[] cache;
    static int[] cup;

    static int MAX_VALUE = 100001;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        int number = Integer.parseInt(reader.readLine());

        cup = new int[MAX_VALUE];
        cache = new int[MAX_VALUE];

        for(int i = 1; i <= number; i++) {
         cup[i] = Integer.parseInt(reader.readLine());
        }
        cache[1] = cup[1];
        if(number > 1) {
            cache[2] = cup[1] + cup[2];
        }

        for(int i = 3; i <= number; i++) {
            cache[i] = Math.max(cache[i-2]+cup[i],Math.max(cache[i-3]+cup[i-1]+cup[i],cache[i-1]));
        }

        System.out.println(cache[number]);
    }

}
