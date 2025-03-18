/*
Joseph Simonin
COP-2800-98672 Java Programming
Proffessor Seely
Assignmnet: P4- Fun for a Long Trip
Date created: 3/07/2025

AI Statement:AI was used to troubleshoot issues related to scanner handling, this was needed due to the no parameters requirement for the 2 int return type methods.
AI assistance was utilized to debug and correct logical errors involving input recognition and looping until valid input was received.

Program description: This program will print to the screen a welcome to the chicken store message. A series of questions will be presented to the user to guide their 
choice on buying a chicken, and a final chicken report will be printed based on the answers. Then the user will be given the option to buy another chicken or exit.
 */

import java.util.Scanner; // import scanner class

public class BuyingChickens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner for inputs
        boolean buyMoreChickens = true; // Boolean controlled loop

// Call Method to print welcome to chcken store
        welcomeMessage();

        while (buyMoreChickens) {
            int chickenBreed = getChickenBreed(); // assigns returnd value for getChickenBreed method to chickenBreed
            int healthQuality = getHealthQuality(); // assigns returnd value for getHealthQuality method to healthQuality
            float expectedEggs = calculateExpectedEggs(chickenBreed, healthQuality); // calculates expected eggs based on chicken breed*health
            String keepOrFry = decideKeepOrFry(expectedEggs); // determins value of chicken
        
    // Final chicken report
            System.out.println("Final Chicken Report:");
            System.out.print("Expected eggs per year: " + expectedEggs);
            System.out.print("\nThis chicken has " + keepOrFry);

    // Buy another chicken question
            String choice;
            do {
                System.out.print("\nWould you like to buy another chicken (Y/N)? ");
                choice = input.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    buyMoreChickens = true;
                }
                else if (choice.equals("N")) {
                    buyMoreChickens = false;
                }
                else {
                    System.out.println("Invalid Choice, please enter Y or N.");
                }
            } while (!choice.equals("Y") && !choice.equals("N"));
            
        }

    // Good-Bye Message
        System.out.println("Thank you for visiting the Chicken Store! Have a great day!");
        input.close();
    }

// Method: welcomeMessage
    public static void welcomeMessage () {
        System.out.println("Welcome to the chicken store!");
    }

// Method: getChickenBreed
    public static int getChickenBreed() {
        Scanner input = new Scanner(System.in);
        int breed;
        do {
            System.out.println("\nChoose the desired breed of chicken:");
            System.out.println("1: Rhode Island Red");
            System.out.println("2: Americana");
            System.out.println("3: Longhorn");
            System.out.print("Enter desired breed (1-3): ");
    // check for integer
            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
                input.next();
            }
            breed = input.nextInt();
    // check breed is valid
            if (breed < 1 || breed > 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (breed < 1 || breed > 3);
        return breed;
    }

// Method: getHealthQuality
    public static int getHealthQuality() {
        Scanner input = new Scanner(System.in);
        int health;
        do {
            System.out.println("\nChoose the desired health of chicken:");
            System.out.println("0: Healthy");
            System.out.println("1: Under weight");
            System.out.println("2: Over weight");
            System.out.println("3: Droopy comb");
            System.out.print("Enter desired health (0-3): ");
    // check for integer
            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 0 and 3.");
                input.next();
            }
            health = input.nextInt();
    // check health is valid
            if (health < 0 || health > 3) {
                System.out.println("Invalid choice. Please enter 0, 1, 2, or 3.");
            }
        } while (health < 0 || health > 3);
        return health;
    }

// Method: calculateExpectedEggs (Formula for number of eggs in a year: Production count * Health value * 52)
    public static float calculateExpectedEggs(int chickenBreed, int healthQuality) {
        int eggCount = 0; // variable to store egg count for each breed
        float healthValue = 0; // variable to store health value for selected chicken

    // switch case for chicken breed and their egg counts
        switch (chickenBreed) {
            case 1: eggCount = 7; // Rhode Island Red count
            break;
            case 2: eggCount = 5; // Americana count
            break;
            case 3: eggCount = 6; // Longhorn count
            break;
            default:
                System.out.println("Invalid Choice, please try again.");
        }

    // switch case for chicken health
        switch (healthQuality) {
            case 0: healthValue = 1.0f; // healthy
            break;
            case 1: healthValue = 0.7f; // Under weight
            break; 
            case 2: healthValue = 0.9f; // over weight
            break;
            case 3: healthValue = 0.5f; // Droopy comb
            break;
            default:
                System.out.println("Invalid Choice, please try again.");
        }

    // Calculate egg count for 1 year
        return eggCount * healthValue * 52;
    }

// Method: decideKeepOrFry
    public static String decideKeepOrFry(float eggsPerYear) {
        if (eggsPerYear > 300) {
            return "Great Value! Consider buying."; // > 300 great value
        } 
        else if (eggsPerYear > 200) {
            return "Good Value! Consider buying."; // > 200 good value
        }
        else {
            return "Low Value! Consider frying."; // < 200 low value/ cook it
        }
    }
}
