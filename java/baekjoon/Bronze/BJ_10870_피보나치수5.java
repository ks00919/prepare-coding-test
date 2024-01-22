import java.util.Scanner;

/**
 * [B2] 백준 10870 피보나치 수 5 
 * 메모리 : 12880KB 
 * 시간 : 112ms 
 * 코드 길이 : 318B
 */
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 출력
		System.out.println(fibonacci(sc.nextInt()));
		sc.close();
	}

	public static int fibonacci(int n) {
		// F0 = 0, F1 = 1
		if (n == 0 || n == 1)
			return n;
		// Fn = F_n-1 + F_n-2
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
