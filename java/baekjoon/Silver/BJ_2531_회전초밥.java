import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

/**
 * [S1] 백준 2531 회전 초밥
 * 메모리 : 296952KB
 * 시간 : 2632ms
 * 코드 길이 : 1770B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2531">
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = parseInt(st.nextToken()); // 초밥의 가짓수
        int k = parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = parseInt(st.nextToken()); // 쿠폰 번호 c

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = parseInt(br.readLine());
        }

        // HashSet으로 중복 제거
        Set<Integer> set = new HashSet<>();
        set.add(c);

        // 0번째 인덱스부터 연속해서 먹는 접시 수 만큼 넣기
        for (int i = 0; i < k; i++) {
            set.add(belt[i]);
        }
        // 최댓값 초기값
        int max = count(set, c);

        for (int i = 1; i < N; i++) {
            // 만약 먹을 수 있는 가짓수의 최댓값이 초밥의 가짓수와 같다면 종료
            if (max == d) {
                break;
            }
            // 이전 시작점 초밥 제거
            set.remove(belt[i - 1]);

            // 연속으로 먹을 수 있는 초밥 set에 추가
            int end = i + k - 1;
            for (int j = i; j < N && j <= end; j++) {
                set.add(belt[j]);
            }

            // 마지막 초밥이 인덱스 초과하면 처음으로 돌아가서 추가
            if (end >= N) {
                end -= N;
                for (int j = 0; j <= end; j++) {
                    set.add(belt[j]);
                }
            }

            max = Math.max(max, count(set, c));
        }

        // 최대값 출력
        System.out.println(max);
    }

    // 만약 고른 초밥 중에 쿠폰 제공 초밥이 있다면 가짓수 = set의 크기
    // 아니라면 set의 크기 + 쿠폰 제공 초밥
    public static int count(Set<Integer> set, int c) {
        if (set.contains(c)) {
            return set.size();
        }
        return set.size() + 1;
    }

}