import java.util.Scanner;

/**
 * Runs the entire game
 *
 * @author Jennifer Lam
 *
 */
public class Game {
    private final static Scanner sc = new Scanner(System.in);
    public final static int MINUTES = 0;
    public final static int SECONDS = 1;

    public static void play() {
        Game.displayGreeting();
        Game.displayInstructions();

        PassageGenerator passage = new PassageGenerator();
        System.out.println(passage.showPassage());

        Game.displayStarter();

        Timer timer = new Timer();
        timer.start();

        Matcher matcher = new Matcher();
        matcher.readIn(sc);

        timer.stop();
        int[] timerArray = timer.calculateMinSec();

        int wordsTyped = matcher.calculateMatch(passage.getPassage());
        float time = timer.getTimeMinutes();

        Game.displayResults(timerArray[Game.MINUTES], timerArray[Game.SECONDS],
                matcher.getErrors(), Game.calculateScore(wordsTyped,time));

        if (Game.playAgain())
            Game.play();
        else {
            Game.displayFarewell();
            sc.close();
        }
    }

    private static void displayGreeting() {
        System.out.println("Welcome to Typing Test!");
    }

    private static void displayInstructions() {
        System.out.println("Instructions not yet set.");
    }

    private static void displayStarter() {
        int pause = 1 * 1000; //one second pause
        try {
            System.out.println("Please start typing in ");
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                Thread.sleep(pause);
            }
            System.out.print("Start: ");
            System.out.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayResults(int timeMin, int timeSec, int errors,
            int speed) {
        System.out.print("You finished in " + timeMin + "minutes and "
                + timeSec + " seconds.");
        System.out.print(" You have " + errors + " errors.");
        System.out.println(" Your typing speed is " + speed + " words per "
                + "minute (wpm).");
    }

    private static int calculateScore(int wordsTyped, float time) {
        return Math.round(wordsTyped / time);
    }

    private static boolean playAgain() {
        System.out.print("Play Again? Please type Y/N ");
        System.out.flush();
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("y"))
            return true;
        return false;
    }

    private static void displayFarewell() {
        System.out.println("Until next time!");
    }
}
