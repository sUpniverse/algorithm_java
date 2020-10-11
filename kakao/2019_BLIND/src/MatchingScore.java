import java.util.ArrayList;
import java.util.List;

public class MatchingScore {

    public static void main(String[] args) {
        solution("blind",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});

    }

    static int solution(String word, String[] pages) {

        List<WebPage> webPageList = new ArrayList<>();
        for(int i = 0; i < pages.length; i++){
            String[] split = pages[i].split("\n");
            webPageList.add(new WebPage(word,split));
        }

        int answer = 0;
        return answer;
    }

    static class WebPage{
        double baseScore;
        double linkScore;
        int  externalLinkCount;
        double matchingScore;
        String[] html;
        String myLink;

        public WebPage(String word,String[] html) {
            this.html = html;
            setBaseScore(word);
            setMyLink();
            setExternalLinkCount();
            setLinkScore();
        }


        public void setBaseScore(String word) {
            baseScore = 0;
            for(int i = 0; i < this.html.length; i++) {
                String low = this.html[i].toLowerCase();
                if(low.contains(word.toLowerCase())){
                    int index = low.indexOf(word.toLowerCase());
                    while (index != -1) {

                    }
                }
            }
        }

        public void setMyLink() {
            for(int i = 0; i < this.html.length; i++) {
                if(this.html[i].contains("<meta")){
                    if(this.html[i].contains("<meta property=\"og:url\" content=\"")) {
                        String[] split = this.html[i].split("<meta property=\"og:url\" content=\"");
                        for(String t : split)
                            if(t.contains("https://"))
                                this.myLink = t.substring(0,t.length()-3);
                    }
                }
            }
        }

        public void setExternalLinkCount() {
            for(int i = 0; i < this.html.length; i++) {
                if(this.html[i].contains("<body")) {
                    if(this.html[i].contains("<a href=\"")){
                        String[] split = this.html[i].split("<a href=\"");
                        for(int j = 0; j < split.length; j++) {
                            if(split[j].contains("https://")){
                                this.externalLinkCount++;

                            }
                        }
                    }
                }
            }
        }

        public double setLinkScore() {
            return this.baseScore / externalLinkCount;
        }
    }
}
