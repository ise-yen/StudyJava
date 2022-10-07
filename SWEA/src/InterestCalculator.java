
public class InterestCalculator {

	static double rate = 0.4; // 금리
	static int inputMoney = 100000; // 납입 금액
	static int period = 26; // 납입 기간

	public static void main(String[] args) {
		double resultMoney = 0; // 최종 금액
		double resultInterest = 0; // 최종 이자

		// 기간동안 적금 납입 성공 시
		for (int p = period; p >= 1; p--) {
			double inter = calInterest(p, period, inputMoney);
			resultMoney += inputMoney + inter;
			resultInterest += inter;
		}

		// 소수점 자르고 결과값 출력
		System.out.println("최종금액 : " + Math.round(resultMoney));
		System.out.println("최종이자 : " + Math.round(resultInterest));
	}

	// 주차별 이자 계산하는 함수
	static double calInterest(int p, int period, int inputMoney) { // 예치회차, 계약회차, 납입 금액
		double interest = 0; // 이자

		// 이자계산방법 (세전) : 회차별 입금금액 X 약정금리 X 예치회차 / 계약회차
		interest = inputMoney * rate * ((double) p / (double) period);

		interest = Math.round(interest); // 소수점 날림

		// 이자 출력
		System.out.println(Math.abs(period - p) + 1 + "회차 이자 : " + interest);

		return interest;
	}

}
