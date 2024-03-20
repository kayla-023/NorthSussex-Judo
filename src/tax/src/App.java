import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner xerox = new Scanner(System.in);

        String name;
		double grossPay, tax, philHealth, sss, hourlyRate, netPay, taxes;
		
		System.out.println("\nEnter Employee's name: ");
		name = xerox.nextLine();
		
		System.out.println("Employee's hourly rate:");
		hourlyRate = xerox.nextDouble();
		
		
		grossPay = hourlyRate * 9 * 22;
		tax = grossPay * .12;
	    philHealth = grossPay * .03;
	    sss = grossPay * .05;
	    taxes = tax + philHealth + sss;
	    netPay = grossPay - taxes;
		

		System.out.println("\tEmployee's Name: "+name);
		System.out.println("\tHourly Rate: "+hourlyRate);
		System.out.println("\tGross Pay: "+grossPay);
		System.out.println("\tTax: "+tax);
		System.out.println("\tPhilHealth: "+philHealth);
		System.out.println("\tSSS: "+sss);
		System.out.println("\tNet Pay: "+netPay);
  
    }
}
