package N8000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int res = 0;
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// =====> end of 입력
			
			/* 규칙 : */ 
			// x1, y1 -> x2, y2
			// ... -> 가로 -> 세로 -> 가로 -> 세로 -> ...

			int widthCnt = Math.abs(x1 - x2);
			int verticalCnt = Math.abs(y1 - y2);

			if ((x1 == x2 && y1 == y2) || Math.abs(widthCnt - verticalCnt) == 1)
				res = widthCnt + verticalCnt;
			else {
				res += verticalCnt + widthCnt;
				int tmp = Math.abs(verticalCnt - widthCnt); // 짧은 쪽에 도착했는데 긴 쪽이 안도착해서 위아래로 왕복하는 횟수
				res += tmp; // 가로로 원래 가야하는 방향 +
				if ((widthCnt + verticalCnt) % 2 == 1) {
					res--;
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

}
