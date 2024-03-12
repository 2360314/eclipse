package d240311;
class Car{
	String color;
	String gearType;
	int door;
	
	public Car() {
		
	}
	
	public Car(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
}
public class CarTest_6_24 {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "Red";
		c1.gearType = "manual";
		c1.door = 2;
		
		Car c2 = new Car("White", "auto", 4);

		System.out.println("c1 = "+"\t"+c1.color+"\t"+c1.gearType+"\t"+c1.door);
		System.out.println("c2 = "+"\t"+c2.color+"\t"+c2.gearType+"\t"+c2.door);
	}

}
