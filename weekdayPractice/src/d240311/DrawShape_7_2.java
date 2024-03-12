package d240311;
public class DrawShape_7_2 {

	public static void main(String[] args) {
		Point[] p = {	 new Point(100, 100)
						,new Point(140,  50)
						,new Point(200, 100)
		};
		
		Triangle t = new Triangle(p);
		Circle c = new Circle(c);
		
		t.draw();
		c.draw();
	}
}

class Shape{
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point{
	int x, y;
	
	Point(){ }
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	String getXY() {
		return "("+x+", "+y+")";
	}
}

class Circle extends Shape{
	Point center;
	int r;
	
	Circle(){
		this(new Point(0, 0), 100);
	}
	
	Circle(Point center, int n){
		this.center = center;
		this.r = r;
	}
	
	void draw() {
		System.out.println();
	}
}

