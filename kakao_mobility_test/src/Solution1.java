public class Solution1 {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    static public int solution(int num) {

        int sum = 0;
        for(int i = 1; i <= num; i++) {
            int value = i;
            while (value > 0) {
                int v = value % 10;
                if(v == 3 || v == 6 || v == 9) {
                    sum++;
                    break;
                }
                value = value / 10;
            }
        }

        return sum;
    }
}
