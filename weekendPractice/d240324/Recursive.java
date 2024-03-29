package d240324;

public class Recursive {
	void Recursive(int n) {
		if (n ==0 ) {
			return;
		}
		Recursive(n-1);
		PutInt(n);
	}
}
