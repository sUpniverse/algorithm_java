import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();
        int[] array = new int[60];
        int max = 0;
        char word = ' ';

        for(int i = 0; i < chars.length; i++) {
            int a = 0;
            if(chars[i] < 91)
                a = chars[i] - 64;
            else
                a = chars[i] - 96;

            array[a]++;
            if(array[a] > max) {
                max = array[a];
                word = (char) (a+64);
            }
        }

        if(max > 0 && word != ' ') {
            for(int i = 0; i < array.length; i++){
                if(i != (word-64) && array[word-64] == array[i]) {
                    System.out.println("?");
                    return;
                }

            }

        }
        System.out.println(word);
    }
}
