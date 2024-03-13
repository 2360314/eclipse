package d240310;
class Card{
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
}
public class CardTest6_5 {
	public static void main(String[] args) {
		System.out.println("Card.width"+Card.width);
		System.out.println("Card.height"+Card.height);
	
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Space";
		c2.number = 3;
		
		System.out.println("C1 = "+c1.kind+" "+ c1.number+" "+c1.width+" "+c1.height);
		System.out.println("C2 = "+c2.kind+" "+ c2.number+" "+c2.width+" "+c2.height);

		c1.width = 50;
		c2.height = 80;
		

		System.out.println("C1 = "+c1.kind+" "+ c1.number+" "+c1.width+" "+c1.height);
		System.out.println("C2 = "+c2.kind+" "+ c2.number+" "+c2.width+" "+c2.height);
		
		}

}
