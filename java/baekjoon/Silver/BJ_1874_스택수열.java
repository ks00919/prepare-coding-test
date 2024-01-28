import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [S2] 백준 1874 스택 수열
 * 메모리 : 27408KB
 * 시간 : 284ms
 * 코드 길이 : 836B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1874">
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        // 스택 자료형 사용
        Stack<Integer> stack = new Stack<>();

        // 오름차순으로 push
        int cursor = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (cursor < number) {
                // 입력된 수만큼 push
                for (int j = cursor + 1; j <= number; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                // 마지막에 넣은 수 저장
                cursor = number;
                // 스택이 비어있지 않고 마지막에 들어간 수가 입력된 수가 아니라면 만들 수 없는 수
            } else if (!stack.isEmpty() && stack.peek() != number) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            // pop
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}