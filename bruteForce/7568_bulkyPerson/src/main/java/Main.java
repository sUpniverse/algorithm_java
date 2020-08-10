import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Person> people = new ArrayList<Person>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                Person one = people.get(i);
                Person two = people.get(j);

                if(one.weight > two.weight && one.height > two.height)
                    two.rank++;
                else if(one.weight < two.weight && one.height < two.height)
                    one.rank++;

            }
        }

        StringBuilder sb = new StringBuilder();

        for(Person person : people)
            sb.append(person.rank+1).append(" ");

        System.out.println(sb);
    }

    private static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
