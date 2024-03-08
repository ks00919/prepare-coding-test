import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S5] 백준 10814 나이순 정렬
 * 메모리 : 59148KB
 * 시간 : 540ms
 * 코드 길이 : 1187B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10814">
 */
public class Main {

    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return new StringBuilder().append(age).append(" ").append(name).toString();
        }

        @Override
        public int compareTo(Main.Person o) {
            return age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        Person[] list = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i] = new Person(parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }
}
