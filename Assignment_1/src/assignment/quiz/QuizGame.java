package assignment.quiz;
import java.util.Scanner; //I use this library to ask the user 

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0; // Here I define the variable score, which is used to store it.

        // The first array has the questions of the quiz
        String[] questions = {
            "What is the name of the code writer?",
            "What is the sun?",
            "Which of this animals is a mammal?",
            "What is the powerhouse of the cell?",
            "Which programming language is most used in data science?"
        };

        // The second array holds the answers of the questions stored in the first array
        String[][] options = {
            {"A. Santiago Montenegro", "B. Raul Gonzalez", "C. John Johnson", "Ralph Swiftman"},
            {"A. A planet", "B. A star", "C. An asteroid", "D. A satellite"},
            {"A. Dog", "B. Bird", "C. Spider", "D. Butterfly"},
            {"A. Nucleus", "B. Ribosome", "C. Mitochondrion", "D. Chloroplast"},
            {"A. Python", "B. C++", "C. Swift", "D. Javascript"}
        };
        // The third array holds the correct answer of every question
        char[] correctAnswers = {'A', 'B', 'A', 'C', 'A'};
        // Display questions and get user answers, the for is used to show every answer according to the array position
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer (A, B, C, or D): ");
            char userAnswer = Character.toUpperCase(scanner.nextLine().charAt(0)); //This is to convert any lower case answer into upper case

            // This compares the user answer with the correct answer array
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!\n");
                score++; // Increment score for correct answer if it is correct
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".\n");
            }
        }

        // Calculate percentage score
        double percentageScore = (double) score / questions.length * 100;

        // This displays final score
        System.out.println("Quiz completed!");
        System.out.println("You scored " + score + " out of " + questions.length + ".");
        System.out.printf("Your score: %.2f%%\n", percentageScore);

        scanner.close();
    }
}
