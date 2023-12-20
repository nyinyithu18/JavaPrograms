package search_prime_number.using_array;

public class SearchPrimeNum {

	public SearchPrimeNum(int[] num) {

		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0 || num[i] == 1) {
				continue;
				// System.out.println(num[i] + " is not Prime Number");
			}
			int flag = 1;
			// System.out.println("i " + i);
			for (int j = 2; j <= i / 2; j++) {
				// System.out.println("i " + i);
				if (i % j == 0) {
					flag = 2;
					// System.out.println("i " + i);
					// System.out.println("j " + j);
					break;
				}
			}

			if (flag == 1) {
				System.out.println(num[i] + " is Prime Number");
			}
		}
	}

	public static void main(String[] args) {

		int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		new SearchPrimeNum(num);

	}

}
