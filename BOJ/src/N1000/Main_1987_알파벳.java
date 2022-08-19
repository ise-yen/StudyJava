package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R;
	static int C;
	static char[][] board;
	static boolean[] isCheck = new boolean[26]; // 인덱스 = 알파벳 - 'A'

	static int maxCnt = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int i = 0; i < board.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		} ///// <===== 입력 끝

		// 초기 좌표
		int r = 0;
		int c = 0;
		int cnt = 0;
		dfs(r, c, cnt, 0);
		System.out.println(maxCnt);
	}

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int cnt, int num) {
		int move = 0;
		if (num == R * C || move == dr.length) {
			Math.max(maxCnt, cnt);
			return;
		}

		for (int b = 0; b < R * C; b++) {
			for (int k = 0; k < dr.length; k++) {
				move++;
				if (r + dr[k] >= 0 && r + dr[k] < board.length && c + dc[k] >= 0 && c + dc[k] < board.length) {
					if (!isCheck[board[r + dr[k]][c + dc[k]] - 'A']) {
						isCheck[board[r + dr[k]][c + dc[k]] - 'A'] = true;
						dfs(r + dr[k], c + dc[k], cnt + 1, b);
						isCheck[board[r + dr[k]][c + dc[k]] - 'A'] = false;
					}
				}
			}
			if (move == dr.length)
				break;
			else {
				move = 0;
			}
		}

	}

}
