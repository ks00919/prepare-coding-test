import java.util.Scanner;

/**
 * [B5] 백준 10430 나머지
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10430">
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		StringBuilder sb = new StringBuilder();
		sb.append((a + b) % c).append('\n');
		sb.append(((a % c) + (b % c)) % c).append('\n');
		sb.append((a * b) % c).append('\n');
		sb.append(((a % c) * (b % c)) % c);

		System.out.println(sb);
	}
}
