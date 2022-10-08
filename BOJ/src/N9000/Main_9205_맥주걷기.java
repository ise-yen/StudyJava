package N9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_9205_맥주걷기 {

	static class Pos {
		int i, j;

		public Pos(int i, int jㅌ) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		int beers = 20; // 한 박스에 20병 제한
		int term = 50; // 50m

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) { // Test Case
			ArrayList<Pos> posList = new ArrayList<>();

			// 1. 입력
			int n = Integer.parseInt(br.readLine()); // 편의점의 개수
			int[][] map = new int[n][n];

			int hi = 0, hj = 0;
			int fi = 0, fj = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (i == 0) {
					hi = Integer.parseInt(st.nextToken());
					hj = Integer.parseInt(st.nextToken());
				} else if (i == n - 1) {
					fi = Integer.parseInt(st.nextToken());
					f	j = Integer.parseInt(st.nextToken());
				} else {
					Pos pos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					posList.add(pos);
				}
			} // ==================== 입력 끝

			boolean isSad = false;
			int size = posList.size();
			// 2. 직행 가능하면 바로 가기
			if (Distance(posList.get(0).i, posList.get(0).j, posList.get(size - 1).i, posList.get(size - 1).j) < 50) {
				System.out.println("happy");
				continue; // 다음 tc 진행
			} else {

			}
			// 3. 편의점 들릴 경우
			// 3-1. 정렬 : 안 들려도 되는 편의점 제외

			// 3-2. 지도에서 상근이 집과 페스티벌의 순서 찾기

			// 집에서 페스티벌 방향으로 걷기
			// 3-3. 현재위치~편의점까지 거리 중 50m 될 때마다 한 잔 드링킹
			if (isSad)
				continue;
			else {
				System.out.println("happy");
			}
		} // =====> end of Test Case

	}

	static int Distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
