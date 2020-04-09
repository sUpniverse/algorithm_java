import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();   //미래 진법
        int B = sc.nextInt();  //정이 사용진법

        int m = sc.nextInt();  // A진법 수의 자리수 개수


        int sum = 0;
        for(int i = 0; i <m; i++) {
            int x = sc.nextInt();
            sum = sum * A + x;
        }


        Stack<Integer> stack = new Stack<>();

        while (sum != 0) {
            stack.push(sum%B);
            sum/=B;
        }

        int size = stack.size();
        for(int j = 0; j < size; j++) {
            System.out.print(stack.pop()+" ");
        }


    }
}
