import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S5] 백준 15235 Olympiad Pizza
 * 메모리 : 11960KB
 * 시간 : 96ms
 * 코드 길이 : 1189B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15235">
 */
public class Main {

    public static class Student {
        int wish;
        int number;

        public Student(int number, int wish) {
            this.number = number;
            this.wish = wish;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Student> q = new ArrayDeque<>();
        // 학생이 원하는 피자조각수와 학생 번호를 저장
        for (int i = 0; i < N; i++) {
            q.add(new Student(i, parseInt(st.nextToken())));
        }

        int time = 0;
        int[] total = new int[N];

        while (!q.isEmpty()) {
            Student curr = q.poll();
            time++;

            // 만약 원하는 수만큼 피자를 받았다면 현재 시간을 저장하고 넘기기
            if (--curr.wish == 0) {
                total[curr.number] = time;
                continue;
            }

            // 아니라면 다시 줄서기
            q.add(curr);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(total[i]).append(" ");
        }
        System.out.println(sb);
    }
}
