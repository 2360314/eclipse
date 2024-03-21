package d240315;
import java.awt.*;

public class ButtonEx1 {

	public static void main(String[] args) {
		Frame f = new Frame("Button Test");
		
		Panel p = new Panel();
		
//		Button b1 = new Button();
//		Button b2 = new Button("입력2");
//		Button b3 = new Button("입력3");
//		Button b4 = new Button("입력4");
	
		
//		b1.setLabel("입력1");
		
//		p.add(b1);
//		p.add(b2);
//		p.add(b3);
//		p.add(b4);
		
		TextField tf1 = new TextField("name input: ", 12);
		TextField tf2 = new TextField("password input: ", 10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(300,300);
		f.setVisible(true);
	}

}
