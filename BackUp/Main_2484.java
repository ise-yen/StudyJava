import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 브2) 주사위 네개
public class Main_2484 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 참가자 수
		int awardArr[] = new int[n]; // 사람 당 상금
		int dices[][] = new int[4][6];
		for (int p = 0; p < awardArr.length; p++) {
			dices[p][sc.nextInt() - 1]++;
		}


//		for (int p = 0; p < awardArr.length; p++) {
//			int i = 5;
//			if (dices[i] != 0) {
//				if (dices[i] == 4) {
//					awardArr[p] = 50000 + dices[i] * 5000;
//				} else if (dices[i] == 3) {
//					awardArr[p] = 10000 + dices[i] * 1000;
//				} else if (dices[i] == 2) {
//					for (int j = 0; j < dices.length; j++) {
//						if (dices[i - 1] == 2)
//							awardArr[p] = 2000 + (dices[j] + dices[i]) * 500;
//
//						else
//							awardArr[p] = 2000 + dices[i] * 100;
//					}
//				} else {
//					awardArr[p] = dices[i] * 100;
//				}
//			}
//		}
	}
}
