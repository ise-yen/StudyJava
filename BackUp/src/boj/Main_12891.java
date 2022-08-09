package boj;

import java.util.Scanner;

public class Main_12891 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
//		int p = sc.nextInt();
		String str = sc.next();
		int[] minACGT = new int[4]; // ACGT 최소 개수
		for (int i = 0; i < minACGT.length; i++) {
			minACGT[i] = sc.nextInt();
		}

		int[] cntACGT = new int[4]; // str의 ACGT 개수 카운트

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 'A':
				cntACGT[0]++;
				break;
			case 'C':
				cntACGT[1]++;
				break;
			case 'G':
				cntACGT[2]++;
				break;
			case 'T':
				cntACGT[3]++;
				break;
			default:
				break;
			}
		}
		
		boolean isMake = false;
		for (int i = 0; i < str.length(); i++) {
			if(minACGT[i] > cntACGT[i]) {
				isMake = false;
				break;
			}
			else
				isMake = true;
		}		
		if(isMake) {
			System.out.println();
		}
		else
			System.out.println(0);
		
		sc.close();
	}
	
//	private static void pswd(int cnt) {
//		for(int i = 1; i<=6; i++) {
////			numbers[cnt] = i;
//			pswd(cnt+1);
//		}
//	}

}
