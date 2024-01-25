import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 6603 로또
 * 메모리 : 12300KB
 * 시간 : 84ms
 * 코드 길이 : 1544B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/6603">
 */
class Main {

    // 백 트래킹

    /** 출력 문자열 저장 */
    public static StringBuilder sb = new StringBuilder();
    /** 탐색한 번호 저장 배열, 로또 번호 6자리 */
    public static int[] lotto = new int[6];
    /** 입력받은 숫자 저장 */
    public static int[] numbers;
    /** 사용 여부 체크 */
    public static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        System.out.println("test");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 선택 가능 숫자 개수 입력
            int k = Integer.parseInt(st.nextToken());
            // 0이면 종료
            if (k == 0) {
                break;
            }
            // 배열 초기화
            numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            isUsed = new boolean[k];
            // 재귀함수 실행
            solution(0, 0);
            // 개행 문자 출력
            sb.append('\n');
        }
        // 결과 출력
        System.out.println(sb);
    }

    // 깊이, 시작 숫자 매개변수
    public static void solution(int depth, int number) {
        // 만약 깊이가 6이라면 현재 배열 결과값 문자열로 저장
        if (depth == 6) {
            for (int n : lotto) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 시작 숫자부터 끝 숫자까지 탐색
        for (int i = number; i < isUsed.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                lotto[depth] = numbers[i];
                solution(depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}
