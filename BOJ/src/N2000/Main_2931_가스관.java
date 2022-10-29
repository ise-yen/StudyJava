package N2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static char[] blocks = { '|', '-', '+', '1', '2', '3', '4' }; // 블록 종류
	static int R, C;
	static char[][] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char type = 0; // 블록 타입이 무언일지
		int r = 0, c = 0; // 지워진 블록 위치
		int mr = 0, mc = 0; // 집 위치
		int bar = 0, bac = 0; // babyR, babyC : 유치원 위치
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];

		// 입력
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'M') {
					mr = i;
					mc = j;
				} else if (map[i][j] == 'Z') {
					bar = i;
					bac = j;
				}
			}
		}

		// 집에서부터 유치원까지 도로따라 가보기
		boolean isBlock = false; // 주변에 블록이 있는지
		boolean isHomeFinish = false; // 집에서 출발하는거 끝났는지
		boolean isBabyFinish = false; // 유치원에서 출발하는거 끝난는지

		while (!isHomeFinish) {
			for (int d = 0; d < deltas.length; d++) { // r, c 주변을 둘러봤을 때
				int nr = mr + deltas[d][0];
				int nc = mc + deltas[d][1];

				if (isInMap(nr, nc)) { // 맵 범위 내에서
					if (map[nr][nc] != '.' || map[nr][nc] != 'M' || map[nr][nc] != 'Z') {

						isBlock = true;
						// 그 도로부터 재탐색
						mr = nr;
						mc = nc;
						break;
					}
				}

				// 포인트 주변에 아무것도 없다면 주변에 끊긴 블록이 있는 것
				if (!isBlock) {
					// 유치원에서부터 체크할거니까 반복문 나가기
					// 반복 종료 신호 체크
					isHomeFinish = true;
				}
			}
		}

		isBlock = false; // 주변에 블록이 있는지
		while (!isBabyFinish) {
			for (int d = 0; d < deltas.length; d++) { // r, c 주변을 둘러봤을 때
				int nr = bar + deltas[d][0];
				int nc = bac + deltas[d][1];
				if (isInMap(nr, nc)) { // 맵 범위 내에서
					if (map[nr][nc] != '.' || map[nr][nc] != 'M' || map[nr][nc] != 'Z') {
						isBlock = true;
						// 그 도로부터 재탐색
						bar = nr;
						bac = nc;
						break;
					}
				}

				// 포인트 주변에 아무것도 없다면 주변에 끊긴 블록이 있는 것
				if (!isBlock) {
					// 유치원에서부터 체크할거니까 반복문 나가기
					// 반복 종료 신호 체크
					isBabyFinish = true;
				}
			}
		}
		if (bar < mr) {
			r = bar + 1;
			if (bac < mc) {
				c = bar + 1;
				type = '4';
			} else if (bac == mc) {
				c = bar;
				type = '|';
			} else {
				c = bar - 1;
				type = '3';
			}
		} else if (bar == mr) {
			r = bar;
			if (bac < mc) {
				c = bar + 1;
				type = '-';
			} else if (bac == mc) {
				c = bar;
				type = '+';
			} else {
				c = bar - 1;
				type = '-';
			}
		} else {
			r = bar - 1;
			if (bac < mc) {
				c = bar + 1;
				type = '1';
			} else if (bac == mc) {
				c = bar;
				type = '|';
			} else {
				c = bar - 1;
				type = '2';
			}
		}
		System.out.println(r + " " + c + " " + type);

	} // end of main

	static boolean isInMap(int nr, int nc) {
		if (nr >= 0 && nc >= 0 && nr < R && nc < C)
			return true;
		else
			return false;
	}
}
