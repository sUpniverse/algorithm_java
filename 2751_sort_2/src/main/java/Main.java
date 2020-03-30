import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[2000001]; // 절대 값 -1000000 ~ 1000000

        //입력시에 해당하는 수 + 1000000 번째에 해당하는 배열에 true를 입력
        for(int i=0; i < n; i++) {
            array[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for(int i =0 ; i < array.length; i++) {
            if(array[i]) {
                stringBuilder.append((i-1000000) + "\n");
            }
        }
        System.out.println(stringBuilder);


//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++){
//            arr.add(Integer.parseInt(br.readLine()));
//        }
//        Collections.sort(arr);
//        for (int i = 0; i < arr.size(); i++){
//            System.out.println(arr.get(i));
//        }

//        //quick sort
//        quickSort(arr,0,n-1);

    }

    public static void quickSort(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int pivot = (left+right) / 2;

        do {
            while(arr[left] < arr[pivot])
                left++;
            while(arr[right] > arr[pivot])
                right--;

            if(left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while(left <= right);

        if(l < right) {
            quickSort(arr, l, right);
        }

        if(left < r) {
            quickSort(arr, left, r);
        }
    }

}


