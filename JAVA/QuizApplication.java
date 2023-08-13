import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String Question;
    private String[] Options;
    private int CorrectOption;

    public QuizQuestion(String Question, String[] Options, int CorrectOption) {
        this.Question = Question;
        this.Options = Options;
        this.CorrectOption = CorrectOption;
    }

    public String getQuestion() {
        return Question;
    }

    public String[] getOptions() {
        return Options;
    }

    public boolean isCorrectOption(int SelectedOption) {
        return SelectedOption == CorrectOption;
    }
}

public class QuizApplication {
    private static int score = 0;
    private static int questionNumber = 0;
    private static Scanner scanner = new Scanner(System.in);

    private static QuizQuestion[] quizQuestions = {
        new QuizQuestion("What is the capital of France?", new String[]{"1. London", "2. Paris", "3. Berlin"}, 2),
        new QuizQuestion("Which planet is closest to the sun?", new String[]{"1. Venus", "2. Earth", "3. Mercury"}, 3),
        new QuizQuestion("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5"}, 2),
        // Add more questions here
    };

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Application!");

        startQuiz();
    }

    private static void startQuiz() {
        questionNumber = 0;
        score = 0;

        for (QuizQuestion Question : quizQuestions) {
            questionNumber++;
            System.out.println("\nQuestion 2
            " + questionNumber + ": " + Question.getQuestion());
            for (String Option : Question.getOptions()) {
                System.out.println(Option);
            }

            System.out.print("Enter your answer (1, 2, or 3): ");

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    askNextQuestion();
                }
            };

            timer.schedule(task, 10000); // Timer set for 10 seconds (adjust as needed)

            int SelectedOption = scanner.nextInt();
            timer.cancel();

            if (SelectedOption >= 1 && SelectedOption <= 3) {
                if (Question.isCorrectOption(SelectedOption)) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect!\n");
                }
            } else {
                System.out.println("Invalid option! Skipping to the next question.\n");
            }

            askNextQuestion();
        }

        showResult();
    }

    private static void askNextQuestion() {
        if (questionNumber < quizQuestions.length) {
            startQuiz();
        } else {
            showResult();
        }
    }

    private static void showResult() {
        System.out.println("\n_______Quiz Results_________");
        System.out.println("Total Questions: " + quizQuestions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (quizQuestions.length - score));
        System.out.println("Your Score: " + (score * 100.0 / quizQuestions.length) + "%");
        System.out.println("\nThank you for playing!");
    }
}
