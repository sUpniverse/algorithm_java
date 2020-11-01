import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                queue.add(new Document(i,Integer.parseInt(st.nextToken())));
            }

            while (!queue.isEmpty()) {
                boolean flag = false;
                Document doc = queue.remove();
                Iterator<Document> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if(document.priority > doc.priority) {
                        flag  = true;
                        break;
                    }
                }
                if(flag) {
                    queue.add(doc);
                    continue;
                }
                count++;
                if(doc.index == M) {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
  
}
