import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<User> users = new ArrayList<User>();
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            User user = new User(i, age,s[1]);
            users.add(user);
        }

        Collections.sort(users, new Comparator<User>() {
            public int compare(User o1, User o2) {
                if(o1.age > o2.age) {
                    return 1;
                } else if(o1.age < o2.age) {
                    return -1;
                } else {
                    if(o1.index > o2.index) {
                        return 1;
                    } else if(o1.index < o2.index) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        StringBuilder st = new StringBuilder();
        for(User user : users) {
            st.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.println(st);
    }

    static class User {
        int index;
        int age;
        String name;

        public User(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
