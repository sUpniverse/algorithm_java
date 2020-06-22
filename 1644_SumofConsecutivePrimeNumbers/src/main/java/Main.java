import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] primeList = new boolean[4000001];

        for(int i = 2; i*i <= 4000000; i+=1) {
            for(int j = i*i; j <= 4000000; j+=i) {
                primeList[j] = true;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i < 4000000; i++) {
            if(!primeList[i]) primes.add(i);
        }


        int first = 0;
        int second = 0;
        int sum = 0;
        int answer = 0;

        while (true) {
            if(sum >= n){
                if(sum == n) answer++;
                sum -= primes.get(first++);
            } else if(second == primes.size()) break;
            else sum += primes.get(second++);
        }

        System.out.println(answer);

    }
}
