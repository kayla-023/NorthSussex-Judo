import java.util.Scanner;
public class temperature {
    
    public static void main(String[] args) {
        Scanner xerox = new Scanner(System.in);
        double value;
        int opt;

        System.out.println("Please enter a value:");
        value = xerox.nextDouble();
        xerox.nextLine();

        System.out.println("Please select a conversion:");
        System.out.println("[1] Celsius to Fahrenheit and Kelvin");
        System.out.println("[2] Fahrenheit to Celcius and Kelvin"); 
        opt = xerox.nextInt();

        if(opt == 1){
            System.out.println("The Celcius is: "+value);
            System.out.println("It's value in Fahrenheit: "+(value*(9/5)+32));
            System.out.println("It's value in Kelvin: "+(value+273));
        }
        else if(opt == 2){
            System.out.println("The Fahrenheit is: "+value);
            System.out.println("It's value in Celcius: "+(value - 32)*(5/9));
            System.out.println("It's value in Kelvin: "+(value+273));
        }
        else{
            System.out.println("Invalid choice!");
        }

    }
}
