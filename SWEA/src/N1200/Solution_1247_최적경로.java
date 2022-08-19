package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static int N; // 고객의 수
	static int[][] map; // 좌표 x, y
	static int[] order;
	static boolean[] isSelected;
	static int minDis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			minDis = Integer.MAX_VALUE;
			////// =====> 입력 시작
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][2]; // 0: 회사, 1: 집, 2~N+1: 고객 // x, y좌표
			isSelected = new boolean[N + 2];
			order = new int[N + 2];
			order[1] = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < map.length; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			} ////// <===== 입력 종료

			// 방문 순서 체크 + 이동거리 계산
			Perm(2); // 회사, 집 건너 뛰기

			sb.append("#" + tc + " " + minDis + "\n");
		} // end of test case
		System.out.println(sb);
	}

	static void Perm(int num) {
		if (num == map.length) {
			// 뽑은 방문 순서에 따른 이동 거리 계산
			int dis = Distance();
			// 최소 이동 거리 구하기
			minDis = Math.min(minDis, dis);
			// 종료
			return;
		}

		// 고객 집(2~N+1)만 체크(회사x, 집x)
		for (int i = 2; i < map.length; i++) {
			// 방문 여부 체크
			if (isSelected[i])
				continue;
			// 방문 순서 뽑기
			order[num] = i;
			isSelected[i] = true;
			// 다음 순서
			Perm(num + 1);
			// 방문했던 집들 리셋
			isSelected[i] = false;
		}
	}

	static int Distance() {
		int disSum = 0;

		// |x1 - x2| + |y1 - y2|
		int disX = 0, disY = 0;
		for (int i = 0; i < map.length - 1; i++) {
			// map 사이즈 = N+2
			// order[i] = 0(회사), 1(집), {뽑은 순서 대로}
			// 회사(map의 index = 0) -> 1번째 고객(map의 index = 2)
			if (order[i] == 0) {
				disX = Math.abs(map[order[i]][0] - map[order[2]][0]);
				disY = Math.abs(map[order[i]][1] - map[order[2]][1]);
			}
			// N번째 고객(map의 index = N+1) -> 집(map의 index = 1)
			else if (order[i] == 1) {
				disX = Math.abs(map[order[order.length - 1]][0] - map[order[i]][0]);
				disY = Math.abs(map[order[order.length - 1]][1] - map[order[i]][1]);
			}
			// 회사 -> 1번째 고객
			else {
				disX = Math.abs(map[order[i]][0] - map[order[i + 1]][0]);
				disY = Math.abs(map[order[i]][1] - map[order[i + 1]][1]);
			}
			disSum += disX + disY;
		}

		return disSum;
	}

}
