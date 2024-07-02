// 1. Import Scanner: Import the Scanner class for user input
import java.util.Scanner;

// 2. Main Method: The main method contains the primary logic for the quiz game.
public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int totalQuestions = 5;
        
        // 3. Questions and Answers Array: Store questions, options, and correct answers in a 2D array
        String[][] questions = {
            {"1. What is the capital of Nigeria?", "A. Lagos", "B. Abuja", "C. Lokoja", "D. Kaduna", "B"},
            {"2. Who is a man after God's heart?", "A. David", "B. Abraham", "C. Daniel", "D. Deborah", "A"},
            {"3. What is the chemical symbol for water?", "A. O2", "B. CO2", "C. H2O", "D. H2", "C"},
            {"4. What is the largest planet in our Solar System?", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn", "C"},
            {"5. Who is our saviour?", "A. David", "B. Ruth", "C. Jacob", "D. Jesus", "D"}
        };

        // 4. Loop Through Questions: Loop through each question, display it, and prompt the user for an
        for (String[] question : questions) {
            System.out.println(question[0]);
            System.out.println(question[1]);
            System.out.println(question[2]);
            System.out.println(question[3]);
            System.out.println(question[4]);

            System.out.print("Enter your answer (A, B, C, or D): ");
            String userAnswer = scanner.next().toUpperCase();

            // 5. Validate and Check Answer: Use a switch case to validate the user's input
            //and check it against the correct answer.
            switch (userAnswer) {
                case "A":
                case "B":
                case "C":
                case "D":
                    if (userAnswer.equals(question[5])) {
                        correctAnswers++;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Skipping to next question.");
            }
        }

        // 6. Calculate and Display Score: Calculate the final score as a percentage and display it.
        int score = (correctAnswers * 100) / totalQuestions;
        System.out.println("Your final score is: " + score + "%");

        // 7. Close Scanner: Close the Scanner to prevent resource leaks.
        scanner.close();
    }
}
