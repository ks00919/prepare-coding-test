import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G4] 백준 15961 회전 초밥
 * 메모리 : 168520KB
 * 시간 : 572ms
 * 코드 길이 : 1463B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15961">
 */
class Main {

    // 슬라이딩 윈도우 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = parseInt(st.nextToken()); // 초밥의 가짓수
        int k = parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = parseInt(st.nextToken()); // 쿠폰 번호 c

        // 회전 초밥 벨트에 있는 초밥 저장 배열
        int[] belt = new int[N];
        // 각 초밥 종류 별로 선택 개수 저장 배열
        int[] sushi = new int[d + 1];
        // 입력값 저장
        for (int i = 0; i < N; i++) {
            belt[i] = parseInt(br.readLine());
        }

        // 종류 가짓수 세기
        int count = 0;
        for (int i = 0; i < k; i++) {
            // 현재 선택 벨트의 초밥이 선택된 횟수가 0이라면 가짓수 증가, 선택 개수 증가
            if (sushi[belt[i]]++ == 0)
                count++;
        }

        // 만약 선택한 종류 중에 쿠폰 초밥이 포함되어 있지 않다면 가짓수 1 증가
        int max = sushi[c] == 0 ? count + 1 : count;

        for (int i = 1; i < N; i++) {
            // 범위에서 벗어난 초밥이 중복이 아닐때 가짓수 감소
            if (--sushi[belt[i - 1]] == 0)
                count--;

            // 범위의 새로 들어온 마지막 초밥 추가
            int end = (i + k - 1) % N;

            // 선택된 적이 없다면 가짓수 증가
            if (sushi[belt[end]]++ == 0)
                count++;

            // 선택한 종류 중에 쿠폰 초밥이 포함되어있는지 확인
            if (sushi[c] == 0)
                max = Math.max(max, count + 1);
            else
                max = Math.max(max, count);
        }
        // 최대 가짓수 출력
        System.out.println(max);
    }

}