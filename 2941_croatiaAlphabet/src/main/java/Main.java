import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] dictionary = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        for(int i = 0; i < dictionary.length; i++) {
            if(s.contains(dictionary[i]))
                s = s.replace(dictionary[i],"*");
        }

        System.out.println(s.length());

    }
}
