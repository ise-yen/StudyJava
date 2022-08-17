package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int[][] arr;
	static int N;
	static int M;
	static int K;
	static int max;
	static ArrayList<Integer> mins;
	static int[][] turns;

	static void Turn(int startI, int startJ, int endI, int endJ) {
		int tmp = arr[startI][endJ];
		// 상
		for (int j = endJ; j > startJ; j--) {
			int i = startI;
			arr[i][j] = arr[i][j - 1];
		}
		// 좌
		for (int i = startI; i < endI; i++) {
			int j = startJ;
			arr[i][j] = arr[i + 1][j];
		}
		// 하
		for (int j = startJ; j < endJ; j++) {
			int i = endI;
			arr[i][j] = arr[i][j + 1];
		}
		// 우
		for (int i = endI; i > startI; i--) {
			int j = endJ;
			arr[i][j] = arr[i - 1][j];
		}
		arr[startI + 1][endJ] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 1번째 줄 : N M K
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 2번째 줄~ : 배열 입력
		arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 연산 입력
		turns = new int[K][3];// K번 돌리고, rcs
		for (int i = 0; i < turns.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < turns[i].length; j++)
				turns[i][j] = Integer.parseInt(st.nextToken());
		}
		// 배열의 값(각 행 중 최솟값) 모음집
		mins = new ArrayList<Integer>();

		int turnNums = K; // 회전 연산 순서 섞었을 때 돌 수 있는 횟수
		// 순열로 회전 연산 순서 섞어서 돌리기
		TurnCal();


		// 리스트를 오름차순으로 정렬 후 최솟값(index : 0) 출력
		Collections.sort(mins);
		System.out.println(mins.get(0));
	}

	static void TurnCal() {
		// 돌리기
		for (int k = 0; k < K; k++) {
			int r = turns[0][0];
			// 수정 필요
			int c = turns[0][1];
			int s = turns[0][2];
			max = s - 1;
			while (max >= 0) {
				Turn(r - s - 1 + max, c - s - 1 + max, r + s - 1 - max, c + s - 1 - max);
				max--;
			}
		}

		// 돌린 뒤 나온 배열의 값(각 행 중 최솟값)을 리스트에 넣기
		for (int k = 0; k < K; k++) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				int sum = 0;
				for (int j = 0; j < arr[i].length; j++) {
					sum += arr[i][j];
				}
				min = Math.min(min, sum);
			}
			mins.add(min);
		}
	}

}
