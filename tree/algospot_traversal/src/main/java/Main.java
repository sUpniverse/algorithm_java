import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> preOrder = new ArrayList<Integer>();
            for(int i = 0; i < size; i++)
                preOrder.add(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> inOrder = new ArrayList<Integer>();
            for(int i = 0; i < size; i++)
                inOrder.add(Integer.parseInt(st.nextToken()));

            printPostOrder(preOrder, inOrder);
            System.out.println();
        }
    }

    static void printPostOrder(ArrayList<Integer> preOrder,ArrayList<Integer> inOrder) {
        int n = preOrder.size();

        if(preOrder.isEmpty()) return;

        int root = preOrder.get(0);

        int L = 0;
        for(int i = 0; i < n; i++) {        // preOrder상에서의 root을 이용해 inOrder상의 위치를 찾으면 해당 위 이하의 수들은 모두 왼쪽 서브트리이다.
            if(root == inOrder.get(i)) {
                L = i;
                break;
            }
        }

        int R = n - 1 - L;      // 오른쪽 서브트리의 루트노드의 인덱스

        printPostOrder(slice(preOrder,1,L+1), slice(inOrder,0,L));
        printPostOrder(slice(preOrder,L+1,n), slice(inOrder,L+1,n));

        System.out.print(root+" ");
    }
    static ArrayList<Integer> slice(ArrayList<Integer> list, int start, int end) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        for(int i = start; i < end; i++)
            array.add(list.get(i));

        return array;
    }

}
