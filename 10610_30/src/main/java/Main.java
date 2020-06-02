import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");

        int[] array = new int[split.length];
        for(int i = 0 ; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        boolean check = false;

        //10의 배수인가? : 0이 있는가?
        int sum = 0;
        for(int i = 0 ; i < array.length; i++) {
            sum += array[i];
            if(array[i] == 0) {
                check = true;
            }
        }

        //3의 배수 인가? : 모든 자리수의 합이 3의 배수이면 3의 배수이다.
        //이런걸 어찌 알지.... 그냥 경험해보는 수밖에
        if(sum % 3 != 0 || !check) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i >= 0 ; i--) {
            sb.append(array[i]);
        }

        System.out.println(sb);

    }
}
