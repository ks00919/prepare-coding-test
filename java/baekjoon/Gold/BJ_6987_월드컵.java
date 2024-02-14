import static java.lang.Integer.*;
import java.util.*;
import java.io.*;

/**
 * [G4] 백준 6987 월드컵
 * 메모리 : 11572KB
 * 시간 : 76ms
 * 코드 길이 : 2081B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/6987">
 */
class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean possible;

    // 승패무 횟수 저장
    static int[] win = new int[6];
    static int[] lose = new int[6];
    static int[] tie = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        // 테스트케이스 4개
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            possible = false;

            int total = 0;
            int w = 0;
            int t = 0;
            int l = 0;

            for (int j = 0; j < 6; j++) {
                w += win[j] = parseInt(st.nextToken());
                t += tie[j] = parseInt(st.nextToken());
                l += lose[j] = parseInt(st.nextToken());
                total += win[j] + tie[j] + lose[j];
            }
            // 전체 전적 합이 30, 승리 경기 수와 패배 경기 수 같을 때, 무승부 전적합 짝수
            if (total == 30 && w == l && t % 2 == 0)
                solution(1, 0, 1);
            // 현재 전적이 가능하다면 1 아니면 0 출력
            sb.append(possible ? 1 : 0).append(' ');
        }

        System.out.println(sb);
    }

    public static void solution(int round, int left, int right) {
        // 이미 가능한 경기를 찾았다면 더이상 진행하지 않음
        if (possible) {
            return;
        }
        // 탐색이 끝까지 갔다면 왼쪽팀 값 갱신
        if (right == 6) {
            solution(round, left + 1, left + 2);
        }

        // 전체 열릴 수 있는 모든 경기 수 만큼 탐색이 되었다면 가능한 전적
        if (round == 15) {
            possible = true;
            return;
        }

        // 왼쪽 팀이 이기고 오른쪽 팀이 졌을때
        if (win[left] > 0 && lose[right] > 0) {
            win[left]--;
            lose[right]--;
            solution(round + 1, left, right + 1);
            win[left]++;
            lose[right]++;
        }

        // 왼쪽 팀이 지고 오른쪽 팀이 이겼을때
        if (lose[left] > 0 && win[right] > 0) {
            lose[left]--;
            win[right]--;
            solution(round + 1, left, right + 1);
            lose[left]++;
            win[right]++;
        }

        // 무승부일때
        if (tie[left] > 0 && tie[right] > 0) {
            tie[left]--;
            tie[right]--;
            solution(round + 1, left, right + 1);
            tie[left]++;
            tie[right]++;
        }
    }
}