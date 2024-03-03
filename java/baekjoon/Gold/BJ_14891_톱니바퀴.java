import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G5] 백준 14891 톱니바퀴
 * 메모리 : 11748KB
 * 시간 : 84ms
 * 코드 길이 : 2423B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/14891">
 */
public class Main {

    // 톱니바퀴의 극을 저장하는 배열
    static int[][] gears;
    // 12시, 오른쪽, 왼쪽 순서대로 인덱스 저장
    static int[][] index;

    // 쉬운 구현인데 문제를 잘못 읽어서 틀렸다 반성하자!!!!!!
    // 방향에 맞춰 인덱스만 계산해주면 되는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new int[4][8];
        index = new int[4][3];

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();

            for (int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }

            // 입력 기준이 12시 방향부터이고 점수 산출도 12시다..^^ 문제를 잘 읽자..
            index[i][0] = 0;
            index[i][1] = 2;
            index[i][2] = 6;
        }

        int K = parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotate(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()));
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][index[i][0]] == 1)
                score += Math.pow(2, i);
        }
        System.out.println(score);
    }

    public static void rotate(int gearNumber, int direction) {
        int[][] change = new int[4][4];
        for (int i = 0; i < 4; i++) {
            change[i] = Arrays.copyOf(index[i], 4);
        }

        direction *= -1;
        int tmp = direction;
        for (int i = 0; i < 3; i++) {
            change[gearNumber][i] = getIndex(index[gearNumber][i], direction);
        }

        // 회전한 톱니바퀴 기준 왼쪽으로 진행, 만약 맞닿은 극이 같다면 반복 종료
        int number = gearNumber;
        while (number > 0) {
            if (gears[number][index[number][2]] == gears[--number][index[number][1]])
                break;

            direction *= -1;
            for (int i = 0; i < 3; i++) {
                change[number][i] = getIndex(index[number][i], direction);
            }
        }

        // 오른쪽으로 진행 맞닿은 극이 같다면 반복 종료
        direction = tmp;
        number = gearNumber;
        while (number + 1 < 4) {
            if (gears[number][index[number][1]] == gears[++number][index[number][2]])
                break;

            direction *= -1;
            for (int i = 0; i < 3; i++) {
                change[number][i] = getIndex(index[number][i], direction);
            }
        }

        index = change;
    }

    // 방향만큼 진행한 곳을 인덱스에 맞게 수정하기
    public static int getIndex(int x, int direction) {
        int dx = x + direction;
        if (dx >= 8)
            return dx - 8;
        else if (dx < 0)
            return dx + 8;
        return dx;
    }
}
