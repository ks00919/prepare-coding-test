import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S1] 백준 13335 트럭
 * 메모리 : 11988KB
 * 시간 : 104ms
 * 코드 길이 : 1393B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/13335"/>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초기 다리 값
        int n = parseInt(st.nextToken());
        int w = parseInt(st.nextToken());
        int L = parseInt(st.nextToken());

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        // 다리의 길이만큼 미리 0으로 채워두기
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int weight = 0;
        // 한 번 반복할 때마다 단위시간 1증가
        while (!bridge.isEmpty()) {
            time++;
            weight -= bridge.poll();

            if (trucks.isEmpty())
                continue;

            // 새로운 트럭의 무게가 들어올 수 있다면 추가
            if (weight + trucks.peek() <= L) {
                weight += trucks.peek();
                bridge.add(trucks.poll());
            } else {
                // 만약 새로운 트럭이 들어올 수 없다면 0 추가
                bridge.add(0);
            }
        }
        System.out.println(time);
    }
}
