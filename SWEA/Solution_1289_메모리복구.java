package swea;

import java.util.Scanner;

// 원재의 메모리 복구하기
public class Solution_1289_메모리복구 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int res = 0;
			String str = sc.next();
		
			for(int i = 0; i< str.length(); i++) {
				if(i == 0) {
					if(str.charAt(i) == '1') res++;
				}
				else {
					if(str.charAt(i) != str.charAt(i-1)) res++;
				}
			}

			System.out.println("#" + test_case + " " + res);
		}
	}

}
