package N3000;
// 가스 도둑.. 경찰 아저씨 여기에요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C;
	static char[][] gasMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		gasMap = new char[R][C + 2];
		for (int r = 0; r < gasMap.length; r++) {
			String str = br.readLine();
			int s = 0;
			for (int c = 0; c < gasMap[r].length; c++) {
				if (c == 0)
					gasMap[r][c] = 'A';
				else if (c == gasMap[r].length - 1)
					gasMap[r][c] = 'B';
				else {
					gasMap[r][c] = str.charAt(s);
					s++;
				}
			}
		}

		// [DEBUG] 입력 잘 됐는지 체크
		for (int r = 0; r < gasMap.length; r++) {
			for (int c = 0; c < gasMap[r].length; c++) {
				System.out.print(gasMap[r][c] + " ");
			}
			System.out.println();
		}

//		for (int c = 1; c < gasMap[0].length - 1; c++) {
//			for (int r = 0; r < gasMap.length; r++) {
//				if (gasMap[r][c] == '.') {
//					if (r - 1 >= 0 && r + 1 <= gasMap.length) {
//						// 우, 우상단, 우하단 중에 .이 있는지 찾기
//						if (gasMap[r][c + 1] == '.' || gasMap[r - 1][c + 1] == '.' || gasMap[r + 1][c + 1] == '.') {
//
//						}
//					}
//				}
//			}
//		}
	}
}
