import java.util.*;

class App {
    private final String AthleteName;
    private final String trainingPlan;
    private final double kilograms;
    private final String weightCat;
    private final double comp;
    private final int coachingHours;
    private final double totalCost;

    public App(String AthleteName, String trainingPlan, double kilograms, String weightCat, double comp,
            int coachingHours, double totalCost) {
        this.AthleteName = AthleteName;
        this.trainingPlan = trainingPlan;
        this.kilograms = kilograms;
        this.weightCat = weightCat;
        this.comp = comp;
        this.coachingHours = coachingHours;
        this.totalCost = totalCost;
    }

    public String getName() {
        return AthleteName;
    }

    public String gettrainingPlan() {
        return trainingPlan;
    }

    public double getkilograms() {
        return kilograms;
    }

    public String getweightCat() {
        return weightCat;
    }

    public double getcomp() {
        return comp;
    }

    public int getcoachingHours() {
        return coachingHours;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String toString() {
        return "================================" +
                "\nName: \t\t\t" + AthleteName +
                "\nTraining Plan: \t\t" + trainingPlan +
                "\nWeight: \t\t" + kilograms +
                "\nWeight Category: \t" + weightCat +
                "\nCompetition Entry: \t" + comp +
                "\nCoaching Hours: \t" + coachingHours +
                "\nTotal Cost:\t\t" + "$" + totalCost +
                "\n================================";
    }

    public class northsussexjudo {
        public static ArrayList<App> athletelist = new ArrayList<App>();

        public static void main(String[] args) {

            String AthleteName = null, trainingPlan = null, weightCat = null;
            Double kilograms = 0d, comp = 0d, totalCost = 0d;
            int coachingHours = 0, choice = 3;
            Scanner scan = new Scanner(System.in); 

            do {
                // Calls the line 210
                TrainingProgram.menuTxt();
                choice = scan.nextInt();
                scan.nextLine();
                if (choice == 1) {
                    // ENTER NAME
                    System.out.println("=================================");
                    System.out.print("Enter Athlete's name ");
                    AthleteName = scan.nextLine();

                    // ENTER TRAINING PLAN
                    System.out.println("=================================");
                    System.out.print("Enter Training Plan (Beginner/Intermediate/Elite): ");
                    System.out.print("Enter Training Plan: ");

                    try {
                        while (true) {
                            trainingPlan = scan.nextLine();
                            if (trainingPlan.equalsIgnoreCase("beginner")
                                    || trainingPlan.equalsIgnoreCase("Intermediate")
                                    || trainingPlan.equalsIgnoreCase("Elite")) {
                                break;
                            } else {
                                System.out.println("Please Enter a Training Plan Based on the list: ");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Training Plans:");
                    }

                    // ENTER WEIGHT (KG)
                    System.out.println("=================================");
                    System.out.print("Enter Athlete's Kilogram: ");
                    kilograms = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("=================================");
                    System.out.println("Heavyweight\tUnlimited(over 100)");
                    System.out.println("Light-Heavyweight\t100");
                    System.out.println("Middleweight\t90");
                    System.out.println("Light-Middleweight\t81");
                    System.out.println("Lightweight\t73");
                    System.out.println("Flyweight\t66");
                    System.out.print("Enter Athlete's Weight category: ");

                    while (true) {
                        try {
                            weightCat = scan.nextLine();
                            if (weightCat.equalsIgnoreCase("flyweight") ||
                                    weightCat.equalsIgnoreCase("lightweight") ||
                                    weightCat.equalsIgnoreCase("light-middleweight") ||
                                    weightCat.equalsIgnoreCase("middleweight") ||
                                    weightCat.equalsIgnoreCase("light-heavyweight") ||
                                    weightCat.equalsIgnoreCase("heavyweight")) {
                                break;
                            } else {
                                System.out.println("Heavyweight\tUnlimited(over 100)");
                                System.out.println("Light-Heavyweight\t100");
                                System.out.println("Middleweight\t90");
                                System.out.println("Light-Middleweight\t81");
                                System.out.println("Lightweight\t73");
                                System.out.println("Flyweight\t66");
                                System.out.println("Please enter weight category based on the list:");
                            }
                        } catch (Exception e) {
                           System.out.println("Please enter weight category based on the list:");
                        }
                    }
                
                    // ENTER COMPETITION IF THE TRAINING PLAN IS BEGINNER THE ATHLETE IS NOT ALLOW
                    // TO
                    System.out.println("=================================");
                    if (trainingPlan.equalsIgnoreCase("Beginner")) {
                        comp = 0d;
                    } else {
                        System.out.print("Number of Competition You Want to Enter: ");
                        while (true) {
                            comp = scan.nextDouble();
                            try {
                                if (comp >= 0) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please Enter Number of Competition:");
                            }
                        }
                    }
                    // COACHING HOURS
                    System.out.println("=================================");
                    System.out.print("Private Coaching Hours ($9 per hour): ");
                    while (true) {
                        coachingHours = scan.nextInt();
                        try {
                            if (coachingHours >= 0 && coachingHours <= 5) {
                                break;
                            } else {
                                System.out.println("5 hours is the maximum time allowed");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please Number of Hours:");
                        }
                    }
                    System.out.print("Enter Coaching Hours: ");
                    coachingHours = scan.nextInt();
                    System.out.println("=================================");
                    totalCost = TrainingProgram.calculatetotalcost(trainingPlan, comp, coachingHours);
                   
                    App athlete = new App(AthleteName, trainingPlan, kilograms, weightCat, comp, coachingHours,
                            totalCost);
                    athletelist.add(athlete);

                    System.out.println("\n================================" +
                            "\nName: \t\t\t" + AthleteName +
                            "\nTraining Plan: \t\t" + trainingPlan +
                            "\nWeight: \t\t" + kilograms +
                            "\nWeight Category: \t" + weightCat +
                            "\nCompetition Entry: \t" + comp +
                            "\nCoaching Hours: \t" + coachingHours +
                            "\nTotal Cost:\t\t" + "$" + totalCost +
                            "\n================================");

                } else if (choice == 2) {
                    if (athletelist.isEmpty()) {
                        System.out.println("================================");
                        System.out.println("The record is empty");
                        System.out.println("================================");
                    } else {
                        TrainingProgram.displayAthleteInfo(athletelist);
                    }
                }

            } while (choice < 3);
        }

    }

    public class TrainingProgram {
        public static void displayAthleteInfo(ArrayList<App> athletelist) {
            for (App athlete : athletelist) {

                System.out.println(athlete);
            }
        }

        public static double calculatetotalcost(String trainingPlan, double comp, int coachingHours) {
            double trainingPlanCost = 0, compCost = 0, coachingHoursCost = 0, overallCost = 0;
            if (trainingPlan.equalsIgnoreCase("Beginner")) {
                trainingPlanCost = 25 * 4;
            } else if (trainingPlan.equalsIgnoreCase("Intermediate")) {
                trainingPlanCost = 30 * 4;
            } else if (trainingPlan.equalsIgnoreCase("Elite")) {
                trainingPlanCost = 35 * 4;
            }
            compCost = comp * 22;
            coachingHoursCost = coachingHours * 9 * 4;
            overallCost = trainingPlanCost + compCost + coachingHoursCost;

            return overallCost;
        }

        public static void menuTxt() {
            Scanner scan = new Scanner(System.in);
           boolean exit = false;
            while(!exit){
            System.out.println("Menu Select Input");
            System.out.println("1.Add Student" + "\n2.View list" + "\n3.Exit");
            System.out.print("Input Choice: ");

            int option= 0;
            boolean input = false;

            while(!input){
                if(scan.hasNextInt()){
                        option = scan.nextInt();
                        if(option >=1 && option < 4){
                            input = true;
                        } else {
                            System.out.println("Please Enter a Valid Input, Thank you!");
                        }
                    } else{
                        scan.next();
                        System.out.println("Please Enter a Valid Input, Thank you!");
                    }
            }
        }
    }
}
}
