//package ch3;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Main {
//	public static void printArray(double arr[][]) {
//		System.out.println("arr length: " + arr.length);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print("arr[" + i + "] ");
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	public static double[][] run1(Scanner s) {
//		System.out.print("The number of rows of non-square array of doubles to create? ");
//		int n = s.nextInt();
//		double dArr[][] = new double[n][];
//		for (int i = 0; i < n; i++) {
//			dArr[i] = new double[i + 1];
//			System.out.print("Input continuously " + (i + 1) + " doubles to be stored in line " + (i + 1) + ": ");
//			for (int j = 0; j <= i; j++) {
//				dArr[i][j] = s.nextDouble();
//			}
//		}
//		return dArr;
//	}
//
//	private static double[][] run2(Scanner s) { // run1 -> 예외처리 -> run2
//		int n = 1;
//		while (true) {
//			try {
//				System.out.print("The number of rows of non-square array of doubles to create? ");
//				n = s.nextInt();
//				double dArr[][] = new double[n][]; // 배열을 꼭 만들어줘야 했어. 2차원 배열 안하고 1차원 배열 했어도 되긴 해
//				break;
//			} catch (NegativeArraySizeException e) { // 이게 양수가 아니라고 난리
//				System.out.println("Input a POSITIVE integer. Try again.");
//			} catch (InputMismatchException e) { // 이건 괜찮은데
//				System.out.println("Input an INTEGER. Try again.");
//				s.next(); // 정수가 아닌 값을 넣으면 버퍼에서 꺼내주지 않기 때문에 무한히 반복할 수 있다. -> 제거
//			}
//		}
//
//		double dArr[][] = new double[n][];
//
//		for (int i = 0; i < n; i++) {
//			dArr[i] = new double[i + 1]; // 메모리 할당을 해준다. 1개, 2개, 3개...
//			while (true) {
//				try {
//					System.out
//							.print("Input continuously " + (i + 1) + " doubles to be stored in line " + (i + 1) + ": ");
//					for (int j = 0; j <= i; j++) {
//						dArr[i][j] = s.nextDouble();
//					}
//					break;
//				} catch (InputMismatchException e) { // 예외가 발생했을 때,
//					System.out.println("Input a integer or double. Try again.");
//					s.nextLine();
//				}
//			}
//		}
//		return dArr;
//	}
//
//	public static void run3(Scanner s) {
//		final int USER = 0; // 상수 값 정의
//		final int COMPUTER = 1;
//
//		// 0, 1, 2 중 하나의 난수를 미리 발생하여 저장해 놓은 난수 배열
//		// 이 배열에 저장된 값은 나중에 MJBarray[] 배열의 인덱스 값으로 사용됨
//		int randArray[] = { 2, 1, 2, 2, 2, 1, 1, 0, 0, 2, 0, 2, 0, 2, 0, 1, 1, 2, 0, 0, 2, 0, 2, 2, 1, 2, 0, 0, 1, 2, };
//
//		String MJBarray[] = { "m", "j", "b" }; // 묵(m)찌(j)빠(b) 문자열을 가진 배열
//
//		System.out.println("Start the MUK-JJI-BBA game.");
//		System.out.print("Select any index for random number[0~29]? ");
//		int randIdx = s.nextInt();
//		s.nextLine(); // 입력 버퍼에 있는 '\n' 제거
//
//		int priority = USER; // 누가 우선권을 가졌는지 저장하고 있음, USER:사용자 우선권, COMPUTER:computer 우선권
//		String priStr[] = { "USER", "COMPUTER" }; // 화면에 출력할 때 사용함
//
//		while (true) {
//			System.out.println();
//			System.out.println(priStr[priority] + " has the higher priotiy."); // 화면에 (priStr[priority] + " has the
//																				// higher priotiy.")를 출력
//			System.out.print("m(muk), j(jji), b(bba) or stop? "); // 화면에 "m(muk), j(jji), b(bba) or stop? " 출력
//
//			String user = s.nextLine(); // 사용자가 입력한 묵찌빠 문자열을 입력 받아 String user 변수에 저장
//			if (user.equals("stop")) { // 사용자가 입력한 문자열을 비교할 때는 if (user.equals("stop")) 문장을 사용
//				return; // "stop"을 입력했으면 게임 종료
//			} else if (!user.equals("m") && !user.equals("j") && !user.equals("b")) { // 사용자가 m, j, b를 입력하지 않고 다른 문자열을
//																						// 입력했다면
//				System.out.println("Select one among m, j, b."); // 아래 실행결과를 참고하여 적절한 에러 메시지를 출력하고 while()의 처음부터 다시 시작
//			}
//
//			int comIdx = randArray[(randIdx++) % 30]; // 사용자가 randIdx를 고른다.
//			// 컴퓨터가 사용하는 난수 배열 인덱스 값 randIdx를 1 증가시킨 후 29보다 큰 경우 다시 0부터 시작 -> 이게 이걸 원한건지는
//			// 모르겠어.
//
//			String computer = MJBarray[comIdx]; // MJBarray[comIdx](컴퓨터가 낸 묵찌빠 문자열)을 String computer 변수에 저장
//			System.out.print("User = " + user + ", Computer = " + computer + ", ");
////            user와 computer 변수를 이용하여 화면에 사용자, 컴퓨터가 낸 묵찌빠 값을 출력 (예:User = m, Computer = b, )
//
//			if (user.equals(computer)) { // 이후 user와 computer 문자열을 비교하여 같으면
//				// user와 computer 두 문자열 비교하는 방법: if (user.equals(computer))
//				System.out.println(priStr[priority] + " WINs."); // 우선권을 가진 자가 이겼다고 출력하고
//			} else { // 같지 않으면(비겼으면)
//				System.out.println("SAME."); // 비겼다고 출력
//			}
//
////                현 상황이 (가위바위보)라 가정하고 누가 이겼는지 판단하여 우선권을 가지게 함 
////                (아주 긴 조건문이 될 것임) // 묵찌빠의 경우의수를 다 구현해야 해서가 아닐까
////                priority 값을 이긴 자(USER 또는 COMPUTER)로 변경함
//			if (user.equals("m") && computer.equals("j")) {
//				priority = USER;
//			} else if (user.equals("j") && computer.equals("b")) {
//				priority = USER;
//			} else if (user.equals("b") && computer.equals("m")) {
//				priority = USER;
//			} else if (user.equals("m") && computer.equals("b")) {
//				priority = COMPUTER;
//			} else if (user.equals("j") && computer.equals("m")) {
//				priority = COMPUTER;
//			} else if (user.equals("m") && computer.equals("j")) {
//				priority = COMPUTER;
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		double array[][] = { { 0 }, { 1, 2 }, { 3, 4, 5 } };
//		printArray(array);
//		System.out.println();
//
//		Scanner scanner = new Scanner(System.in); // 필요한 파일 import시킬 것
//		double dArr1[][] = run1(scanner);
//		printArray(dArr1);
//		System.out.println();
//
//		double dArr2[][] = run2(scanner);
//		printArray(dArr2);
//		System.out.println();
//
//		run3(scanner);
//		System.out.println();
//
//		scanner.close();
//		System.out.println("Done.");
//	}
//}