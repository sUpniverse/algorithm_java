import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(array, command);

        for(int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]+",");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            answer[i]  = getSort(array, a, b, c);
        }
        return answer;
    }

    private static int getSort(int[] array, int a, int b, int c) {
        int[] conditionArray = new int[b-a+1];

        for(int i = 0; i < b-a+1; i++) {
            conditionArray[i] = array[a+i-1];
//          이렇게도 구현가능
//          conditionArray = Arrays.copyOfRange(array, a - 1, b);
        }
        Arrays.sort(conditionArray);
        return conditionArray[c-1];
    }

}
