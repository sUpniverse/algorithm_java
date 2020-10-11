import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nowListening {

    public static void main(String[] args) {
        String song = solution("ABCDEFG", new String[]{"04:00,04:02,ZERO,ACC","12:00,12:14,HELLO,CDEFGAB"});

        System.out.println(song);

    }

    static String solution(String m, String[] musicinfos) {

        List<Song> songList = new ArrayList<>();

        for(String a :musicinfos) {
            String[] split = a.split(",");
            String[] t1 = split[0].split(":");
            String[] t2 = split[1].split(":");

            int start = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
            int end = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);
            songList.add(new Song(start,end,split[2],split[3]));
        }

        List<Song> candidate = new ArrayList<>();

        for(int i = 0; i < songList.size(); i++) {
            Song song = songList.get(i);
            int size = (song.end-song.start);
            String[] codeSplit = song.code.split("");
            List<String> codeList = new ArrayList<>();
            for(int k = 0; k < codeSplit.length; k++) {
                if(k+1 < codeSplit.length && codeSplit[k+1].equals("#")){
                    codeList.add(codeSplit[k]+codeSplit[k+1]);
                    k++;
                    continue;
                }
                codeList.add(codeSplit[k]);
            }
            if(size > codeList.size()) {
                String code ="";
                int q = m.length() / codeList.size();
                for(int j = 0; j < q+1; j++) {
                    code += song.code;
                }
                if(code.contains(m))
                    candidate.add(song);
            } else {
                String code = "";
                for(int j = 0; j < size; j++)
                    code += codeList.get(j);
                if(code.contains(m))
                    candidate.add(song);
            }
        }
        if(candidate.isEmpty()) return "(None)";

        Collections.sort(candidate);

        return candidate.get(0).title;
    }

    static class Song implements Comparable<Song>{
        int start;
        int end;
        String title;
        String code;

        public Song(int start, int end, String title, String code) {
            this.start = start;
            this.end = end;
            this.title = title;
            this.code = code;
        }

        @Override
        public int compareTo(Song song) {
            return (song.end - song.start) - (this.end - this.start) ;
        }
    }


}
