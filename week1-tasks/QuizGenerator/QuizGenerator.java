import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

public class QuizGenerator {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Question> quiz = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Generator!");
        while (true) {
            System.out.println("\n1. Add Question\n2. Take Quiz\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    takeQuiz();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addQuestion() {
        System.out.print("Enter question: ");
        String questionText = scanner.nextLine();

        List<String> options = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter option " + i + ": ");
            options.add(scanner.nextLine());
        }

        System.out.print("Enter correct answer (1-4): ");
        int correctAnswer = scanner.nextInt();
        scanner.nextLine();

        quiz.add(new Question(questionText, options, correctAnswer));
        System.out.println("Question added!");
    }

    private static void takeQuiz() {
        int score = 0;
        if (quiz.isEmpty()) {
            System.out.println("No questions available!");
            return;
        }

        for (Question q : quiz) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.correctAnswer + "\n");
            }
        }

        System.out.println("Quiz Completed! Your score: " + score + "/" + quiz.size());
    }
}
