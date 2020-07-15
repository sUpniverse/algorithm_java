import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            inOrder.add(Integer.parseInt(st.nextToken()));

        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            postOrder.add(Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        preOrder(inOrder, postOrder, sb);

        System.out.println(sb);


    }


    static void preOrder(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, StringBuilder sb) {

        if(inOrder.isEmpty()) {
            return;
        }


        int size = postOrder.size();
        int root = postOrder.get(size - 1);
        int mid = 0;
        for(int i = 0; i < inOrder.size(); i++) {
            if(root == inOrder.get(i)) {
                mid = i;
                break;
            }

        }

        int right = mid;
        int R = 0;
        if(inOrder.size() >  mid + 1) {
            R = inOrder.get(mid + 1);
            for(int i = 0; i < postOrder.size(); i++) {
                if(R == postOrder.get(i)) {
                    right = i;
                    break;
                }
            }
        }


        sb.append(root).append(" ");
        preOrder(slice(inOrder,0,mid), slice(postOrder, 0, right),sb);
        preOrder(slice(inOrder,mid+1, size), slice(postOrder, right, size-1),sb);

    }

    static ArrayList<Integer> slice(ArrayList<Integer> origin,int a, int b) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = a; i < b; i++) {
            arrayList.add(origin.get(i));
        }

        return arrayList;
    }

}
