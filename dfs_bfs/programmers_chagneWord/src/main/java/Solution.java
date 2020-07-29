import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        String[] words2 = {"hot","dot","dog","lot"};
        System.out.println(solution(begin, target, words));
    }

    static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Group> queue = new LinkedList<>();
        queue.add(new Group(begin,0));
        boolean[] check  = new boolean[words.length];

        int same = 0;
        for(int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) {
                same++;
            }
        }
        if(same == 0) return 0;

        while(!queue.isEmpty()) {
            Group word = queue.remove();
            for(int i = 0; i < words.length; i++) {
                if(!check[i]) {
                    String[] wordSplit = word.title.split("");
                    String[] wordsSplit = words[i].split("");
                    int count = 0;
                    for(int j = 0; j < word.title.length(); j++) {
                        if(wordSplit[j].equals(wordsSplit[j])) {
                            count++;
                        }
                    }
                    if(count == (word.title.length()-1)) {
                        if(words[i].equals(target)) {
                            return word.count+1;
                        }
                        check[i] = true;
                        queue.add(new Group(words[i],word.count+1));
                    }
                }
            }
        }

        return 0;
    }

    static class Group {
        String title;
        int count;

        public Group(String title, int count) {
            this.title = title;
            this.count = count;
        }
    }

}
