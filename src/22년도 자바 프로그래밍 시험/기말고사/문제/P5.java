import javax.swing.*;
import java.awt.*;

public class P5 extends JFrame {
	Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY};

	class NorthPanel extends JPanel  {
		NorthPanel () {
			setLayout(new FlowLayout());
			add(new Label("Happy New Year"));	
		}
	}

	class CenterPanel extends JPanel {
	//      코드 추가

	
	}

	class SouthPanel extends JPanel{
	//      코드 추가


	}

	public P5() {
		setTitle("P5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentpane = getContentPane();
		
		contentpane.setLayout(new BorderLayout(1,1));

		contentpane.add(new NorthPanel() , BorderLayout.NORTH);
		contentpane.add(new CenterPanel(), BorderLayout.CENTER);
		contentpane.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(350, 450); // 프레임 크기 300×200 설정
		setVisible(true); // 프레임을 화면에 출력
	}
	public static void main(String[] args) {
		new P5();
	}
}
