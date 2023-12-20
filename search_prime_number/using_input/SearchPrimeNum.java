
package search_prime_number.using_input;

import java.util.Scanner;

public class SearchPrimeNum {

	public SearchPrimeNum() {
		inputNum();
	}

	public void inputNum() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Number One > ");
		int inputOne = Integer.parseInt(sc.nextLine());

		System.out.print("Number Two > ");
		int inputTwo = Integer.parseInt(sc.nextLine());

		System.out.println("Prime Number is between " + inputOne + " and " + inputTwo + ".");

		System.out.print("Prime NUmber are > ");
		boolean flag;
		for (int i = inputOne; i < inputTwo + 1; i++) {
			if (i == 0 || i == 1) {
				continue;
			}
			flag = true;

			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

	public static void main(String[] args) {

		new SearchPrimeNum();
	}

}
