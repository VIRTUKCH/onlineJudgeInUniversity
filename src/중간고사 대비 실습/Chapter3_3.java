package beforemidterm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chapter3_3 {
	// 여기만 수정하면 됨
	public static int[][] makeArray(Scanner s) {
		System.out.print("array size? ");
		int arraySize = s.nextInt();
//		int arr[][] = new int[arraySize][arraySize];

		int arr[][] = new int[arraySize][];
		int arrayIdxCnt = 0;
		for (int i = arraySize; i > 0; i--) {
			arr[arrayIdxCnt] = new int[i];
			arrayIdxCnt++;
		}

		// 초기화 시작
		int howBigValueNeed = 0;
		for (int i = 0; i < arr.length; i++) {
			howBigValueNeed = arr.length - 1;
//			for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
//			for (int j = 0; j < arr[i].length; j++) {
			for (int j = arr[i].length - 1; j >= 0; j--) {
				arr[i][j] = howBigValueNeed--;
			}
		}

		return arr;
	}

//
	public static void printArray(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("arr[" + i + "] ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 3_3에서 새롭게 추가된 기능
	public static void printArrayElement(Scanner s, int arr[][]) {
		int r = 0, c = 0;
		try {
			System.out.print("dividen? ");
			int bunja = s.nextInt(); // 분자 입력받기
			System.out.print("divisor? ");
			int bunmo = s.nextInt(); // 분모 입력받기

			try {
				r = bunja / bunmo;
				c = bunja % bunmo;
			} catch (ArithmeticException e1) {
				System.out.println("divisor is ZERO");
				return;
			}

			try {
				System.out.println("arr[" + r + "][" + c + "]: " + arr[r][c]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("arr[" + r + "][" + c + "]: array index is out of BOUNDS");
			}
		} catch (InputMismatchException e1) {
			System.out.println("input an INTEGER");
		}
		return;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[][];

		arr = makeArray(scanner);
		printArray(arr);
		System.out.println();

		while (true) {
			printArrayElement(scanner, arr);
			System.out.print("continue? ");
			scanner.nextLine();
			String yesOrNo = scanner.next();

			System.out.println();
			if (yesOrNo.equals("yes")) {
			} else {
				break;
			}
		}

		scanner.close();
		System.out.print("Done.");
	}
}
