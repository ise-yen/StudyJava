
public class tossTest {

	public static void main(String[] args) {
		double resultMoney = 0; // 최종 금액
		int inputMoney = 50000; // 10만원
		double resultInterest = 0;
		int totalWeek = 26; // 26주

		// 26주 동안 매주 적금 납입 성공 시
		for (int week = totalWeek; week >= 1; week--) {
			resultMoney += inputMoney + tossInterest(week, totalWeek, inputMoney);
			resultInterest += tossInterest(week, totalWeek, inputMoney);
		}

		// 소수점 자르고 결과값 출력
		System.out.println("최종금액 : " + Math.round(resultMoney));
		System.out.println("최종이자 : " + Math.round(resultInterest));
	}

	// 주차별 이자 계산하는 함수
	static double tossInterest(int week, int totalWeek, int inputMoney) { // 예치주차, 계약주차, 납입 금액
		double rate = 0.03; // 4%
		double interest = 0;

		// 이자계산방법 (세전) : 회차별 입금금액 X 약정금리 X 예치주차 / 계약주차
		interest = inputMoney * rate * ((double) week / (double) totalWeek);

		interest = Math.round(interest); // 소수점 날림

		// 이자 출력
		System.out.println(week + "주차 이자 : " + interest);

		return interest;
	}

}
