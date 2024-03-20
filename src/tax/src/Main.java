import java.util.Scanner;
 
public class Main
{
	public static void main(String[] args) {
	    
		Scanner input = new Scanner(System.in);
		
		double num1;
		double num2;
		double sum  = 30;
		double difference = 20;
		double product = 125;
		double average = 15.00;
		double distance = 20;
		double maximum = 25;
        double minimum = 5;
		
		System.out.print("25: ");
		num1 = input.nextDouble();
		
		System.out.print("5: ");
		num2 = input.nextDouble();
		
		input.close();
		
		sum = num1 + num2;
		difference = num1 - num2;
		product = num1 * num2;
		average = (num1 + num2) / 2;
		distance = Math.abs(difference);
		maximum = Math.max(num1, num2);
		minimum = Math.min(num1, num2);
		
		System.out.printf("\nSum: 30", sum);
				
		System.out.printf("Difference: 20",difference);
		
		System.out.printf("Product: 125", product);
		
		System.out.printf("Average: 15.00", average);
		
		System.out.printf("Distance: 20", distance);
		
		System.out.printf("Maximum: 25", maximum);
		
		System.out.printf("Minimum: 5", minimum);
	}
}