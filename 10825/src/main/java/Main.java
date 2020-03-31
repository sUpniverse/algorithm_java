import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String[] s = br.readLine().split(" ");
            Student student = new Student(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
            students.add(student);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.kor > s2.kor) {
                    return -1;
                } else if(s1.kor < s2.kor) {
                    return 1;
                } else {
                    if(s1.eng > s2.eng) {
                        return 1;
                    } else if(s1.eng < s2.eng) {
                        return -1;
                    } else {
                        if(s1.math > s2.math) {
                            return -1;
                        } else if(s1.math < s2.math) {
                            return 1;
                        } else {
                            int i = s1.name.compareTo(s2.name);
                            if(i > 0) {
                                return 1;
                            } else if (i < 0){
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });

        StringBuilder st = new StringBuilder();
        for(Student student : students) {
            st.append(student.name).append("\n");
        }

        System.out.println(st);
    }

    static class Student{
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKor() {
            return kor;
        }

        public void setKor(int kor) {
            this.kor = kor;
        }

        public int getEng() {
            return eng;
        }

        public void setEng(int eng) {
            this.eng = eng;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }
    }
}
