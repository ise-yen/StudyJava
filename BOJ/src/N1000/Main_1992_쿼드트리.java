package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	static char[][] map;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int startI = 0;
		int startJ = 0;
		int size = map.length;
		QuadTree(startI, startJ, size);
		System.out.println(sb);

	}

	static void QuadTree(int startI, int startJ, int size) {
		int cnt0 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

		for (int i = startI; i < startI + size; i++) {
			for (int j = startJ; j < startJ + size; j++) {
				if (map[i][j] == '0') {
					cnt0++;
				} else if (map[i][j] == '1') {
					cnt1++;
				}
			}
		}
		if (cnt0 == size * size) {
			sb.append(0);
			cnt0 = 0;
		} else if (cnt1 == size * size) {
			sb.append(1);
			cnt1 = 0;
		} else {
			sb.append('(');
			QuadTree(startI, startJ, size / 2); // 좌상
			QuadTree(startI, startJ + size / 2, size / 2); // 우상
			QuadTree(startI + size / 2, startJ, size / 2); // 좌하
			QuadTree(startI + size / 2, startJ + size / 2, size / 2); // 우하
			sb.append(')');
		}
	}
}
// 테스트케이스
//4
//2233
//1100
//0011
//1230

//0 0 0 0		  	0 0 0 0
//0 0 0 0		  	0 0 0 0
//0 0 0 0		  	1 1 1 1 
//0 0 0 0		  	1 1 1 1 
//
//0 0 0 1		  	1 1 1 1 
//0 0 1 1		  	1 1 1 1 
//0 0 1 1		  	1 1 1 1 
//0 0 1 1		  	1 1 1 1 
//
//(0		 		(0011)
//(0 (0111) 01)	1)
//
//
//
//
//
//0 0   0 1
//0 0   1 1
//
//0 0   1 1
//0 0   1 1
//
//0 (0111) 01