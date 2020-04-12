import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(long i = 2; i*i <= num; i++) {
            while((num % i) == 0) {
                if((num%i) == 0) {
                    sb.append(i+"\n");
                    num /= i;
                }
            }
        }
        if(num != 1) sb.append(num);

        System.out.println(sb);
    }
}
