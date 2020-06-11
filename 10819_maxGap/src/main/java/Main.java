import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int sum,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        permutation(array, 0);

        System.out.println(sum);

    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a]  = array[b];
        array[b] = temp;
    }

    static void permutation(int[] array,int a) {
        if(a == n) {
            int temp = 0;
            for(int i = 0; i < n-1; i++) {
                temp+= Math.abs(array[i]-array[i+1]);
            }
            sum = Math.max(sum, temp);
            return;
        }

        for(int i = a; i < n; i++) {
            swap(array,a, i);
            permutation(array,a+1);
            swap(array,a, i);
        }
    }
}
