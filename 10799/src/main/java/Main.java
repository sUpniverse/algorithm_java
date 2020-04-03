import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        solution2();
    }

    public static void solution1() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                stack.push(i);
            } else {            // ')'라면
                if(stack.peek() == i-1) {  // 레이저 검사
                    stack.pop();
                    sum += stack.size();
                } else {        // 막대기의 끝
                    stack.pop();
                    sum++;
                }
            }
        }
        System.out.println(sum);

    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        int size = 0;
        int sum = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                if(chars[i+1] != ')')  size++;     // 레이저가 아니라 쇠막대기면
                else {      // 레이저이면
                    sum += size;
                }
            } else {        //')'나올 시
                if(chars[i-1] != '(') {     //레이저가 아니고 막대기의 끝
                    sum ++;
                    size--;
                }
            }
        }

        System.out.println(sum);
    }
}
