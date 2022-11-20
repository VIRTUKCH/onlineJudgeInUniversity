//package beforemidterm;
//
//import java.util.Scanner;
//
//class Student {
//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getTall() {
//		return tall;
//	}
//
//	public void setTall(int tall) {
//		this.tall = tall;
//	}
//
//	public double getDiff() {
//		return diff;
//	}
//
//	public void setDiff(double diff) {
//		this.diff = diff;
//	}
//
//	private int tall;
//	private double diff;
//
//	public Student(String name, int tall) {
//		this.name = name;
//		this.tall = tall;
//	}
//
//	public void printStudent() {
//		System.out.printf("%s\t%d\t%6.2f\n", name, tall, diff);
//	}
//
//}
//
//class Manager {
//	static int studentIdx = 0;
//	private Student[] student; // 객체 배열을 하나의 참조변수로 관리하기
//
//	Manager(int length) { // length는 name.length임.
//		student = new Student[length]; // 객체 배열 생성하기
//	}
//
//	// manager 객체의 append 메소드를 실행하여 학생 객체 등록
//	// append()는 manager내의 학생 객체 배열에 순서적으로 삽입한다.
//	public void append(Student student) {
//		// 여기서 객체 배열을 각각 메모리 할당 해주어야 할 것 같다.
//		this.student[studentIdx] = student; // 메모리 할당?
//		studentIdx++;
//	}
//
//	public void displayAll() {
//		System.out.printf("name\ttall\tdifference\n");
//		for (int i = 0; i < student.length; i++) {
//			student[i].printStudent();
//		}
//	}
//
//	public void calculateMean() {
//		double mean = 0;
//		for (int i = 0; i < student.length; i++) {
//			mean += student[i].getTall();
//		}
//		mean /= student.length;
//		for (int i = 0; i < student.length; i++) {
//			student[i].setDiff(student[i].getTall() - mean);
//		}
//		System.out.printf("tall mean: %.2f\n\n", mean);
//		displayAll();
//	}
//
//	public void findStudent(String pname) {
//		for (int i = 0; i < student.length; i++) {
//			if (student[i].getName().equals(pname)) {
//				student[i].printStudent();
//				return;
//			}
//		}
//		System.out.println(pname + ": not found.");
//	}
//
//}
//
//public class Chapter4_1 {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String[] name = { "bob", "john", "alice", "nana", "tom", "sandy" };
//		int[] tall = { 172, 183, 168, 161, 171, 172 };
//
//		// Manager 클래스의 객체변수 manager 선언 및 객체 생성
//		// name.length는 manager내에 생성될 학생배열의 길이임
//		Manager manager = new Manager(name.length);
//
//		System.out.print("input continuously 6 indices(index) of array: ");
//		// 이는 Manager에 추가할 학생들의 인덱스 순서이다.
//
//		// 0 ~ 5 사이의 서로 다른 6개의 숫자(임의의 순서)들을 연속적으로 입력 받으면서
//		// 학생 객체를 생성한 후 manager에 등록한다.
//		for (int i = 0; i < name.length; i++) {
//			int j = in.nextInt(); // 0 1 2 3 4 5가 들어온다
//			// manager 객체의 append 메소드를 실행하여 학생 객체 등록
//			// append()는 manager내의 학생 객체 배열에 순서적으로 삽입한다.
//			manager.append(new Student(name[j], tall[j]));
//		}
//
//		while (true) {
//			System.out.print("\n0.Exit 1.DisplayAll 2.CalculateMean 3.FindStudent >> ");
//			int input = in.nextInt();
//			if (input == 0)
//				break;
//			switch (input) {
//			case 1:
//				manager.displayAll();
//				break;
//			case 2:
//				manager.calculateMean();
//				break;
//			case 3:
//				System.out.print("name? ");
//				String pname = in.next();
//				manager.findStudent(pname);
//				break;
//			}
//		}
//		in.close();
//	}
//}