import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        int minusNum = 0;
        int zeroNum = 0;
        int plusNum = 0;

        for(int i = 0; i < n; i ++) {
            int a = Integer.parseInt(br.readLine());
            if(a < 0) {
                minusNum++;
            } else if(a == 0) {
                zeroNum++;
            } else {
                plusNum++;
            }
            array[i] = a;
        }

        int plusIdx = minusNum+zeroNum;
        int sum1 = 0;
        Arrays.sort(array);


        if(minusNum % 2 ==1) {
            sum1 = array[minusNum-1];
            if(zeroNum > 0) sum1 = 0;
            minusNum--;
        }

        for(int i = 0; i < minusNum; i+=2) {
            sum1+= array[i] * array[i+1];
        }

        int sum2 = 0;

        if(plusNum%2 == 1){
            sum2 = array[plusIdx];
        }
        for(int i = array.length - 1; i > plusIdx; i-=2) {
            if(array[i-1] == 1) {
                sum2 += array[i] + array[i - 1];
            } else {
                sum2 += array[i] * array[i-1];
            }
        }

        System.out.println(sum1+sum2);
    }

}
