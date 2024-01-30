import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [B1] 백준 10989 수 정렬하기 3
 * 메모리 : 507820KB
 * 시간 : 2376ms
 * 코드 길이 : 596B
 * 
 * @author 김민주
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// List를 쓰게 되면 주어진 조건의 범위가 크기 때문에 메모리 초과 발생!!
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		StringBuilder sb = new StringBuilder();
		for (int number : array) {
			sb.append(number).append('\n');
		}

		System.out.println(sb);
	}
}
