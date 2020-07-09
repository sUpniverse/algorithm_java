public class Main {

    public static void main(String[] args) {
        int[] pr = {1, 2, 3, 2, 3};

        int[] solution = solution(pr);

        for(int i = 0 ; i < solution.length; i++)
            System.out.print(solution[i]+" ");


    }

    static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length-1; i++) {
            for(int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }


        return answer;
    }


}
