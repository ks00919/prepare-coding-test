import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [S4] 백준 10773 제로
 * 메모리 : 20248KB
 * 시간 : 176ms
 * 코드 길이 : 770B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10773">
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 배열, 변수로 스택 구현 (LIFO)
        int[] stack = new int[k];
        int cursor = 0;

        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());
            // 입력 숫자가 0이고 cursor가 양수일때 (ArrayOutOfBoundsException 방지)
            if (number == 0 && cursor > 0) {
                // 0을 제외한 가장 최근에 입력받은 숫자 제거
                stack[--cursor] = 0;
                continue;
            }
            // cursor index에 숫자 저장
            stack[cursor++] = number;
        }

        // 저장한 숫자 합계 출력
        int sum = 0;
        for (int number : stack) {
            sum += number;
        }
        System.out.println(sum);
    }
}
