import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] checks = new boolean[1000001];
        checks[1] = true;
        for (int i=2; i*i<=1000000; i++) {
            if(checks[i]==false) {
                for (int j=i*i; j<=1000000; j+=i) {
                    checks[j]=true;
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        int n = sc.nextInt();
        while(n > 0) {
            boolean possible = true;
            for(int i = 3; i < n; i++) {
                if(checks[i] == false) {
                    if(checks[n - i]) continue;
                    possible = false;
                    sb.append(n +" = " + i + " + "+(n-i)+"\n");
                    break;
                }
            }
            if(possible)
                sb.append("Goldbach's conjecture is wrong."+"\n");

            n = sc.nextInt();
        }
        System.out.println(sb);
    }
}


