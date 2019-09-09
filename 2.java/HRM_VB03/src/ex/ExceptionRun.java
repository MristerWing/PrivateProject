package ex;

public class ExceptionRun {
	public void run(int input) throws CodeValueNotFoundException {
		if(input <= 0 || input > 9) {
			throw new CodeValueNotFoundException();
		}
	}
}
