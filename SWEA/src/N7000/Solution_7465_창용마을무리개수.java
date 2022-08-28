package N7000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리개수 {
	static int[][] people;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 마을 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 서로 알고 있는 사람의 관계수

			// 사람 번호 = 1~N
			people = new int[N + 1][N + 1];

			// 서로 알고 있는 사람의 버호
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				people[i][j] = 1;
				people[j][i] = 1;
			}

			res = 0;

			visitied = new boolean[N + 1][N + 1];
			for (int i = 1; i < people.length; i++) {
				isGroup = false;
				Group(i, 0);
				if (isGroup)
					res++;
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		} // end of Test Case
		System.out.println(sb);
	}

	static int res;
	static boolean[][] visitied;
	static boolean isGroup;

	static void Group(int n, int cnt) {
		for (int i = 0; i < people.length; i++) {
			if (!visitied[n][i] && !visitied[i][n]) {
				if (people[n][i] == 1 || people[i][n] == 1) {
					visitied[n][i] = true;
					visitied[i][n] = true;
					isGroup = true;
					Group(i, cnt);
				}
			}
		}
	}
}
