package N1000;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1094_막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0; // 몇 개의 막대를 풀로 붙여야 Xcm이 되는지
		int M = 64; // 막대makdae 처음 길이
		int x = sc.nextInt(); // 다연이가 갖고 싶은 막대 길이

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 막대 리스트
		pq.add(M);
		int sumM = 64; // 처음 막대들의 길이 = 64
		if (x <= 64 && x >= 1) {
			if (x == 64 || x == 1 || x == 2 || x == 4 || x == 8 || x == 16 || x == 32)
				res = 1; // 2의 n승들은 무조건 막대 1개로 가능
			else {
				// 막대들 합이 x가 될 때 까지 반복
				while (sumM > x) {
					// 가지고 있는 막대의 길이의 합이 x보다 크다면
					if (sumM > x) {
						int smallest = pq.poll();
						// 1. 가지고 있는 막대 중 길이가 가장 짧은 막대를 이등분
						int div = smallest / 2;
						pq.add(div); // 반띵한 거 중 하나는 막대 목록에 넣기

						// 이등분한 막대 중 하나를 제외한
						// 나머지의 모든 막대의 길이의 합이 x 이상이면,
						if (sumM - div >= x) {
							// 제외한 조각은 버린다.
							sumM -= div; // 버려졌으니 전체 길이는 이제 그 나머지
						} else {
							// 버리지 않음
							pq.add(div); // 막대 목록에 넣기
						}
					}

					// System.out.println(pq.toString()); // pq 내용물 체크
				}
				res = pq.size(); // pq에 들어있는 막대들의 개수 = pq 사이즈
			}
		}

		System.out.println(res);
		sc.close();
	}

}
