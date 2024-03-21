package d240315;

import java.awt.*;


public class RadioCheckboxEx {

	public static void main(String[] args) {
		Frame f = new Frame("Button Test");
		
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox radio1 = new Checkbox("11",group, true);
		Checkbox radio2 = new Checkbox("22",group, false);
		Checkbox radio3 = new Checkbox("33",group, false);
		Checkbox radio4 = new Checkbox("44",group, false);
		
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		p.add(radio4);
		
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(300,300);
		f.setVisible(true);

	}
	
}
