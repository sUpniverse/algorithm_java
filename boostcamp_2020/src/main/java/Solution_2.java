import java.util.ArrayList;

public class Solution_2 {

    static int MAX_VALUE = 1000000;

    public static void main(String[] args) {
        int[][] sol_1 = {{1,2,3,2},{1,3}};
        int[][] sol_2 = {{2,3,4,3,5},{1,6,7}};

        int[] solution = solution(sol_1[0], sol_1[1]);
        for(int i = 0; i < solution.length; i++)
            System.out.println(solution[i]);

        int[] solution2 = solution(sol_2[0], sol_2[1]);
        for(int i = 0; i < solution2.length; i++)
            System.out.println(solution2[i]);


    }

    static int[] solution(int[] arrayA, int[] arrayB) {
        int[] answer =  new int[5];

        ArrayList arrayListA = removeDuplication(arrayA);
        ArrayList arrayListB = removeDuplication(arrayB);

        answer[0] = arrayListA.size();
        answer[1] = arrayListB.size();
        answer[2] = sum(arrayListA, arrayListB).size();
        answer[3] = complement(arrayListA, arrayListB).size();
        answer[4] = intersect(arrayListA, arrayListB).size();

        return answer;
    }

    static ArrayList removeDuplication(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList();

        for(int i = 0; i < array.length; i++)
            arrayList.add(array[i]);

        for(int i = 0; i < arrayList.size()-1; i++) {
            int a = arrayList.get(i);
            for(int j = i+1; j < arrayList.size(); j++) {
                if(a == arrayList.get(j))
                    arrayList.remove(j);
            }
        }

        return arrayList;
    }

    static ArrayList sum(ArrayList<Integer> a, ArrayList<Integer> b) {
        boolean[] check = new boolean[MAX_VALUE];

        for(int num : a)
            check[num]  = true;

        for(int num : b)
            check[num]  = true;

        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < MAX_VALUE; i++) {
            if(check[i])
                arrayList.add(i);
        }

        return arrayList;
    }

    static ArrayList complement(ArrayList<Integer> a, ArrayList<Integer> b) {
        boolean[] check = new boolean[MAX_VALUE];

        for(int num : a)
            check[num]  = true;

        for(int num : b) {
            check[num]  = false;
        }

        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < MAX_VALUE; i++) {
            if(check[i])
                arrayList.add(i);
        }

        return arrayList;
    }

    static ArrayList intersect(ArrayList<Integer> a, ArrayList<Integer> b) {
        int[] check = new int[MAX_VALUE];

        for(int num : a)
            check[num]++;

        for(int num : b) {
            check[num]++;
        }

        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < MAX_VALUE; i++) {
            if(check[i] > 1)
                arrayList.add(i);
        }

        return arrayList;
    }

}
