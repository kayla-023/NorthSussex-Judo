import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// This class represents an Athlete and stores their information and cost calculations.
class Athlete {
    private String name;// Name of the athlete.
    private String trainingPlan;// Chosen training plan (Beginner/Intermediate/Elite).
    private double currentWeight;// The athlete's current weight.
    private String competitionWeightCategory;// The weight category for competitions.
    private int competitionsThisMonth;// Number of competitions the athlete will participate in this month.
    private int privateCoachingHours;// Number of private coaching hours required per week.

    // Constructor to initialize an Athlete object with the given information.
    public Athlete(String name, String trainingPlan, double currentWeight, String competitionWeightCategory,
                   int competitionsThisMonth, int privateCoachingHours) {
        this.name = name;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.competitionWeightCategory = competitionWeightCategory;
        this.competitionsThisMonth = competitionsThisMonth;
        this.privateCoachingHours = privateCoachingHours;
    }

    // Getter method to retrieve the athlete's name.
    public String getName() {
        return name;
    }
    // Calculate the cost of the training plan for the athlete.
    public double calculateTrainingCost() {
        double trainingCost = 0.0;
        if (trainingPlan.equalsIgnoreCase("Beginner")) {
            trainingCost = 25.00 * 4; // 4 weeks in a month
        } else if (trainingPlan.equalsIgnoreCase("Intermediate")) {
            trainingCost = 30.00 * 4;
        } else if (trainingPlan.equalsIgnoreCase("Elite")) {
            trainingCost = 35.00 * 4;
        }
        return trainingCost;
    }
    
    // Calculate the cost of participating in competitions for the athlete.
    public double calculateCompetitionCost() {
        if ((trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite"))
                && competitionsThisMonth > 0) {
            return 22.00 * competitionsThisMonth;
        }
        return 0.0;
    }
    
    // Calculate the cost of private coaching for the athlete.
    public double calculatePrivateCoachingCost() {
        double coachingCost = 0.0;
        if (privateCoachingHours <= 5) {
            coachingCost = 9.00 * privateCoachingHours * 4; // 4 weeks in a month
        } else {
            System.out.println("Maximum of 5 hours of private coaching allowed per week.");
        }
        return coachingCost;
    }
    // Calculate the total cost for the athlete, including training, competitions, and coaching.
    public double calculateTotalCost() {
        double trainingCost = calculateTrainingCost();
        double competitionCost = calculateCompetitionCost();
        double coachingCost = calculatePrivateCoachingCost();
        return trainingCost + competitionCost + coachingCost;
    }
    
    // Determine the weight category for the athlete based on their current weight.
    public String weightComparison() {
        if (currentWeight <= 66.99f) {
            competitionWeightCategory = "Flyweight (66kg Below)";
            return "Weight Category: Flyweight";
        } else if (currentWeight >= 67 && currentWeight <= 73.99f) {
            competitionWeightCategory = "Lightweight (67-73kg)";
            return "Weight Category: Lightweight";
        } else if (currentWeight >= 74 && currentWeight <= 81.99f) {
            competitionWeightCategory = "Light-Middleweight (74-81kg)";
            return "Weight Category: Light-Middleweight";
        } else if (currentWeight >= 82 && currentWeight <= 90.99f) {
            competitionWeightCategory = "Middleweight (82-90kg)";
            return "Weight Category: Middleweight";
        } else if (currentWeight >= 91 && currentWeight <= 100.99f) {
            competitionWeightCategory = "Light-Heavyweight (91-100kg)";
            return "Weight Category: Light-Heavyweight";
        } else if (currentWeight >= 101) {
            competitionWeightCategory = "Heavyweight (100kg Above)";
            return "Weight Category: Heavyweight";
        }
        return ""; 
    }
    
// This class represents the JudoProgram that manages athletes.
public class JudoProgram {
    private static List<Athlete> athletes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner xerox = new Scanner(System.in);
        boolean exitProgram = false;

        System.out.println("\tWelcome to North Sussex Judo Program!");

            // Get a valid option from the user.
        while (!exitProgram) {
            System.out.println("\t\t\t+===================================+");
            System.out.println("\t\t\t|Please select an option:           |");
            System.out.println("\t\t\t|1. Register an athlete             |");
            System.out.println("\t\t\t|2. Generate report for all athletes|");
            System.out.println("\t\t\t|3. Exit program                    |");
            System.out.println("\t\t\t+===================================+");

            int option = 0;
            boolean validInput = false;

            while(!validInput) {
                if(xerox.hasNextInt()) {
                    option = xerox.nextInt();
                    if(option >= 1 && option < 4) {
                        validInput = true;
                    } else {
                        System.out.println("Please Enter a Valid Input, Thank you!");
                    }
                } else {
                    xerox.next();
                    System.out.println("Please Enter a Valid Input, Thank you!");
                }
            }
            switch (option) {
                case 1:
                    registerAthlete(xerox);
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    exitProgram = true;
                    System.out.println("Thank you for using the Judo Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Register a new athlete by taking input from the user.
    public static void registerAthlete(Scanner xerox) {
        
        String name;

        while(true) {
        System.out.println("Please enter the athlete's name:");
        name = xerox.next();
            if(name.matches("[a-zA-z ]+") && name.length() > 1) {
                break;
            } 
            else {
            System.out.println("Please enter a valid name");
            }
    }
    System.out.println("Training Plan: \nBeginner\t(2 sessions per week) weekly fee - $25.00 \nIntermediate\t(3 sessions per week) weekly fee - $30.00 \nElite\t\t(5 sessions per week) weekly fee - $35.00");
    System.out.println("Please enter the athlete's training plan:");
    String trainingPlan = "";
    
    while (true) {
        trainingPlan = xerox.next();
        if (trainingPlan.equalsIgnoreCase("beginner") || trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite")) {
            break;
        } 
        else {
            System.out.println("Invalid plan! Please choose from the options (Beginner/Intermediate/Elite):");
        }
    } 

        double currentWeight = 0.0;
        boolean validInputkilo = false;

        while(!validInputkilo){
            System.out.println("Please enter the athlete's current weight:");
            if(xerox.hasNextDouble()) {
                currentWeight = xerox.nextDouble();
                if(currentWeight > 0) {
                    validInputkilo = true;
                } 
                else {
                    System.out.println("Invalid Input, Try Again");
                }
            } 
            else {
                xerox.next();
                System.out.println("Invalid Input, Try Again");
            }
        }
        int competitionsThisMonth = 0;
        while (true) {
            System.out.println("Please enter the number of competitions the athlete will participate in this month:");
             try {
                 competitionsThisMonth = xerox.nextInt();
                 if (competitionsThisMonth > 0) {
                 break;
                 } else {
                    System.out.println("Please enter a valid number (greater than 0).");
                 }
                } catch (InputMismatchException e) {
                      System.out.println("Please enter a valid number.");
                      xerox.next(); // Clear the invalid input from the scanner
                }
            }       
            int privateCoachingHours = 0;
                    while(true){
                    System.out.println("Please enter the number of private coaching hours the athlete requires per week:");
                    try{
                    privateCoachingHours = xerox.nextInt();
                        if(privateCoachingHours >=1 || privateCoachingHours <= 5){
                            break;
                        } else {
                                System.out.println("5 hours is the maximum coaching hours.");
                        }
                    }
                    catch(InputMismatchException e){
                            System.out.println("Please enter a valid number.z");
                    }
                }
        String competitionWeightCategory = xerox.nextLine();

        // Create a new Athlete object with the provided information and add it to the list of athletes.
        Athlete athlete = new Athlete(name, trainingPlan, currentWeight, competitionWeightCategory,
                competitionsThisMonth, privateCoachingHours);
        athletes.add(athlete);

        System.out.println("Athlete registered successfully!");
    }
  
    // Generate and display a report for all registered athletes.
    public static void generateReport() {
        if (athletes.isEmpty()) {
            System.out.println("No athletes registered yet.");
        } else {
            System.out.println("Report for all registered athletes:");

            for (Athlete athlete : athletes) {
                System.out.println("Athlete: " + athlete.getName());
                System.out.println("Training Cost: $" + athlete.calculateTrainingCost());
                System.out.println("Competition Cost: $" + athlete.calculateCompetitionCost());
                System.out.println("Private Coaching Cost: $" + athlete.calculatePrivateCoachingCost());
                System.out.println("Total Cost: $" + athlete.calculateTotalCost());
                System.out.println("" + athlete.weightComparison());
                System.out.println("--------------------------------------");
            }
        }
    }
}
}