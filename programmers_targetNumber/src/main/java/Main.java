public class Main {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers,target));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    static int dfs(int[] numbers, int target,int index, int num) {
        if(index == numbers.length) {
            if(num == target)
                return 1;
            return 0;
        }
        return dfs(numbers,target,index+1,num + numbers[index]) + dfs(numbers,target,index+1,num - numbers[index]);
    }
}
