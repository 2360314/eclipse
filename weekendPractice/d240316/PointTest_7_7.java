package d240316;

public class PointTest_7_7 {

	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println("p3.x = "+p3.x);
		System.out.println("p3.y = "+p3.y);
		System.out.println("p3.z = "+p3.z);
		
		Point3D p3n = new Point3D(x, y, z);
		System.out.println("p3n.x = "+p3n.x);
		System.out.println("p3n.y = "+p3n.y);
		System.out.println("p3n.z = "+p3n.z);
		

	}

}

class Point{
	int x = 10;
	int y = 20;
	char c,d;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(char c, char d){
		this.c = c;
		this.d = d;
	}
	
	String getLocation() {
		return "x : "+x+"y :" + y;
	}
}

class Point3D extends Point{
	int z = 30;
	char a,b,c;
	Point3D(){
		this(100,200,300);
	}
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	Point3D(char a, char b, char c){
		super(a,b);
		this.c = c;
	}
	
}