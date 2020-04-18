import java.io.IOException;

public class Solution1 {

    public static void main(String[] args) throws IOException {

        String p = "00000000000000000000";
        String s = "91919191919191919191";
        String[] p1 = p.split("");
        String[] s1 = s.split("");

        int answer = 0;

        int[] arr = new int[10];

        for(int i = 0; i < p1.length; i++) {
            answer += Math.min(go(Integer.parseInt(p1[i]),Integer.parseInt(s1[i])),back(Integer.parseInt(p1[i]),Integer.parseInt(s1[i])));
        }

        System.out.println(answer);
    }

    static int go(int start, int end){
        int count  = 0;
        for(int i = start; i<=9; i++) {
            if(i == end) break;
            if(i == 9) i=-1;
            count++;
        }
        return count;
    }

    static int back(int start, int end) {
        int count  = 0;
        for(int i = start; i >=0; i--) {
            if(i == end) break;
            if(i == 0) i=10;
            count++;
        }
        return count;
    }

}
