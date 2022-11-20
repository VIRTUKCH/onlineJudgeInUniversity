package 과제풀이.ch4_1;

class Menu1 {
	private int id; // 메뉴의 번호
	private String name; // 메뉴의 이름
	private double price; // 메뉴의 가격

	Menu1(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

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

	public void print() { // 메뉴 이름을 프린트하는 함수
		System.out.println(id + ": " + name + " [" + price / 1000 + "]");
	}
}

class Menuboard1 {
	static Menu1[] boards; // 이름이 좋지 않음
	// 왜 static으로 해야할까? -> static 메서드는 static 멤버 변수만 사용할 수 있다.
	// 어차피 객체생성도 안하고 사용할 메서드일텐데
	// 또한, 이렇게 클래스가 다른 클래스에 들어와있는 경우를 '포함 관계'라고 한다.
	// 마지막으로, 멤버 변수에다가 메모리 할당하는 것은 정석에서 벗어난 행위라고 한다.
	static String[] menus = { "Americano", "Latte", "Mocca", "Cappuccino", "Milk Tea", "Chi Tea", "Lemon Sweet",
			"Jamong Honey" };
	static int[] prices = { 4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100 };

	private Menuboard1() {
	}
	// private 생성자 : 외부에서 new 연산자로 객체 생성을 하지 못하도록 조치한다.
	// Reflection API로 class를 얻어오는 말일까 했는데 그건 아닌듯
	// private 생성자를 사용했다 -> 생성자를 통해 인스턴스 생성을 하지 말아라 ->
	// makeBoard메서드는 static 메서드로 작성해라 -> makeBoard에 쓰이는 변수는 static 변수로 써라

	public static Menuboard1 makeBoard() { // Menuboard1 클래스에 makeBoard 메소드를 정의한다.
		Menuboard1.boards = new Menu1[Menuboard1.menus.length]; // 1. Menu1 배열을 생성
		for (int index = 0; index < Menuboard1.boards.length; index++) {
			Menuboard1.boards[index] = new Menu1(index + 1, menus[index], prices[index]); // 2. Menu1 배열에 메모리를 할당

			// 생성자를 통해서 객체를 생성하기 바란다.
//			Menuboard1.boards[index].setId(index + 1);
//			Menuboard1.boards[index].setName(menus[index]);
//			Menuboard1.boards[index].setPrice(prices[index]);
		}
//		Menuboard1 m = new Menuboard1();
		return new Menuboard1();
		/*
		 * 결국 return은 Menuboard1 Type으로 해야해. 그러면 어떻게 해야할까? 내가 지금 반환할 수 있는 Menuboard1가
		 * 있나? -> 없음 -> 내가 만들어서 반환해야 함 그러면 Menuboard1를 대충 만들고 반환하고 나서 Menu클래스의
		 * print()메서드로 다 찍어도 되긴 함 하지만 그러면 의미가 떨어지니까, 가능하면 Menuboard1.menus와
		 * Menuboard1.prices를 활용하자 그렇기 위해서는 static 객체로 Menu1[] 배열을 만들어야 하는데, 그 것도
		 * static이어야 한다. 결국 그렇게 객체를 만들고 값을 집어넣고 나서, Menuboard1를 만들어서 반환하게 만들었다. 그런데, 이
		 * 과정에서 굳이 Menuboard1를 반환해야 하는 이유는 무엇이었을까?
		 * 
		 * 학습의 의미로 문제를 이렇게 만드셨을까 생각해보기도 한다. private 생성자를 통해서 문제를 만들면, 객체를 얻어오는 함수를 만들어야
		 * 인스턴스 생성이 가능하기 때문 그러려면 반환타입과, 메서드의 static 여부와, 객체를 생성한 이후에는 static이 필요없다는 사실을
		 * 알아야 문제를 풀 수 있기 때문.
		 */
	}

	public void print() { // 이 메서드는 static 메서드일 필요는 없음
		System.out.println("***** Best Coffee *****");
		for (int index = 0; index < 8; index++) {
			Menuboard1.boards[index].print();
		}
		System.out.println("***********************");
	}
}

public class Main {
	public static void main(String[] args) {
		Menuboard1 mboard = Menuboard1.makeBoard(); // makeBoard는 Static메서드 + Menuboard1를 반환해야 함. + private 생성자
		mboard.print(); //
	}
}