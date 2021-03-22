public class Main {

  static int[] array = {3,4,7,6,5,2,9};

  public static void main(String[] args) {
    quicksort(0, array.length-1);
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i]+" ");
    }
  }

  public static void quicksort(int start, int end) {
    if(start >= end)
      return;

    int pivot = start;
    int i = start+1;
    int j = end;
    int temp;

    while (i <= j) {
      while (array[pivot] >= array[i] && i <= end) {
        i++;
      }

      while (array[pivot] <= array[j] && j > start) {
        j--;
      }

      if(i > j) {
        temp = array[j];
        array[j] = array[pivot];
        array[pivot] = temp;
      } else {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    quicksort(start, j-1);
    quicksort(j+1, end);
  }

}
