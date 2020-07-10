import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};


        char[] split = br.readLine().toCharArray();
        int sum = 0;

        for(int i = 0; i < split.length; i++)
            sum += array[split[i]-65] +1;

        System.out.println(sum);

    }
}
