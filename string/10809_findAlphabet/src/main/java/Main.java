import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        byte[] bytes = br.readLine().getBytes();
        int[] n = new int[26];

        for(int i = 0; i< n.length; i++) {
            n[i] = -1;
        }

        for(int i = 0; i< bytes.length; i++) {
            if(n[bytes[i]-97] == -1) {
                n[bytes[i]-97] = i;
            }
        }

        for(int j = 0 ; j <26; j++) {
            System.out.print(n[j]+ " ");
        }
    }
}
