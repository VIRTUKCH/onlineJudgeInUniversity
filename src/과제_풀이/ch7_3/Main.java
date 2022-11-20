package 과제_풀이.ch7_3;

import java.util.Scanner;
import java.util.Vector;

enum MAIN_MENU {
	Insert_front(0), Insert_rear(1), Remove_front(2), Remove_rear(3), Move_front(4), Move_rear(5), list_all(6), Exit(7);

	MAIN_MENU(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

enum SHAPE_TYPE {
	Shape_Rect(0), Shape_Circle(1), Shape_Line(2);

	SHAPE_TYPE(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

enum GraphicMenu {
	EXIT(0), RECT(1), CIRCLE(2), LINE(3);

	GraphicMenu(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

//*****************************************************************************

/******************************************************************************
 * UI 클래스 선언 및 구현 모든 멤버 함수들이 모두 정적(static) 함수임 입력과 출력을 담당하는 전역 함수들의 모음 static 함수
 * 호출은 예제 4-11 참조
 *******************************************************************************/

class UI {
	// msg를 출력한 후 정수 값 하나를 입력 받아 리턴
	// MAIN_MENU 선택을 위한 메소드
	static int getMainMenu(Scanner scanner) {
		System.out.println("Select one operation  "); // 안내 문자 출력
		System.out.print("Insert(Front):" + MAIN_MENU.Insert_front.value() + ", " + "Insert(Rear):"
				+ MAIN_MENU.Insert_rear.value() + ", " + "Remove(Front):" + MAIN_MENU.Remove_front.value() + ", "
				+ "Remove(Rear):" + MAIN_MENU.Remove_rear.value() + "\n" + "Move(Front):" + MAIN_MENU.Move_front.value()
				+ ", " + "Move(Rear):" + MAIN_MENU.Move_rear.value() + ", " + "Print List:" + MAIN_MENU.list_all.value()
				+ ", " + "Exit:" + MAIN_MENU.Exit.value() + " >> "); // 연산 종류 출력

		int nMenu = scanner.nextInt(); // 사용자가 선택한 연산 입력

		return nMenu; // 사용자가 선택한 연산 리턴
	}

	// msg를 출력한 후 정수 값 하나를 입력 받아 리턴
	// SHAPE_TYPE 선택을 위한 메소드
	static int getShape(Scanner scanner) {
		System.out.println("Select one Shape  "); // 안내 문자 출력
		System.out.print("Rectangle:0, Circle:1, Line:2 >> "); // Shape 종류 출력

		return scanner.nextInt();// 사용자가 선택한 Shape 입력 + // 사용자가 선택한 Shape 리턴
	}

	// 안내 msg를 매개 변수로 받아 출력하고
	// 삽입할 도형의 Point 정보 하나를 입력 받아 리턴
	static public Point getWidthHeight(Scanner scanner, String msg) {
		System.out.print(msg); // msg 출력 // "Enter point coordinates (enter two integers) >> ";
		int width, height;// width, height 변수 선언

		width = scanner.nextInt(); // width 입력
		height = scanner.nextInt();// height 입력

		return new Point(width, height);// 포인트 객체 생성 + // 포인트 객체 리턴
	}

	// 안내 msg를 매개 변수로 받아 출력하고
	// Circle 객체의 반지름 하나를 입력 받아 리턴
	static public int getRadius(Scanner scanner, String msg) {
		System.out.print(msg); // msg 출력 // "Enter the radius (enter one integer) >> ";
		int radius; // radius 변수 선언
		radius = scanner.nextInt();// radius 입력
		return radius;// radius 리턴
	}

	static GraphicMenu getGraphicMenu(Scanner scanner) {
		System.out.println("***** Graphic Management Menu ******");
		System.out.println("* " + GraphicMenu.EXIT.value() + ".Exit  " + GraphicMenu.RECT.value() + ".Rect  "
				+ GraphicMenu.CIRCLE.value() + ".Circle  " + GraphicMenu.LINE.value() + ".Line *");
		System.out.println("************************************");
		System.out.print("Menu item number? ");
		GraphicMenu menu[] = GraphicMenu.values();
		return menu[scanner.nextInt()];
	}
}

/*****************************************************************************
 * Circle 객체의 중심점 Line 객체의 두 점 Rectangle 객체의 두 꼭지점의 정보를 저장할 자료형
 *****************************************************************************/

class Point {
	int x; // 점의 x 좌표 값
	int y; // 점의 y 좌표 값

	// 객체 초기화: x, y 좌표 초기화
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// x, y 좌표를 각각 width, height만큼 이동시킨다.
	public void move(int width, int height) {
		this.x += width;
		this.y += height;
	}

	// (x,y) 좌표 문자열을 리턴, 예) "(10, 15)"
	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

//*****************************************************************************
// Shape의 추상 클래스 선언
abstract class Shape {
	public abstract String draw(); // 정보 출력

	public abstract void move(int width, int height); // 좌표 이동
};

/*****************************************************************************
 * Line 클래스 선언 및 구현
 *****************************************************************************/

class Line extends Shape {
	private Point p1; // 사각형의 왼쪽 위쪽 좌표
	private Point p2; // 사각형의 오른쪽 아래쪽 좌표

	// 생성자 작성
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// Shape 의 draw 메소드 오버라이딩
	// 실질적인 자료를 리턴하는 함수는 toString
	// 함수 내부에서 toString() 메소드 호출
	@Override
	public String draw() {
		return toString();
	}

	// 화면에 라인의 좌표 값을 출력, 예) "Line (10,15) (20,30)"
	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return ("Line " + p1 + " " + p2);
	}

	// 기존 객체의 위치를 width, height만큼 옮긴다.
	public void move(int width, int height) {
		// 기존 p1의 위치를 width, height만큼 옮긴다.
		p1.move(width, height);
		// 기존 p2의 위치를 width, height만큼 옮긴다.
		p2.move(width, height);
	}
}

/*****************************************************************************
 * Rect 클래스 선언 및 구현 Line 클래스를 참고하여 작성
 *****************************************************************************/

class Rect extends Shape {
	private Point p1; // 사각형의 왼쪽 위쪽 좌표
	private Point p2; // 사각형의 오른쪽 아래쪽 좌표

	// 생성자: 멤버 초기화
	Rect(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// Shape 의 draw 메소드 오버라이딩
	@Override
	public String draw() {
		return toString();
		// 실질적인 자료를 리턴하는 함수는 toString
		// 함수 내부에서 toString() 메소드 호출
	}

	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return ("Rectangle " + p1 + " " + p2);
		// 화면에 사각형의 좌표 값을 출력, 예) "Rectangle (10,15) (20,30)"
	}

	public void move(int width, int height) {
		// 기존 객체의 위치를 width, height만큼 옮긴다.
		p1.move(width, height);
		p2.move(width, height);

	}
}

/*****************************************************************************
 * Circle 클래스 선언 및 구현 Line 클래스를 참고하여 작성
 *****************************************************************************/

class Circle extends Shape {
	private Point center; // 원의 중심 좌표
	private int radius; // 반지름의 길이

	// 생성자: 멤버 초기화
	Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}

	// Shape 의 draw 메소드 오버라이딩
	@Override
	public String draw() {
		return toString();
		// 실질적인 자료를 리턴하는 함수는 toString
		// 함수 내부에서 toString() 메소드 호출
	}

	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return ("Circle " + radius + " " + center);
		// 화면에 반지름과 중심 좌표 값을 출력, 예) "Circle 5 (20,30)"
	}

	public void move(int width, int height) {
		center.move(width, height);
		// 기존 객체의 위치를 width, height만큼 옮긴다.
	}
}

//*****************************************************************************
//double linked list를 위한 인터페이스 선언
interface LinkedList<T> {
	public abstract void add_front(T value); // 리스트 맨 앞에 삽입

	public abstract void add_rear(T value); // 리스트 맨 뒤에 삽입

	public abstract boolean isEmpty(); // 리스트가 empty인지 확인

	public abstract T remove_front(); // 리스트 맨 앞에서 삭제

	public abstract T remove_rear(); // 리스트 맨 뒤에서 삭제
}

//*****************************************************************************
// Shape을 이용한 double linked list 작성
class ShapeList<T> implements LinkedList<T> {

	private Vector<T> vector;

	ShapeList() {
		this.vector = new Vector<>();// ShapeList() 생성자에서 Vector< Shape > 객체를 생성해서 초기화하라.
	}

	public ShapeList(T arr[]) {
		this(); // 기존 ShapeList() 생성자를 호출하여 vector를 생성한다. [예제 4-5 참조]
		for (int i = 0; i < arr.length; i++) {// for문을 이용하여
			// 배열 arr의 각 원소 arr[i]를 vector에 추가한다.
			vector.add(arr[i]);
		}
	}

	// 리스트의 맨 앞의 노드를 리턴
	public T get_frontValue() {
		if (isEmpty()) { // 리스트가 empty 이면
			return null; // null 리턴
		} else { // 리스트가 empty가 아니면
			return vector.get(0); // 맨 앞의 데이터 리턴, head를 이용하여 getValue 메소드 호출
			// empty가 아닐 경우 Vector< T >의 적절한 메소드를 활용하여 vector의 첫번째 원소를 반환
		}
	}

	// 리스트의 맨 뒤의 노드를 리턴
	public T get_rearValue() {
		if (isEmpty()) { // 리스트가 empty 이면
			return null; // null 리턴
		} else { // 리스트가 empty가 아이면
			return vector.lastElement(); // 맨 뒤의 데이터 리턴, tail을 이용하여 getValue 메소드 호출
			// empty가 아닐 경우 Vector< T >의 적절한 메소드를 활용하여 vector의 마지막 원소를 반환
		}
	}

	// 리스트 맨 앞에 노드 삽입
	// 인터페이스 메소드 구현
	public void add_front(T value) {
		vector.add(0, value);
	}

	// 리스트 맨 뒤에 노드 삽입
	// 인터페이스 메소드 구현
	public void add_rear(T value) {
		vector.add(value);
	}

	// list 가 empty인지 확인
	// 인터페이스 메소드 구현
	public boolean isEmpty() {
		return vector.isEmpty();
	}

	// 리스트 맨 앞에서 삭제
	// 인터페이스 메소드 구현
	// remove_rear 참고
	public T remove_front() {
		if (isEmpty()) { // list가 empty인지 확인
			return null; // empty 이면 null 리턴
		}
		return vector.remove(0);
	}

	// 리스트 맨 뒤에서 삭제
	// 인터페이스 메소드 구현
	public T remove_rear() {
		if (isEmpty()) { // list가 empty인지 확인
			return null; // empty 이면 null 리턴
		}
		return vector.remove(vector.size() - 1);
	}

	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(""); // 가변형 String 변수 result 선언
		for (int i = 0; i < vector.size(); i++) {
			result.append("[" + vector.get(i) + "]\n");
		}

		return result.toString();
	}
}

interface Factory<T> {
	String msgpoint = "Enter point coordinates (enter two integers) >> ";

	ShapeList<T> generateShapeList(); // ShapeList 객체를 생성한 후 반환한다.

	T generateShape(Scanner scanner); // 사용자로부터 그래픽 객체 정보를 입력 받은 후
} // 그래픽 객체를 생성하여 반환함

// 그런 다음 위 Factory 인터페이스를 구현하는 아래 클래스 ShapeFactory를 Main 클래스 앞쪽에 배치하라.
// 그런 후 기존의 GraphicEditor의 createShape(Scanner scanner) 메소드 내에 있던 코드 전부를
// 아래 generateShape(Scanner scanner)로 옮겨라. (복사가 아니고)

//class ShapeFactory implements Factory {
//	private Shape shapes[] = { // 프로그램 초기에 생성될 그래픽 객체들
//			new Rect(new Point(1, 1), new Point(2, 2)), new Rect(new Point(3, 3), new Point(4, 4)),
//			new Rect(new Point(5, 5), new Point(6, 6)), new Circle(1, new Point(2, 2)), new Circle(3, new Point(4, 4)),
//			new Circle(5, new Point(6, 6)), new Line(new Point(1, 1), new Point(2, 2)),
//			new Line(new Point(3, 3), new Point(4, 4)), new Line(new Point(5, 5), new Point(6, 6)), };
//
//	public ShapeList generateShapeList() { // GraphicEditor의 생성자에서 호출함
//		return new ShapeList(shapes); // 그래픽 객체들을 관리하는 ShapeList 객체 생성
//		// 이문장은 GraphicEditor 생성자에 의해 호출된다.
//		// 리턴된 list는 위 shapes[]의 9개의 객체들을 포함하고 있다.
//	}
//
//	public Shape generateShape(Scanner scanner) {
//		SHAPE_TYPE shapeType;
//		Point p1, p2;
//		int radius;
//
//		int type = UI.getShape(scanner);
//
//		shapeType = SHAPE_TYPE.values()[type];
//		Shape shape = null;
//
//		String msgpoint = "Enter point coordinates (enter two integers) >> ";
//		String msgradius = "Enter the radius (enter one integer) >> ";
//
//		switch (shapeType) {
//		case Shape_Rect: // 사각형
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Rect(p1, p2);
//			break;
//		case Shape_Circle: // 원
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			radius = UI.getRadius(scanner, msgradius);
//			shape = new Circle(radius, p1);
//			break;
//		case Shape_Line: // 라인
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Line(p1, p2);
//			break;
//
//		}
//		return shape;
//	}
//}

class GraphicEditor<T extends Shape> {

	private ShapeList<T> list; // 7-2에서 새로 추가된 멤버
	private Factory<T> factory; // 7-2에서 새로 추가된 멤버
	private Scanner scanner; // 7-2에서 새로 추가된 멤버

	private T createShape(Scanner scanner) {
		return factory.generateShape(scanner);
	}

	public GraphicEditor(Factory<T> factory, Scanner scanner) {
		this.factory = factory;
		list = factory.generateShapeList(); // list 초기화
		this.scanner = scanner;
	}

	public void run() {
//		ShapeList list = new ShapeList(); // shape 리스트를 관리할 객체 생성 -> 7-2에서 주석처리한다.
//		Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 스캐너 객체 생성 -> 7-2에서 주석처리한다.

		T shape = null; // 임시로 사용할 Shape 레퍼런스 변수 선언
		boolean bLoop = true; // 반복문 관리용 부울린 변수
		Point p1;
		String msgpoint = "The two integers to move along the X and Y axes (enter two integers) >> ";

		while (bLoop) {
			System.out.print(list);
			int n = UI.getMainMenu(scanner); // 메뉴 정보 읽어 오기
			MAIN_MENU menu = MAIN_MENU.values()[n]; // 열겨형의 정보로 변환

			switch (menu) {
			case Insert_front: // 리스트 앞에 삽입
				shape = createShape(scanner); // 삽입을 위한 객체 생성
				list.add_front(shape); // 리스트 앞에 삽입
				break;
			case Insert_rear: // 리스트 뒤에 삽입
				shape = createShape(scanner); // 삽입을 위한 객체 생성
				list.add_rear(shape); // 리스트 뒤에 삽입
				break;
			case Remove_front: // 리스트 앞에서 삭제
				shape = list.remove_front(); // 리스트 앞에서 삭제 (리턴 값을 shape에 저장)
				break;
			case Remove_rear: // 리스트 뒤에서 삭제
				shape = list.remove_rear(); // 리스트 뒤에서 삭제 (리턴 값을 shape에 저장)
				break;
			case Move_front: // 리스트 첫번째 객체 이동
				shape = list.get_frontValue(); // get_frontValue 메소드를 이용해서 첫번째 shape 정보 가지고 오기
				if (shape != null) { // shape 이 널이 아니면
					p1 = UI.getWidthHeight(scanner, msgpoint); // 이동을 위한 정보 받기, UI.getWidthHeight 이용
					shape.move(p1.x, p1.y); // 좌표이동
				}
				break;
			case Move_rear: // 리스트 마지막 객체 이동
				shape = list.get_rearValue(); // get_rearValue메소드를 이용해서 마지막 shape 정보 가지고 오기
				if (shape != null) { // shape 이 널이 아니면
					p1 = UI.getWidthHeight(scanner, msgpoint); // 이동을 위한 정보 받기, UI.getWidthHeight 이용
					shape.move(p1.x, p1.y); // 좌표이동
				}
				break;

			case list_all: // 리스트 정보 출력
//				System.out.print(list.toString());
				break;
			case Exit:
				bLoop = false; // 끝내기
			}
		}
//		scanner.close(); -> 7-2에서 주석처리한다.
	}
}

class RectFactory implements Factory<Rect> // 사각형 객체를 생성하는 클래스
{
	private Rect rects[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Rect(new Point(1, 1), new Point(2, 2)), new Rect(new Point(3, 3), new Point(4, 4)),
			new Rect(new Point(5, 5), new Point(6, 6)), };

	public ShapeList<Rect> generateShapeList() { // ShapeList 생성
		return new ShapeList<>(rects);
		// 이문장은 GraphicEditor 생성자에 의해 호출된다.
		// 리턴된 list는 위 rects[]의 3개의 Rect 객체들을 포함하고 있다.
	}

	// 사용자로부터 사각형 정보를 입력 받은 후 사각형 객체를 생생하여 반환함. 기존 ShapeFactory의
	// generateShape()의 switch 코드들 중 사각형 객체 생성하는 코드만 발췌해서 삽입
	public Rect generateShape(Scanner scanner) {
		Point p1 = UI.getWidthHeight(scanner, msgpoint);
		Point p2 = UI.getWidthHeight(scanner, msgpoint);
		return new Rect(p1, p2);
	}
}

class CircleFactory implements Factory<Circle> // 원 객체를 생성하는 클래스
{
//	private String msgradius = "Enter the radius (enter one integer) >> ";

	private Circle circles[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Circle(1, new Point(2, 2)), new Circle(3, new Point(4, 4)), new Circle(5, new Point(6, 6)), };

	@Override
	public ShapeList<Circle> generateShapeList() { // 1. generateShapeList() 메소드 구현
		return new ShapeList<>(circles);
	}

	@Override
	public Circle generateShape(Scanner scanner) { // 2. generateShape() 메소드 구현할 것
//		SHAPE_TYPE shapeType;
		Point p1;
		int radius;

//		int type = UI.getShape(scanner);
//
//		shapeType = SHAPE_TYPE.values()[type];
		Shape shape = null;

		String msgpoint = "Enter point coordinates (enter two integers) >> ";
		String msgradius = "Enter the radius (enter one integer) >> ";

//		switch (shapeType) {
//		case Shape_Rect: // 사각형
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Rect(p1, p2);
//			break;
//		case Shape_Circle: // 원
		p1 = UI.getWidthHeight(scanner, msgpoint);
		radius = UI.getRadius(scanner, msgradius);
		shape = new Circle(radius, p1);
//			break;
//		case Shape_Line: // 라인
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Line(p1, p2);
//			break;
//
//		}
		return (Circle) shape; // shape가 조상이긴 하지만, shape은 abstract class임. 그래서 캐스팅 해야되는듯?
	}
}

// 위 generateShape()은 기존 ShapeFactory의
// generateShape()의 switch 코드들 중 원 객체 생성하는 코드만 발췌해서 삽입

class LineFactory implements Factory<Line> // 선 객체를 생성하는 클래스
{
	private Line lines[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Line(new Point(1, 1), new Point(2, 2)), new Line(new Point(3, 3), new Point(4, 4)),
			new Line(new Point(5, 5), new Point(6, 6)), };

	@Override
	public ShapeList<Line> generateShapeList() { // generateShapeList() 메소드 구현
		return new ShapeList<>(lines);
	}

	@Override
	public Line generateShape(Scanner scanner) { // generateShape() 메소드 구현할 것
//		SHAPE_TYPE shapeType;
		Point p1, p2;
//		int radius;

//		int type = UI.getShape(scanner);
//
//		shapeType = SHAPE_TYPE.values()[type];
		Shape shape = null;

		String msgpoint = "Enter point coordinates (enter two integers) >> ";
//		String msgradius = "Enter the radius (enter one integer) >> ";

//		switch (shapeType) {
//		case Shape_Rect: // 사각형
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Rect(p1, p2);
//			break;
//		case Shape_Circle: // 원
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			radius = UI.getRadius(scanner, msgradius);
//			shape = new Circle(radius, p1);
//			break;
//		case Shape_Line: // 라인
		p1 = UI.getWidthHeight(scanner, msgpoint);
		p2 = UI.getWidthHeight(scanner, msgpoint);
		shape = new Line(p1, p2);
//			break;
//
//		}
		return (Line) shape; // shape가 조상이긴 하지만, shape은 abstract class임. 그래서 캐스팅 해야되는듯?
	}

	// 위 generateShape()은 기존 ShapeFactory의
	// generateShape()의 switch 코드들 중 Line 객체 생성하는 코드만 발췌해서 삽입
}

class GraphicManager {
	private Scanner scanner;
	private GraphicEditor<Rect> rectEditor;
	private GraphicEditor<Circle> circleEditor;
	private GraphicEditor<Line> lineEditor;

	// 각각의 Rect, Circle 또는 Line을 전용으로 관리하는 GraphicEditor< >를 미리 생성해 놓는다.
	// 각 GraphicEditor는 해당 그래픽 객체를 생성하는 Factory 객체를 가지며,
	// 이 Factory 객체를 통해 ShapList< >와 해당 그래픽 객체만을 전적으로 생성한다.
	GraphicManager() {
		scanner = new Scanner(System.in);
		rectEditor = new GraphicEditor<Rect>(new RectFactory(), scanner);
		circleEditor = new GraphicEditor<Circle>(new CircleFactory(), scanner);
		lineEditor = new GraphicEditor<Line>(new LineFactory(), scanner);
	}

	// 사용자가 Rect, Circle, Line 중 하나를 선택하게 하고
	// 선택된 그래픽 객체들을 전용으로 관리하는 GraphicEditor< >의 run() 메소드를 호출한다.
	void run() {
		while (true) {
			GraphicMenu menu = UI.getGraphicMenu(scanner); // 메뉴 항목 읽어 오기
			if (menu == GraphicMenu.EXIT)
				break;
			switch (menu) {
			case RECT:
				System.out.println("\nGraphicEditor<Rect>");
				rectEditor.run();
				break;
			case CIRCLE:
				System.out.println("\nGraphicEditor<Circle>");
				circleEditor.run();
				break;
			case LINE:
				System.out.println("\nGraphicEditor<Line>");
				lineEditor.run();
				break;
			default:
				System.out.println("WRONG menu item");
				break;
			}
			System.out.println();
		}
		scanner.close();
	}
}

public class Main {
	public static void main(String[] args) {
		GraphicManager m = new GraphicManager();
		m.run();
		System.out.println("\nGood Bye");
	}
}
