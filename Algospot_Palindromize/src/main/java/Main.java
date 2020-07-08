import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T -- > 0) {
            String next = sc.next();

            StringBuilder rb = new StringBuilder();
            String nextReverse = rb.append(next).reverse().toString();

            sb.append(2 * next.length() - getTable(next.toCharArray(),nextReverse.toCharArray())).append("\n");

        }

        System.out.println(sb);
    }

    static int getTable(char[] array,char[] arrayReverse) {
        int[] pi = getPartialTable(arrayReverse);
        int j = 0;

        for(int i = 0; i < array.length; i++) {
            while (j > 0  && array[i] != arrayReverse[j]) {
                j = pi[j-1];
            }

            if(array[i] == arrayReverse[j]) {
                if(j == array.length-1) return array.length;
                else j++;
            }
        }

        return  j;
    }

    static int[] getPartialTable(char[] array) {
        int[] pi = new int[array.length];
        int j = 0;

        for(int i = 1; i < array.length; i++) {
            while (j > 0 && array[i] != array[j])
                j = pi[j-1];

            if(array[i] == array[j]) {
                j++;
                pi[i] = j;
            }
        }

        return pi;
    }
}
