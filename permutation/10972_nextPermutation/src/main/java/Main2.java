import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        if(!nextPermutation(list)) {
            System.out.println(-1);
            return;
        }
        for(int i = 0; i <n; i++)
            sb.append(list[i] +" ");
        System.out.println(sb);

    }

    static boolean nextPermutation(int[] list) {
        int i = list.length-1;
        int j = list.length-1;

        while (i > 0 && list[i-1] >= list[i])
            i--;
        if(i <= 0) return false;


        while (list[i-1] >= list[j])
            j--;
        swap(i-1,j,list);

        j = list.length-1;
        while (i < j){
            swap(i, j, list);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j, int[] list) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
