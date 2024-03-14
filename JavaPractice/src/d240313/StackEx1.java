package d240313;
import java.util.Stack;

public class StackEx1 {

	public static void main(String[] args) {
		String[] groupA = {"우즈백", "쿠웨이트","사우디","대한민국"};
		
		Stack<String> stack = new Stack<String>();
		for(String n: groupA) {
			stack.push(n);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
