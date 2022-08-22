package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int[][] phones;
	static int people = 101;
	static boolean[] isCall;

	static int maxLast;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			maxLast = Integer.MIN_VALUE;
			phones = new int[people][people];
			isCall = new boolean[people];

			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				phones[r][c] = 1;
			}

			call(start, 1);
			System.out.println("#" + t + " " + maxLast);
		}
	}

	static int maxCnt;

	static void call(int start, int cnt) {
//		System.out.print(start + " - ");

		int finishCount = 0;
		for (int c = 0; c < phones.length; c++) {
			if (phones[start][c] == 1) {
//				System.out.println("-> " + c + " 도착 : ");
				if (isCall[c]) {
//					System.out.println("  " + c + "는 이미 방문함");
					if (maxCnt < cnt) {
						maxLast = start;
						maxCnt = cnt;
					} else if (maxCnt == cnt) {
						maxLast = Math.max(maxLast, start);
						maxCnt = cnt;
					}
					continue;
//					System.out.println("   " + cnt + "번째 : start " + start + "\n");
				} else {
					if (maxCnt < cnt) {
						maxLast = c;
						maxCnt = cnt;
					} else if (maxCnt == cnt) {
						maxLast = Math.max(maxLast, c);
						maxCnt = cnt;
					}
//					System.out.println(cnt + "번째 : c " + c + "\n");
					isCall[c] = true;
					call(c, cnt + 1);
				}
			} else {
				finishCount++;
			}
		}

		if (finishCount == phones.length) {

//			System.out.println(" -> 갈 곳 없음");
//			System.out.println(cnt + "번째 : start" + start + "\n");
			if (maxCnt < cnt) {
				maxLast = start;
				maxCnt = cnt;
			} else if (maxCnt == cnt) {
				maxLast = Math.max(maxLast, start);
				maxCnt = cnt;
			}
		}
		return;
	}

}
