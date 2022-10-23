package N17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import N17000.Main_17143_낚시왕_enum.eDir;

public class Main_17143_낚시왕2 {

	static char[][] map;
	static Shark[][] mapShark;
	static ArrayList<Shark> sharkList;

	static class Shark {
		int r, c, s, d, z; // 상어위치, 속력, 이동 방향, 크기
		char num; // 상어 번호(지만 알파벳)

		public Shark(char num, int r, int c, int s, int d, int z) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		int res = 0; // 정답

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = '0';
			}
		}

		sharkList = new ArrayList<Shark>();

		// 상어들 정보 넣기
		for (int m = 0; m < M; m++) {
			char num = (char) (m + 'A');

			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(num, r, c, s, d, z);
			sharkList.add(shark);
			map[r][c] = num;

		}
		// 3. 상어가 이동한다.
		for (int sIdx = 0; sIdx < sharkList.size(); sIdx++) {
			if (sharkList.get(sIdx).s != -1) {
				for (int s = 1; s <= sharkList.get(sIdx).s; s++) {
					switch (sharkList.get(sIdx).d) {
					case 1: // 위
						// 구현
						break;
					case 2: // 아래
						// 구현
						break;
					case 3: // 오른쪽
						// 구현
						break;
					case 4: // 왼쪽
						// 구현
						break;
					}

				}
			}
		} // ========== 이동 종료

		// [DEBUG] sharklist 확인
		debugSharkList();

		debugMap();

	}

	static void debugMap() {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void debugSharkList() {
		for (int i = 0; i < sharkList.size(); i++) {
			System.out.println(sharkList.get(i).dir + ", ");
		}
	}
}
