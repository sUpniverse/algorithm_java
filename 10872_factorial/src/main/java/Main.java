import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int sum = 1;
        for(int i = num; i > 0; i--) {
            sum *= i;
        }

        System.out.println(sum);
    }

//    public static int factorial(int n) {
//        if(n ==1) return 1;
//        return factorial(n-1) * n;
//    }
}
