import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] switchs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = parseInt(br.readLine());
		switchs = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			switchs[i] = parseInt(st.nextToken());
		}

		int studentNumber = parseInt(br.readLine());
		for (int i = 0; i < studentNumber; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if (st.nextToken().equals("1")) {
				boy(parseInt(st.nextToken()));
			} else {
				girl(parseInt(st.nextToken()));
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(switchs[i]).append(' ');
			if ((i + 1) % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	public static void boy(int number) {
		for (int i = 1; i < switchs.length; i *= number) {
			switchs[i] = switchs[i] == 0 ? 1 : 0;
		}
	}

	public static void girl(int number) {
		int index = number;
		int count = 1;
		for (int i = 1; number - i >= 0 && number + i < switchs.length; i++) {
			if (switchs[number + i] != switchs[number - i]) {
				break;
			}
			index -= 1;
			count += 2;
		}

		for (int i = index; i <= count; i++) {
			switchs[i] = switchs[i] == 0 ? 1 : 0;
		}
	}
}
