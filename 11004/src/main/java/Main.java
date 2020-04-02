import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        System.out.print(arr[k - 1]);
    }

    public static void solution1(int[] arr,int n,int k) {
        quickSort(arr,0,n-1,k);
    }

    public static void solution2(int[] arr) {
        Arrays.sort(arr);
    }

    public static void quickSort(int[] arr,int l,int r, int k) {
        if(l < r) {
            int t = partition(arr, l, r);
            if(t == k) {
                return;
            } else if(t > k) {
                quickSort(arr, l, t-1,k);
            } else if(t < k) {
                quickSort(arr, t+1,r,k);
            }
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l-1;

        for(int j = l; j <= r-1; j++) {
            if(arr[j] <= arr[r]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    public static void swap(int[] arr,int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
