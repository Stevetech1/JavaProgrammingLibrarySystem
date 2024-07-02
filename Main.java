public class Main {
    public static void main(String[] args) {
        // Primitive type variable
        int age = 27;

        // Reference type variable
        String name = "Ojone";

        // Arithmetic operations
        int firstResult = 2 + 3 * 4;
        int correctedFirstResult = (2 + 3) * 4; // Now evaluates to 20

        int a = 10, b = 5, c = 2;
        int secondResult = a - b * c; // Evaluates to 10 - (5 * 2) = 0
        int correctedSecondResult = (a - b) * c; // Evaluates to (10 - 5) * 2 = 10

        // Initialize the variables for conditions
        int temperature = 22; // Change value to test different scenarios
        int dayOfWeek = 5; // Change value to test different scenarios
        int score = 60; // Change value to test different scenarios

        // if-else statement
        if (temperature > 35) {
            System.out.println("It's hot!");
        } else {
            System.out.println("It's cool.");
        }

        // switch statement
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        // Ternary operator
        String result = (score > 50) ? "Pass" : "Fail";
        System.out.println(result);
    }
}
