package d240321;
import java.util.Comparator;

public class ListExam {
	// 노드
	class Node<E>{
		private E data;			// 데이터
		private Node<E> next;	// 뒤쪽 포인터(다음 노드 참조)
		
		// 생성자
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
		
	}
	
	private Node<E> head;		// 머리 포인터(머리 노드 참조)
	private Node<E> crnt;		// 선택 포인터(선택 노드 참조)
	
	// 생성자
	public ListExam() {
		head=crnt=null;
	}
	public static void main(String[] args)
	{
		
	}
}
