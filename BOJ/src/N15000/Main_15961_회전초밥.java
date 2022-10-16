package N15000;

// 회전초밥

// 1. 임의의 위치 ~ k개의 접시 연속 => 할인된 정액 가격
// 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰 발행
//  - 2-1. 1번에 참가 => 이 쿠폰에 적힌 초밥을 무료 제공
//  - 2-2. 없으면 즉석 제작

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {

	static int N, d, k, c; // 벨트에 놓인 접시 수, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호
	static int[] beltArr; // 벨트 위 초밥 종류
	static boolean[] isEat;// 먹었는지 체크

	public static void main(String[] args) throws IOException {
		int res = Integer.MIN_VALUE; // 먹을 수 있는 초밥의 가짓수의 최댓값 (같은 초밥 안 먹게 조심)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		beltArr = new int[N]; // 벨트 위의 초밥
		for (int i = 0; i < N; i++) {
			beltArr[i] = Integer.parseInt(br.readLine());
		}

		for (int p = 0; p < N - k + 1; p++) {
			res = Math.max(res, eat(p));
		}
		System.out.println(res);
	}

	static int eat(int pos) {
		isEat = new boolean[d + 1]; // index 번호로 체크. 0은 무시
		int cnt = 0;
		// 연속으로 먹은 거 체크
		for (int i = 0; i < k; i++) { // i개 먹는 중
			if (!isEat[beltArr[pos + i]]) { // pos+i번째 번호 초밥을 먹었는지
				cnt++;
				isEat[beltArr[pos + i]] = true;
			}
		}

		// 쿠폰 체크
		if (!isEat[c])
			cnt++;

//		System.out.println(cnt);
		return cnt;
	}
}
