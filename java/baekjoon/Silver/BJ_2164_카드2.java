import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [S4] 백준 2163 카드2 
 * 메모리 : 23840KB
 * 시간 : 124ms
 * 코드 길이 : 545B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2164">
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
      // 카드 초기화
			q.add(i);
		}

		while (q.size() != 1) {
      // 맨 위 카드 한 장 버리기
			q.poll();
      // 버리고 난 후에 맨 위에 있는 카드 한 장 카드 밑으로 옮기기
			q.add(q.poll());
		}
    // 마지막 남은 카드 출력
		System.out.println(q.poll());
	}
}
