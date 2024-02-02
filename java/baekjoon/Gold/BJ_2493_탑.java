import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G5] 백준 2493 탑
 * 메모리 : 165184KB
 * 시간 : 920ms
 * 코드 길이 : 981B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2493">
 */
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int tower = parseInt(st.nextToken());
            map.put(tower, i);

            // 스택에 비어있지 않고 top이 tower보다 작을때 top 제거(영원히 수신할 수 없는 탑)
            while (!stack.isEmpty() && stack.peek() < tower) {
                stack.pop();
            }

            // 만약 수신할 수 있는 탑이 하나도 남지 않았다면 0 저장
            if (stack.isEmpty()) {
                sb.append(0).append(' ');
            } else {
                // 수신받을 수 있는 탑의 순서 저장
                sb.append(map.get(stack.peek())).append(' ');
            }
            // 현재 탑 스택에 push
            stack.push(tower);
        }
        // 결과 출력
        System.out.println(sb);
    }

}