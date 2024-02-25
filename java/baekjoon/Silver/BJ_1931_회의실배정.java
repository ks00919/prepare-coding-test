import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [S1] 백준 1931 회의실 배정
 * 메모리 : 42124KB
 * 시간 : 440ms
 * 코드 길이 : 1189B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1931">
 */
public class Main {

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            // 종료 기준 오름차순 정렬, 종료 시간 같다면 시작 시간으로 오름차순 정렬
            return this.end - o.end == 0 ? this.start - o.start : this.end - o.end;
        }
    }

    // 그리디 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        Time[] schedule = new Time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i] = new Time(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }
        Arrays.sort(schedule);

        int count = 1;
        Time last = schedule[0];
        for (int i = 1; i < N; i++) {
            if (last.end <= schedule[i].start) {
                count++;
                last = schedule[i];
            }
        }
        System.out.println(count);
    }
}