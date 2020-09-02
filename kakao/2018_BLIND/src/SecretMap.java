import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] solution = solution(n, arr1, arr2);

        System.out.println(Arrays.stream(solution).iterator());
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;

        StringBuilder sb = new StringBuilder();
        String[] map = new String[n];

        for(int i = 0; i < n; i++) {
            getBinary(n,arr1[i]|arr2[i],sb);
            map[i] = sb.reverse().toString().replaceAll("1","#").replaceAll("0", " ");
            sb.setLength(0);
        }

        answer = map;

        return answer;
    }

    static void getBinary(int n,int a, StringBuilder sb){
        int j = a;
        for(int i = 0; i < n; i++){
            sb.append(j%2);
            j =  j/2;
        }
    }


}
