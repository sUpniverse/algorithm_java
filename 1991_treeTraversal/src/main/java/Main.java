import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[] arrays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrays = new char[67108863];
        arrays[0] = st.nextToken().charAt(0);
        arrays[1] = st.nextToken().charAt(0);
        arrays[2] = st.nextToken().charAt(0);
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0);
            for(int j = 0; j < 26; j++) {
                if(a == arrays[j]) {
                    arrays[(2*j)+1] = st.nextToken().charAt(0);
                    arrays[(2*j)+2] = st.nextToken().charAt(0);
                    break;
                }
            }
        }

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();
        preOrder(0, pre);
        inOrder(0, in);
        postOrder(0, post);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }

    static void preOrder(int index,StringBuilder st) {
        if( index >= 67108863 || arrays[index] == '.') {
            return ;
        }
        st.append(arrays[index]);
        preOrder((2*index)+1,st);
        preOrder((2*index)+2,st);
    }

    static void inOrder(int index,StringBuilder st) {
        if( index >= 67108863 || arrays[index] == '.') {
            return ;
        }
        inOrder((2*index)+1,st);
        st.append(arrays[index]);
        inOrder((2*index)+2,st);
    }

    static void postOrder(int index,StringBuilder st) {
        if( index >= 67108863 || arrays[index] == '.') {
            return ;
        }
        postOrder((2*index)+1,st);
        postOrder((2*index)+2,st);
        st.append(arrays[index]);
    }

}
