import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingFileName {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"F13.png", "F14", "f013", "F014", "F013.TXT"});

        for(int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }

    static String[] solution(String[] files) {

        List<File> fileList = new ArrayList<>();

        for(String file :  files) {
            String[] split = file.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            for(int i = 3; i < split.length; i++)
                split[2] += split[i];
            if(split.length > 2)
                fileList.add(new File(split[0],split[1],split[2]));
            else
                fileList.add(new File(split[0],split[1],""));

        }
        Collections.sort(fileList);

        String[] answer = new String[fileList.size()];
        for(int i = 0; i < fileList.size(); i++) {
            answer[i] = String.valueOf(fileList.get(i));
        }

        return answer;
    }

    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File file) {
            String a = this.head.toLowerCase();
            String b = file.head.toLowerCase();
            if(a.equals(b)) {
                return Integer.parseInt(this.number) - Integer.parseInt(file.number);
            }
        return a.compareTo(b);
        }

        @Override
        public String toString() {
            return head+number+tail;
        }
    }
}
