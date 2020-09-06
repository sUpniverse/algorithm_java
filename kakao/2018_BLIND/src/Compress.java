import java.util.ArrayList;
import java.util.List;

public class Compress {

    public static void main(String[] args) {
        int[] kakaos = solution("ABABABABABABABAB");

        for(int i = 0; i < kakaos.length; i++) {
            System.out.println(kakaos[i]);
        }

    }

    public static int[] solution(String msg) {

        List<String> dictionary = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        msg += "#";

        for(int i = 0; i < 26; i++) {
            char a = (char) (i+65);
            dictionary.add(String.valueOf(a));
        }

        int count;
        for(int i = 0; i < msg.length(); i+=count) {
            int j = 1;
            count = 0;
            while (i+j < msg.length() && dictionary.contains(msg.substring(i, i+j))){
                j++;
            }
            String substring = msg.substring(i, i + j);
            if(substring.equals("#"))
                break;
            if(substring.length() > 1){
                dictionary.add(substring);
                indexList.add(dictionary.indexOf(substring.substring(0,substring.length()-1))+1);
                count+=j-1;
            } else {
                indexList.add(substring.charAt(0) - 64);
                count++;
            }
        }


        int[] answer = new int[indexList.size()];
        for(int i = 0 ; i < indexList.size(); i++) {
            answer[i] = indexList.get(i);
        }

        return answer;
    }



}
