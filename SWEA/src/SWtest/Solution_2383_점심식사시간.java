package SWtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// <최악의 경우 계산>
// 최대 방 크기 = 10 * 10
// 사람 수 = 10
// 계단 개수 = 2
// 계단 최대 길이 = 10
// => 최악의 경우 : 2 ^ 10

public class Solution_2383_점심식사시간 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int res = 0; // 완전히 내려가는데 걸리는 최소 시간
		// 0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// p : 방
			// s : 계단

			// 1.

			System.out.println("#" + t + " " + res);
		}

	}

	// 계단까지 이동하는 시간 계산
	static int calMoveTIme(int pr, int sr, int pc, int sc) {
		int time = 0;
		time = Math.abs(pr - sr) + Math.abs(pc - sc);
		return time;
	}

	// 1명의 사람이 계단을 완전히 내려가는 시간
	static void calDownStair() {

	}
}

// 계단 내려가는 시간 = 계단 도착 ~ 완전히 내려갈 때까지
// 1분 후 아래칸
// 동시에 3명
// K //계단 길이