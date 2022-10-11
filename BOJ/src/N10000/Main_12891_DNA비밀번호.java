package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	static int[] minACGT;
	static int[] cntACGT;
	static int res = 0;
	static int correctMin = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		minACGT = new int[4]; // ACGT 최소 개수
		cntACGT = new int[4]; // p길이 문자열 중에 ACGT 개수

		///// 입력
		int s = Integer.parseInt(st.nextToken()); // 입력된 문자열 길이
		int p = Integer.parseInt(st.nextToken()); // 사용할 부분문자열의 길이

		// 문자열 입력
		String str = br.readLine();
		char dna[] = new char[s];
		dna = str.toCharArray();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < minACGT.length; i++) {
			minACGT[i] = Integer.parseInt(st.nextToken());
			if (minACGT[i] == 0) {
				correctMin++;
			}
		}
		///// 입력 끝

		for (int i = 0; i < p; i++) {
			add(dna[i]);
		}

		if (correctMin == 4) {
			res++;
		}

		// 슬라이딩 윈도우
		for (int i = 0; i < s - p + 1; i++) {
			for (int j = i; j < p + i; j++) {
				add(dna[i]);
				remove(dna[i]);
				if (correctMin == 4) {
					res++;
				}
			}
		}
		System.out.println(res);
		br.close();
	}

	private static void add(char c) {
		switch (c) {
		case 'A':
			cntACGT[0]++;
			if (cntACGT[0] == minACGT[0]) {
				correctMin++;
			}
			break;
		case 'C':
			cntACGT[1]++;
			if (cntACGT[1] == minACGT[1]) {
				correctMin++;
			}
			break;
		case 'G':
			cntACGT[2]++;
			if (cntACGT[2] == minACGT[2]) {
				correctMin++;
			}
			break;
		case 'T':
			cntACGT[3]++;
			if (cntACGT[3] == minACGT[3]) {
				correctMin++;
			}
			break;
		}
	}

	private static void remove(char c) {
		switch (c) {
		case 'A':
			if (cntACGT[0] == minACGT[0]) {
				correctMin--;
			}
			cntACGT[0]--;
			break;
		case 'C':
			if (cntACGT[1] == minACGT[1]) {
				correctMin--;
			}
			cntACGT[1]--;
			break;
		case 'G':
			if (cntACGT[2] == minACGT[2]) {
				correctMin--;
			}
			cntACGT[2]--;
			break;
		case 'T':
			if (cntACGT[3] == minACGT[3]) {
				correctMin--;
			}
			cntACGT[3]--;
			break;
		}
	}
}