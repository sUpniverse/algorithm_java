import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] budget = {120, 110, 140, 150};
        int M  = 485;

        int solution = solution(budget, M);

        System.out.println(solution);
    }

    public static int solution(int[] budgets, int M) {

        int l = 0;
        int r = M;
        int mid = 0;
        long total = 0;
        int answer = 0;

        Arrays.sort(budgets);

        for(int i = 0 ; i< budgets.length; i++)
            total += budgets[i];
        if(total <= M)
            return budgets[budgets.length-1];

        while (l <= r) {
            mid = (l+r) / 2;

            total = 0;
            for(int i = 0; i < budgets.length; i++) {
                int a = budgets[i] - mid > 0 ? mid : budgets[i];
                total += a;
            }

            if(total > M) {
                r = mid-1;
            } else if(total <= M) {
                answer = mid;
                l = mid+1;
            }

        }

        return answer <= mid ? mid : answer;

    }

}
