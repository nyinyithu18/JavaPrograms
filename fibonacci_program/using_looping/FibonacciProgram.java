package fibonacci_program.using_looping;

public class FibonacciProgram {

	int nOne = 0;
	int nTwo = 1;
	int nThree;
	int count = 10;

	private void fibonacciProcess() {
		for (int i = 0; i < count; i++) {
			nThree = nOne + nTwo;
			nOne = nTwo;
			nTwo = nThree;
			System.out.println(" " + nThree);
		}
	}

	public static void main(String[] args) {

		FibonacciProgram fibonacci = new FibonacciProgram();
		fibonacci.fibonacciProcess();

	}

}
