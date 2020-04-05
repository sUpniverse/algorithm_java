import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution1 {

    static  int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        char[] chars = st.toCharArray();


        int[] list = new int[4];
        for(int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case '(':
                    list[0]++;
                    break;
                case ')':
                    getCount(list,0);
                    break;
                case '{':
                    list[1]++;
                    break;
                case '}':
                    getCount(list,1);
                    break;
                case '[':
                    list[2]++;
                    break;
                case  ']':
                    getCount(list,2);
                    break;
                case '<':
                    list[3]++;
                    break;
                case '>':
                    getCount(list,3);
                    break;
                default:
                    break;
            }
            if(count == -1) {
                break;
            }
        }
        System.out.println(count);
    }

    private static void getCount(int[] list,int index) {
        if(list[index] > 0) {
            list[index]--;
            count++;
        } else {
            count = -1;
        }
    }

}
