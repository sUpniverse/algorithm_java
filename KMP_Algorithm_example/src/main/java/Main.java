import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        String a = "ABABABABC";
        String b = "ABAB";

        Queue<Integer> kmp = KMP(a.toCharArray(), b.toCharArray());
        for(int num : kmp) {
            System.out.println(num+1);
        }
    }

    static Queue<Integer> KMP(char[] A, char[] B) {
        int[] partial = getPartial(A);

        int j = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < A.length; i++) {

            while (j > 0 && A[i] != B[j])
                j = partial[j-1];

            if(A[i] == B[j]) {
                if(j == B.length - 1) {
                    queue.add(i);
                    j = partial[j];
                } else {
                    j++;
                }
            }
        }

        return queue;
    }

    static int[] getPartial(char[] list) {
        int[] array = new int[list.length];
        int j = 0;

        for (int i = 1; i < list.length; i++) {

            while (j > 0 && list[i] != list[j])
                j = array[j-1];


            if(list[i] == list[j]) {
                j++;
                array[i] = j;
            }
        }

        return array;
    }

}
