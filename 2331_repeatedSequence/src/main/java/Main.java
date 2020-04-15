import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        while(true) {
            if(list.contains(N)) {
                System.out.println(list.indexOf(N));
                break;
            }
            list.add(N);

            N = getSequence(N, P);
        }
    }

    static int getSequence(int N,int P) {
        int sum = 0;
        while(N > 0) {
            sum += (int) Math.pow(N%10, P);
            N = N/10;
        }
        return sum;
    }
}
