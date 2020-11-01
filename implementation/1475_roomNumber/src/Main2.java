import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] check = new int[10];

        for(int i = 0; i < num.length(); i++) {
            char number = num.charAt(i);
            if(number == '9')
                check[6]++;
            else
                check[number-48]++;

        }

        int remain = check[6];
        if(check[6] > 1)
            remain = check[6] / 2;

        check[9] = remain;
        check[6] -= remain;

        int max = 0;
        for(int i = 0; i < 10; i++) {
            max = Math.max(max,check[i]);
        }


        System.out.println(max);
    }
}
