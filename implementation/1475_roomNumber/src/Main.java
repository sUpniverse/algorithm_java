import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10];

        List<boolean[]> checkList = new ArrayList<>();
        checkList.add(check);

        while (num > 0) {
            int n = num % 10;
            num /= 10;
            boolean flag = true;
            for(int i = 0; i < checkList.size(); i++) {
                flag = true;
                if(n == 9 || n == 6){
                    if(!checkList.get(i)[6]) {
                        flag = false;
                        checkList.get(i)[6] = true;
                        break;
                    }
                    if(!checkList.get(i)[9]) {
                        flag = false;
                        checkList.get(i)[9] = true;
                        break;
                    }
                } else {
                    if(!checkList.get(i)[n]){
                        flag = false;
                        checkList.get(i)[n] = true;
                        break;
                    }
                }
            }

            if(flag) {
                check = new boolean[10];
                check[n] = true;
                checkList.add(check);
                continue;
            }

        }

        System.out.println(checkList.size());
    }
}
