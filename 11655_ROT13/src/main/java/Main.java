import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        for(int i = 0; i <chars.length; i++) {
            if(chars[i] > 64 && chars[i] < 91) {
                chars[i]+=13;
                if(chars[i] > 90)
                    chars[i]-=26;
            } else if (chars[i] > 96 && chars[i] < 123) {
                chars[i]+=13;
                if(chars[i] > 122)
                    chars[i]-=26;
            }
        }

        for(int j = 0; j < chars.length; j++) {
            System.out.print(chars[j]);
        }
    }
}
