import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S2] 백준 17829 222-풀링
 * 메모리 : 145428KB
 * 시간 : 760ms
 * 코드길이 : 1513B
 */
public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        System.out.println(recursion(N, 0, 0));
    }

    // 분할정복 - 재귀
    public static int recursion(int size, int x, int y) {
        // 만약 배열 크기가 2 X 2일 때, 두번째로 큰 숫자 반환 (기저조건)
        if (size == 2) {
            return getSecondNumer(size, x, y);
        }

        // 2보다 크다면 배열을 4등분해서 재귀 호출
        size /= 2;
        int a = recursion(size, x, y);
        int b = recursion(size, x, y + size);
        int c = recursion(size, x + size, y);
        int d = recursion(size, x + size, y + size);

        // 4등분한 배열의 두번째로 큰 수 4개 중 두번째로 큰 수 반환
        return getSecondNumer(a, b, c, d);
    }

    public static int getSecondNumer(int size, int x, int y) {
        List<Integer> list = new ArrayList<>();

        int dx = x + size;
        int dy = y + size;

        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                list.add(map[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(2);
    }

    public static int getSecondNumer(int... numbers) {
        Arrays.sort(numbers);
        return numbers[2];
    }
}
