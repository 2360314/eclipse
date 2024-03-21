package d240315;
import java.awt.*;

public class CheckBoxEx {

	public static void main(String[] args) {
		Frame f = new Frame("Button Test");
		
		Panel p = new Panel();
		
		Checkbox ck1 = new Checkbox("11", true);
		Checkbox ck2 = new Checkbox("22");
		Checkbox ck3 = new Checkbox("33");
		Checkbox ck4 = new Checkbox("44");
		
		p.add(ck1);
		p.add(ck2);
		p.add(ck3);
		p.add(ck4);
		
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(300,300);
		f.setVisible(true);
	}
}

