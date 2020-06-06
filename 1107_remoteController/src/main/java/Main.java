import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // scanner로 받는이유 : bufferedReader로 받을경우 m이 0일때 일단 br.readline()이 실행되면서 한줄 입력을 받게 된다.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] array = new boolean[10];

        for(int i = 0; i < m; i++) {
            array[sc.nextInt()] = true;
        }

        int abs = Math.abs(n - 100);        // +- 버튼으로 간다면 걸리는 횟수
        for(int i = 0; i <= 1000000; i++) {
            int length = 0;
            int channel = i;

            if(channel == 0) {
                length = array[0] ? 0 : 1;
            }
            // 전수조사 과정 리모컨의 숫자버튼으로 갈수있는 채널을 다 구하는 과정
            while(channel > 0) {
                if(array[channel%10]) {
                    length = 0;
                    break;
                }
                length++;
                channel/=10;
            }

            // 버튼으로 갈수있는 채널을 확인했다면 이제 버튼누른횟수 + (+,-) 버튼을 이용해서 목표 채널에 가는 횟수 vs (+,-)로 그냥 가는 횟수 비교
            if(length > 0)  {
                int press = Math.abs(i - n);
                abs = Math.min(abs,press+ length);
            }
        }

        System.out.println(abs);
    }
}
