import java.util.Scanner;

/**
 * [S5] 백준 17478 재귀함수가 뭔가요?
 * 메모리 : 13252KB
 * 시간 : 112ms
 * 코드 길이 : 1313B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17478">
 */
class Main {

	public static StringBuilder sb = new StringBuilder();
	public static int n;

	public static void main(String[] args) {
		// 재귀횟수 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 첫 문장 출력
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		// 재귀함수 호출
		recursion(0);
		// 결과 출력
		System.out.println(sb);
	}

	// 0, 1, 2, 3, 4 .... n까지 반복
	public static void recursion(int count) {

		StringBuilder blank = new StringBuilder();
		// 4n만큼 _ 출력
		for (int i = 0; i < count * 4; i++) {
			blank.append("_");
		}

		sb.append(blank).append("\"재귀함수가 뭔가요?\"\n");
		if (count == n) {
			// 마지막 답변 출력
			sb.append(blank).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(blank).append("라고 답변하였지.\n");
			return;
		}

		sb.append(blank).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(blank).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(blank).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		// 재귀 호출
		recursion(count + 1);
		// 재귀 호출 후 마지막 문장 출력
		sb.append(blank).append("라고 답변하였지.\n");
	}
}
