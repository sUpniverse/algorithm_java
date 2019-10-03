import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int[] arr;

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//        //selection sort
//        for(int i = 0; i < n; i++) {
//            int temp = 0;
//            for(int j = i; j < n; j++) {
//                if(arr[i] > arr[j]) {
//                    temp = arr[j];
//                    arr[j] =  arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }

//        //bubble sort
//        for(int i =0; i < n; i++) {
//            int temp = 0;
//            for(int j = 0; j < n-1-i; j++) {
//                if(arr[j] > arr[j+1]) {
//                    temp = arr[j+1];
//                    arr[j+1] =  arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }


    }

}


