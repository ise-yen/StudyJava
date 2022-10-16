package N16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	static int N;
	static int M;
	static int R;
	static int C;
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 배열 입력
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산 번호를 리스트로 입력
		st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> calList = new ArrayList<>();
		while (st.hasMoreTokens()) {
			C = Integer.parseInt(st.nextToken());
			calList.add(C);
		}

		if (calList.size() > 1) {
			// 연산 번호 2개 돌고 나면 원상 복귀하게 되는 쌍이 있으면 리스트에서 지우기
			for (int i = 0; i < calList.size() - 1; i++) {
				// 돌린 뒤에 원상복귀되는 쌍
				if ((calList.get(i) == 1 && calList.get(i + 1) == 1) || (calList.get(i) == 2 && calList.get(i + 1) == 2)
						|| (calList.get(i) == 3 && calList.get(i + 1) == 4)
						|| (calList.get(i) == 4 && calList.get(i + 1) == 3)
						|| (calList.get(i) == 5 && calList.get(i + 1) == 6)
						|| (calList.get(i) == 6 && calList.get(i + 1) == 5)) {
					calList.remove(i + 1);
					calList.remove(i);
					i--;
				}
			}
		}

		// 남은 리스트의 연산 번호대로 돌리기
		for (int i = 0; i < calList.size(); i++) {
			switch (calList.get(i)) {
			case 1:
				UpDown();
				break;
			case 2:
				LeftRight();
				break;
			case 3:
				GoRight();
				break;
			case 4:
				GoLeft();
				break;
			case 5:
				GroupRight();
				break;
			case 6:
				GroupLeft();
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 1 : 상하 뒤집기
	static void UpDown() {
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length / 2; i++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[arr.length - 1 - i][j];
				arr[arr.length - 1 - i][j] = tmp;
			}
		}
	}

	// 2 : 좌우 뒤집기
	static void LeftRight() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - 1 - j];
				arr[i][arr[i].length - 1 - j] = tmp;
			}
		}
	}

	// 3 : 오른쪽 돌리기
	static void GoRight() {
		int[][] map = new int[arr[0].length][arr.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = arr[arr.length - 1 - j][i];
			}
		}

		arr = map;
	}

	// 4 : 왼쪽 돌리기
	static void GoLeft() {
		int[][] map = new int[arr[0].length][arr.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = arr[j][arr[0].length - 1 - i];
			}
		}

		arr = map;
	}

	// 5 : 그룹 오른쪽 돌리기
	static void GroupRight() {
		int[][] tmp = new int[arr.length / 2][arr[0].length / 2];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}

		// 좌상단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i][j] = arr[i + arr.length / 2][j];
			}
		}
		// 좌하단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i + arr.length / 2][j] = arr[i + arr.length / 2][j + arr[i].length / 2];
			}
		}
		// 우하단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i + arr.length / 2][j + arr[i].length / 2] = arr[i][j + arr[i].length / 2];
			}
		}
		// 우상단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i][j + arr[i].length / 2] = tmp[i][j];
			}
		}
	}

	// 6 : 그룹 왼쪽 돌리기
	static void GroupLeft() {
		int[][] tmp = new int[arr.length / 2][arr[0].length / 2];
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		// 좌상단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i][j] = arr[i][j + arr[i].length / 2];
			}
		}
		// 우상단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i][j + arr[i].length / 2] = arr[i + arr.length / 2][j + arr[i].length / 2];
			}
		}
		// 우하단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i + arr.length / 2][j + arr[i].length / 2] = arr[i + arr.length / 2][j];
			}
		}
		// 좌하단
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				arr[i + arr.length / 2][j] = tmp[i][j];
			}
		}

	}
}
