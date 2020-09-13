public class test3 {
    static int min;
    static int value;

    public static void main(String[] args) {
        solution(9);
    }

    static int[] solution(int n) {
        min = Integer.MAX_VALUE;
        if(n < 10) {
            min = 0;
            value = n;
        } else {
            dfs(n, 0);
        }

        int[] answer = new int[2];

        answer[0] = min;
        answer[1] = value;

        return answer;
    }

    static void dfs(int number, int count) {
        if(number / 10 == 0 || count >= min) {
            if(count < min && count > 3) {
                min = count;
                value = number;
            }
            return;
        }

        int num = (int) Math.log10(number);
        for(int i = num; i > 0; i--) {
            int n = (int) Math.pow(10, i);
            dfs((number/n)+(number%n), count+1);
        }
    }



}
