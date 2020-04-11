import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        for(int i = M; i <= N; i++) {
            boolean check = false;
            for(int j=2; j <= Math.sqrt(i); j++) {
                if((i%j) == 0) {
                    check = true;
                    break;
                }
            }
            if(check == false && i > 1) {
                System.out.println(i);
            }
        }
    }
}
