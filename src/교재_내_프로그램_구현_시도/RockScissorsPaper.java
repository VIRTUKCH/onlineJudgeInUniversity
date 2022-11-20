package 교재_내_프로그램_구현_시도;

import java.util.Scanner;

public class RockScissorsPaper {

	static String inputOfCheoulSoo; // 가위바위보는 한 번에 하나만 한다.
	static String inputOfYoungHee; // 그렇다면 내가 static으로 하지 않을 이유가 있을까? 굳이 객체를 생성?

	private static void getInput() { // 내가 예외를 직접 던지는 방법에 대해서도 생각해볼 수 있지 않을까?
		Scanner sc = new Scanner(System.in);
		printStars();
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		System.out.print("철수 >> ");
		inputOfCheoulSoo = sc.next();
		while (!(inputOfCheoulSoo.equals("가위") || inputOfCheoulSoo.equals("바위") || inputOfCheoulSoo.equals("보")
				|| inputOfCheoulSoo.isEmpty() || inputOfCheoulSoo == null)) { // 빈 문자열 입력받는 처리도 하고싶은데 안됨
			System.out.println("잘못된 입력입니다. 가위, 바위, 보 중에서 입력하세요");
			System.out.print("철수 >> ");
			inputOfCheoulSoo = sc.next();
		}

		System.out.print("영희 >> ");
		inputOfYoungHee = sc.next();
		while (!(inputOfYoungHee.equals("가위") || inputOfYoungHee.equals("바위") || inputOfYoungHee.equals("보")
				|| inputOfYoungHee.isEmpty() || inputOfYoungHee == null)) { // 빈 문자열 입력받는 처리도 하고싶은데 안됨
			System.out.println("잘못된 입력입니다. 가위, 바위, 보 중에서 입력하세요");
			System.out.print("영희 >> ");
			inputOfYoungHee = sc.next();
		}
		sc.close();
	}

	private static void printResult() {
		if (inputOfCheoulSoo.equals(inputOfYoungHee)) {
			System.out.println("비겼습니다. 다시 한 번 게임을 시작합니다.");
			printStars();
			System.out.println();
			getInput();
		}

		if (inputOfCheoulSoo.equals("가위") && inputOfYoungHee.equals("보")) {
			System.out.println("철수가 이겼습니다.");
		} else if (inputOfCheoulSoo.equals("가위") && inputOfYoungHee.equals("바위")) {
			System.out.println("영희가 이겼습니다.");
		} else if (inputOfCheoulSoo.equals("바위") && inputOfYoungHee.equals("가위")) {
			System.out.println("철수가 이겼습니다.");
		} else if (inputOfCheoulSoo.equals("바위") && inputOfYoungHee.equals("보")) {
			System.out.println("영희가 이겼습니다.");
		} else if (inputOfCheoulSoo.equals("보") && inputOfYoungHee.equals("바위")) {
			System.out.println("철수가 이겼습니다.");
		} else if (inputOfCheoulSoo.equals("보") && inputOfYoungHee.equals("가위")) {
			System.out.println("영희가 이겼습니다.");
		}
		printStars();
	}

	private static void printStars() {
		System.out.println("**********************************************");
	}

	public static void main(String[] args) {
		getInput();
		printResult();
	}
}