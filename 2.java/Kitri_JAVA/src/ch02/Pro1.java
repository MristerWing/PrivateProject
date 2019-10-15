package ch02;

public class Pro1 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (float) ((5.0 / 9.0) * ((float)fahrenheit - 32.0));
		System.out.println("Fahrenheit: " + fahrenheit);
		System.out.println("Celcius: " + String.format("%.2f", celcius));
	}

}
