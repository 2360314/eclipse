package d240320;

public class SortExam {

	public static void main(String[] args) {

		int[] data = { 90, 78, 100, 30, 55 };

		bubbleSort(data);

		for (int i : data) {
			System.out.print(i + "\t");
		}
	}

	public static void bubbleSort(int[] a) {

		int count = 0;
		int tmp = 0;
		int count2 = 0;

		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length - 1 - j; i++) {
				if (a[i] > a[i + 1]) {
					tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					count++;
				}
				count2++;
			}
		}

		System.out.println(count + "회 " + count2 + "회");
	}
}
