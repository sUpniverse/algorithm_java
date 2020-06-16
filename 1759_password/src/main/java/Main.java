import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] mo = {'a','e','i','o','u'};
    static char[] array;
    static StringBuilder sb;
    static int l,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        array = new char[c];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< c; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);

        composition("", 0);


        System.out.println(sb);

    }

    static void composition(String word,int now) {
        if(word.length() == l && isCorrect(word)) {
            sb.append(word+'\n');
            return;
        }

        for(int i = now; i <= now+c-l; i++) {
            if(i < c) {
                composition(word+array[i],i+1);
            }
        }

    }

    static boolean isCorrect(String word) {
        int count = 0;

        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < mo.length; j++) {
                if(word.charAt(i) == mo[j]) count++;
            }
        }

        if(count >= 1 && (word.length() - count) >= 2) {
            return true;
        }
        return false;
    }

}
