import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String[] open = {"{","(","["};
    static String[] end = {"}",")","]"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {

            String[] split = br.readLine().split("");

            Stack<String> stack = new Stack<>();

            int size = split.length;
            boolean flag = true;

            for(int i = 0; i < size; i++) {
                if(isOpen(split[i]) >= 0) {
                    stack.add(split[i]);
                } else {
                    int endNum = isEnd(split[i]);
                    String peek = null;
                    if(!stack.isEmpty())
                        peek = stack.pop();

                    if(peek == null || !open[endNum].equals(peek)) {
                        flag = false;
                        break;
                    }
                }
            }

            if(!flag || stack.size() > 0) {
                sb.append("NO").append("\n");
                continue;
            }

            sb.append("YES").append("\n");

        }

        System.out.println(sb);

    }

    static int isOpen(String a) {
        int index = -1;
        for(int i = 0; i <3; i++) {
            if(open[i].equals(a))
                index = i;
        }

        return index;
    }

    static int isEnd(String a) {
        int index = -1;
        for(int i = 0; i <3; i++) {
            if(end[i].equals(a))
                index = i;
        }

        return index;
    }
}
