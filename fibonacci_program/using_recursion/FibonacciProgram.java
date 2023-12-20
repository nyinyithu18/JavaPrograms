package fibonacci_program.using_recursion;

public class FibonacciProgram {

	int nOne = 0;
	int nTwo = 1;
	int nThree;

	public void fibonacciProcess(int count) {
		if (count > 0) {
			nThree = nOne + nTwo;
			nOne = nTwo;
			nTwo = nThree;
			System.out.print(" " + nThree);

			fibonacciProcess(count - 1);

		}
	}

	public static void main(String[] args) {

		int count = 10;

		FibonacciProgram fibonacci = new FibonacciProgram();
		fibonacci.fibonacciProcess(count);
	}

}
