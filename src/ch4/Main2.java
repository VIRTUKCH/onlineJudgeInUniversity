package ch4;

import java.util.Scanner;

class Order { // 4-2에서 새로 만든 클래스
	int[] selectMenuNums; // 메뉴번호를 저장하는 정수배열. 사용자의 입장에서 고른 것임
	int[] sizeOfOrders; // 주문 수량을 저장하는 정수배열. 생성 말고 선언만 하자
	Menuboard menuboard;
	int cnt = 0; // 어디다 쓰는지 잘 모르겠는데, index에 쓰이지 않을까 해서 static으로 저장해봄

//	Order() { // 멤버변수에 배열을 생성하지는 말라고 하니, 생성자에서 배열을 생성하는게 맞겠지? -> 잘 모르겠고 그냥 멤버변수 선언하면서 같이 생성해버렸음
//		selectMenuNums = new int[8];
//		sizeOfOrders = new int[8];
//	}

	Order(int sizeOfOrders, Menuboard menuboard) { // 주분의 개수와 Menubaord를 넘겨 받아 멤버에 저장한다.
		this.menuboard = menuboard; // 내가 가지고 있는 menuboard와 매개변수의 menuboard를 일치시킨다
		this.selectMenuNums = new int[Menuboard.menus.length]; // 메뉴번호를 저장하는 정수배열
		this.sizeOfOrders = new int[Menuboard.menus.length]; // 주문의 수량을 저장하는 정수배열.
		cnt = 0; // cnt는 0으로 초기화하라고 했음 -> 어디다 쓰는지는 잘 모르겠음
	}

	public boolean addMenu(int menuNum, int sizeOfOrders) {
		if (menuNum < 0 || menuNum > 8) {
			System.out.println("Menu id " + menuNum + " doesn't exist in our menuboard");
			return false;
		} else {
			this.selectMenuNums[cnt] = menuNum;
			this.sizeOfOrders[cnt] = sizeOfOrders;
			cnt++;
			System.out.println("Your selected menu is added to the order");
			return true;
		}
	}

	public void print() {
		System.out.println("** Order details **");

		for (int index = 0; index < this.cnt; index++) {

			int indexOfOrder = this.selectMenuNums[index] - 1; // 실제 메뉴번호 -1
//			int price = (int) (this.menuboard[index].getPrice());
//			int price = (int) (this.menuboard.prices[index]) * this.sizeOfOrders[index];
			int price = (int) (this.menuboard.prices[indexOfOrder]) * this.sizeOfOrders[index];

//			 메뉴번호와 주문수량을 저장하는 배열의 내용을 순서적으로 출력한다. 가격도 계산하여 함께 출력할 것.
			System.out.println("Menu: " + this.menuboard.menus[indexOfOrder] + " Qty: " + this.sizeOfOrders[index]
					+ " Price: " + price);

		}
	}
}
//====================================================================================/
//MenuOrder =========================================================================/

class MenuOrder { // 4-2에서 새로 만든 클래스
	public static void makeOrder() {
		Menuboard menuboard = Menuboard.makeBoard(); // Menuboard는 생성자가 private이니까
		Menuboard.print(); // Best Coffee 부분 출력함
		Scanner sc = new Scanner(System.in);
		System.out.print("How many kinds of drinks? ");
		int n = sc.nextInt();

		Order order = new Order(n, menuboard);

//		while (Order.cnt != n) {
//			System.out.print("Menu no? ");
//			int menu_no = sc.nextInt();
//			System.out.print("Quantity? ");
//			int quantity = sc.nextInt();
//			order.addMenu(menu_no, quantity);
//		}

		for (int i = 0; i < n; i++) {
			System.out.print("Menu no? ");
			int menu_no = sc.nextInt();
			System.out.print("Quantity? ");
			int quantity = sc.nextInt();
			if (!order.addMenu(menu_no, quantity)) {
				i = i - 1;
			}
		}

//		System.out.println(Arrays.toString(order.sizeOfOrders));
		order.print();
		sc.close();
	}
}

//====================================================================================/
//Menu =========================================================================/

class Menu {
	private int id; // 메뉴의 번호
	private String name; // 메뉴의 이름
	private double price; // 메뉴의 가격

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void print() {
		System.out.println(id + ": " + name + " [" + price / 1000 + "]");
	} // 메뉴 이름을 프린트하는 함수
}

//====================================================================================/
// Menuboard =========================================================================/

class Menuboard {
	static Menu[] makeInstanceBoards; // 왜 static으로 해야할까? -> static 메서드는 static 멤버 변수만 사용할 수 있다. 어차피 객체 생성도 안하고 사용할
	// 메서드일텐데
	// 또한, 이렇게 클래스가 다른 클래스에 들어와있는 경우를 '포함 관계'라고 한다.
	// 마지막으로, 멤버 변수에다가 메모리 할당하는 것은 기본이 안된 행동이라고 함.
	static String[] menus = { "Americano", "Latte", "Mocca", "Cappuccino", "Milk Tea", "Chi Tea", "Lemon Sweet",
			"Jamong Honey" };
	static int[] prices = { 4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100 };

	private Menuboard() {
	} // private 생성자 : 외부에서 new 연산자로 객체 생성을 하지 못하도록 조치한다.
		// Reflection API로 class를 얻어오는 말일 줄 알았는데 그건 아닌듯
		// private 생성자를 사용했다 -> 인스턴스 생성을 못하게 하겠다 -> 모든 메서드를 static으로 사용해라.

	public static Menuboard makeBoard() { // Menuboard 클래스에 makeBoard 메소드를 정의한다.
		Menuboard.makeInstanceBoards = new Menu[Menuboard.menus.length]; // 1. Menu 배열을 생성
		for (int i = 0; i < Menuboard.makeInstanceBoards.length; i++) {
			Menuboard.makeInstanceBoards[i] = new Menu(); // 2. Menu 배열에 메모리를 할당
			Menuboard.makeInstanceBoards[i].setId(i + 1);
			Menuboard.makeInstanceBoards[i].setName(menus[i]);
			Menuboard.makeInstanceBoards[i].setPrice(prices[i]);
		}
//		Menuboard m = new Menuboard();
		return new Menuboard(); // 결국 return은 Menuboard Type으로 해야해. 그러면 어떻게 해야할까?
		// 내가 지금 반환할 수 있는 Menuboard가 있나?
	}

	public static void print() {
		System.out.println("***** Best Coffee *****");
		for (int i = 0; i < 8; i++) {
			Menuboard.makeInstanceBoards[i].print();
		}
		System.out.println("***********************");
	}
}

//====================================================================================/
//Main =========================================================================/
public class Main2 {
	public static void main(String[] args) {
		MenuOrder.makeOrder();
	}
}