package N2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_2819_교수님코드_격자판의숫자이어붙이기 {
	static int[][] map = new int[4][4]; // 각각 0~9가 적혀있음
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static HashSet<Integer> hs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 1. 격자 입력
			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < map[i].length; j++, index += 2) {
					map[i][j] = str.charAt(index) - '0';
				}
			}

			hs = new HashSet<Integer>();
			for (int r = 0; r < dc.length; r++) {
				for (int c = 0; c < dr.length; c++) {
					go(r, c, 1, 0);
				}
			}
			sb.append("#").append(t).append(" ").append(hs.size()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void go(int r, int c, int step, int num) {
		// 범위체크
		if (r < 0 || r >= dr.length || c < 0 || c >= dc.length)
			return;

		// 글자 이어붙이기
		num += map[r][c] + num * 10;
		if (step == 7) {
			// 중복이 아니면 카운팅, 추가
			if (!hs.contains(num)) {
				hs.add(num);
			}
			return;
		}
		// 재귀 상하좌우 호출
		for (int i = 0; i < dc.length; i++) {
			go(r + dr[i], c + dc[i], step + 1, num);
		}

	}

}
