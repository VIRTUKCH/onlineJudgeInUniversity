//package beforemidterm;
//
//import java.util.Scanner;
//
//public class Chapter3_1 {
//	public static int[][] makeArray(Scanner s) {
//		System.out.print("array size? ");
//		int arraySize = s.nextInt();
//		int arr[][] = new int[arraySize][arraySize];
//
//		// 초기화 시작
//		int cnt = 0;
//		for (int i = 0; i < arr.length; i++) {
////			for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
//			for (int j = arr.length - 1 - i; j < arr.length; j++) {
//				arr[i][j] = ++cnt;
//			}
//		}
//
//		return arr;
//	}
//
////
//	public static void printArray(int arr[][]) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print("arr[" + i + "] ");
//			for (int j = 0; j < arr.length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int arr[][];
//		while (true) {
//			arr = makeArray(scanner);
//			printArray(arr);
//			System.out.print("continue? ");
//			scanner.nextLine();
//			String yesOrNo = scanner.next();
//			System.out.println();
//
//			if (yesOrNo.equals("yes")) {
//			} else {
//				break;
//			}
//		}
//		scanner.close();
//		System.out.print("Done.");
//	}
//}
