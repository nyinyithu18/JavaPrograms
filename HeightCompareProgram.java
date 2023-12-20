package height_compare_program;

import java.util.Scanner;

public class HeightCompareProgram {

	public HeightCompareProgram() {
		compareProcess();
	}

	private void compareProcess() {
		System.out.println("---------------------------\r\nHEIGHT COMPARE PROGRAM\r\n---------------------------");

		Scanner sc = new Scanner(System.in);

		System.out.print("Person One : ");
		double personOne = Double.parseDouble(sc.nextLine());

		System.out.print("Person Two : ");
		double personTwo = Double.parseDouble(sc.nextLine());

		if (personOne > personTwo) {
			System.out.print("\"Person One\" is Taller than \"Person Two\".");
		} else if (personTwo > personOne) {
			System.out.print("\"Person Two\" is Taller than \"Person One\".");
		} else if (personOne == personTwo) {
			System.out.print("\"Person One\" and \"Person Two\" are same height.");
		}
		sc.close();
	}

	public static void main(String[] args) {

		new HeightCompareProgram();
	}

}
