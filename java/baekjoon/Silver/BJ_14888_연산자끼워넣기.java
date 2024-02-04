import static java.lang.Integer.*;
import java.util.*;
import java.io.*;

/**
 * [S1] 백준 14888 연산자 끼워넣기
 * 메모리 : 13420
 * 시간 : 80ms
 * 코드 길이 : 1738B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/14888">
 */
class Main {

    // 입력 숫자 배열 저장
    static int[] numbers;
    // 연산자 개수 저장
    static int[] operators = new int[4];

    // 결과 변수 초기화
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());

        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = parseInt(st.nextToken());
        }

        // 처음 결과를 숫자 맨 첫번째로 초기화하고 depth 1
        solution(n, numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    // n개의 숫자, 계산 결과, 숫자 선택 개수
    public static void solution(int n, int result, int depth) {
        if (depth == n) {
            // 숫자를 다 선택했다면 결과값 비교
            if (result > max) {
                max = result;
            }
            if (result < min) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 선택할 수 있는 연산자가 있을때
            if (operators[i] > 0) {
                // 사용했으니까 1 감소
                operators[i]--;
                if (i == 0)
                    // 다음 숫자와 계산
                    solution(n, result + numbers[depth], depth + 1);
                else if (i == 1)
                    solution(n, result - numbers[depth], depth + 1);
                else if (i == 2) {
                    solution(n, result * numbers[depth], depth + 1);
                } else if (i == 3)
                    solution(n, result / numbers[depth], depth + 1);
                // 다음 숫자 선택 후 다시 돌아오니까 선택 횟수 + 1
                operators[i]++;
            }
        }
    }
}
