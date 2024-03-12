package d240311;

class Car25{
	String color;
	String gearType;
	int door;
	
	public Car25() {
		this("White", "auto", 4);	// Car(String color, String gearType, int door); 와 같음
	}
	
	public Car25(String color) {
		this(color, "auto", 4);		// 
	}
	
	public Car25(String c, String g, int d) {
		this.color = c;
		this.gearType = g;
		this.door = d;
		
	}
	
	public Car25(int door) {
		this("White", "auto", door);
	}
}

public class CarTest2_6_25 {

	public static void main(String[] args) {
		Car25 c1 = new Car25();
		Car25 c2 = new Car25("blue");
		Car25 c3 = new Car25("Black", "manual", 3);
		Car25 c4 = new Car25(8);
		
		System.out.println(c1.color+"\t"+c1.gearType+"\t"+c1.door);
		System.out.println(c2.color+"\t"+c2.gearType+"\t"+c2.door);
		System.out.println(c3.color+"\t"+c3.gearType+"\t"+c3.door);
		System.out.println(c4.color+"\t"+c4.gearType+"\t"+c4.door);

	}

}
