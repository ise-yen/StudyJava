package N2000;

/**
 * 완탐, 시뮬레이션
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 손해 보지 않는 한 최대한 많은 집에 제공
public class Solution_2117_홈방범서비스_교수님코드 {
	static int[] K = { 1, 1, 5, 13, 25, 41, 61, 85, 113, 145, 181, 221, 265, 313, 365, 421, 481, 545, 613, 685, 761,
			841, 925, 1013, 1105, 1201, 1301, 1405, 1513, 1625, 1741, 1861, 1985, 2113, 2245, 2381, 2521, 2665, 2813,
			2965, 3121, };
	static int N; // 맵 크기
	static int M; // 한 집에서 지불할 수 있는 비용
//	static int K; // 서비스 영역
	static int serviceCost; // 운영 비용 = K * K + (K-1) * (K-1)
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
//			String s = "";
//			s.split(regex);

			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int res = 0; // 서비스 가능한 가장 많은 집
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][N];

			// 집의 좌표 넣기
			List<int[]> home = new ArrayList<int[]>(); // 집들의 좌표 {행, 열}
			for (int r = 0; r < map.length; r++) {
				String s = br.readLine();
				for (int c = 0, index = 0; c < map[r].length; c++, index += 2) {
					if (s.charAt(index) == '1') {
						home.add(new int[] { r, c }); // {행, 열}
					}
				}
			}

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					for (int k = 1; k <= 40; k++) {
						int cntHome = 0;
						for (int h = 0; h < home.size(); h++) {
							if (Math.abs(home.get(h)[0] - r) + Math.abs(home.get(h)[1] - c) < k) {
								cntHome++;
							}
						}

						if (cntHome * M >= K[k]) {
							res = Math.max(res, cntHome);
						}
					}
				}
			}

			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.print(sb.toString());
	}

}
