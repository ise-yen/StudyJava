package N3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이양팔저울 {
	static int[] choo;
	static int res;

	static boolean[] isSelectedPerm;
	static boolean[] isSelectedSub;
	static int[] selectChoo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			res = 0;
			int N = Integer.parseInt(br.readLine());
			isSelectedPerm = new boolean[N];
			selectChoo = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			choo = new int[N];
			for (int i = 0; i < choo.length; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			} ///// <===== 입력 종료

			Perm(N, 0);
			sb.append("#" + tc + " " + res + '\n');
		}
		System.out.println(sb);
	}

	// 1. 순열로 뽑기
	static void Perm(int N, int index) {
		if (index == N) {
			System.out.println(Arrays.toString(selectChoo));
//			int sumL = 0;
//			int sumR = 0;
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i]) {
//					sumL += choo[i];
//
//				} else {
//					if (sumR + choo[i] > sumL) {
//						break;
//					}
//				}
//			}
			for (int i = 0; i < N; i++) {

			}
			Subset(N, index);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelectedPerm[i])
				continue;
			selectChoo[index] = choo[i];
			isSelectedPerm[i] = true;
			Perm(N, index + 1);
			isSelectedPerm[i] = false;
		}
	}

	static void Subset(int N, int index) {
		if (index == N) {// 고려할 원소가 없으면 부분집합 완성
			for (int i = 0; i < N; i++) {
				System.out.print(isSelectedSub[i] ? choo[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		// 원소 선택
		isSelectedSub[index] = true;
		Subset(N, index + 1);
		// 원소 미선택
		isSelectedSub[index] = false;
		Subset(N, index + 1);
	}
}
