import java.io.BufferedReader;
import java.io.InputStreamReader;

// 달팽이 숫자
/*
 * <찾아야할 조건>
 * 	1. 방향 전환의 조건
 * 	2. 방향 변환의 규칙
 * 	3. 종료 조건
 * <1. 방향 전환>
 * 	1-1) 경계를 넘어갈 때 방향 전환
 * 	1-2) 진행 방향에 이미 값이 있을 때
 */
public class Solution_1954_교수님코드 {
	// 방향 전환용 델타 : 오른, 아래, 왼쪽, 위
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] arr;
	static int num;

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		arr = new int[num][num];
		fill();
		System.out.println("#" + t);
	}

	private static void fill() {
		// 위치 탐색용 변수들. 현재 좌표 r c / 다음 좌표 nr nc
		int r = 0, c = 0, nr = 0, nc = 0;
		// d: 방향 전환용. target : 종료 조건, i : 세팅 값
		int d = 0, target = num * num, i = 1;
		// 종료 조건에 해당하는 값이 될 때까지 진행
		while (i <= target) {
			// 3) 현 위치에 값 세팅
			arr[r][c] = i;
			// 다음 위치로 진행(이동 전)
			nr = r + dr[d];
			nc = c + dr[d];
			// 4) 방향 전환 조건
			if (nr < 0 || nr >= num || nc < 0 || nc >= num || arr[nr][nc] != 0) {
				// 맞으면 전환
				d = (d + 1) % 4;
				r += dr[d]; // 방향 전환
				c += dc[d];
			} else {
				// 아니면 계속 진행시켜
				r = nr;
				c = nc;
			}
			// 배열에 넣을 값 증가
			i++;
		}
	}

	private static void print() {
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.print();
		}
	}
}
