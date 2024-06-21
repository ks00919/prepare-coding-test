import java.util.Scanner;

/**
 * [B5] 백준 10430 나머지 
 * 메모리 : 12856KB
 * 시간 : 116ms
 * 코드 길이 : 462B
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
