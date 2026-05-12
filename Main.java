import java.util.*;

public class Main {

    public static Scanner SC = new Scanner(System.in);
    public static Random r = new Random();

    public static int choice;
    public static int compchoice;

    // rules
    public static void rules() {
        System.out.println("RULES");
        System.out.println("1. Choose numbers between 1 and 10.");
        System.out.println("2. If both choices become same, batsman is out.");
        System.out.println("3. Highest score wins.");
    }

    // decides who bats first
    public static void initials() {

        System.out.println("Now lets start to choose who bats first.");
        System.out.println("Please choose a number between 1 to 10: ");

        choice = SC.nextInt();

        compchoice = r.nextInt(10) + 1;

        System.out.println("Computer choice: " + compchoice);

        if ((compchoice + choice) % 2 == 0 && compchoice == 2
                || (compchoice + choice) % 2 != 0 && compchoice == 1) {

            System.out.println("Computer won");

            compchoice = r.nextInt(2) + 1;

            System.out.println("Computer chooses: "
                    + ((compchoice == 1) ? "Batting" : "Bowling"));

            switch (compchoice) {

                case 1:
                    compBat();
                    break;

                case 2:
                    compBall();
                    break;
            }
        }

        else {

            System.out.println(
                    "You won. Please choose your choice. You want batting(press 1) or bowling(press 2)?");

            choice = SC.nextInt();

            switch (choice) {

                case 1:
                    userBat();
                    break;

                case 2:
                    userBall(0);
                    break;
            }
        }
    }

    // all code for user batting
    public static void userBat() {

        System.out.println("Ok so you are batting.");

        int user = 0;
        int comp = 0;
        int totalScore = 0;

        do {

            System.out.println("Enter a number between 1 and 10");

            user = SC.nextInt();

            if (user > 10 || user < 1) {

                System.out.println(
                        "Invalid choice! Enter a number between 1 and 10!");

                continue;
            }

            else {

                comp = r.nextInt(10) + 1;

                System.out.println("Computer choice: " + comp);

                totalScore += user;

                System.out.println("Your score: " + totalScore);
            }

        }

        while (comp != user);

        System.out.println("You are out!");

        System.out.println("Your total score: " + totalScore);

        System.out.println(
                "The computer needs to score "
                        + (totalScore + 1)
                        + " to win this game.");

        System.out.println("Now its time for you to bowl.");

        userBall(totalScore);
    }

    // user bowling
    public static void userBall(int target) {

        System.out.println("Now you are bowling.");

        int user = 0;
        int comp = 0;
        int totalScore = 0;

        do {

            System.out.println("Enter a number between 1 and 10");

            user = SC.nextInt();

            if (user > 10 || user < 1) {

                System.out.println(
                        "Invalid choice! Enter a number between 1 and 10!");

                continue;
            }

            comp = r.nextInt(10) + 1;

            System.out.println("Computer choice: " + comp);

            if (user != comp) {

                totalScore += comp;

                System.out.println(
                        "Computer score: " + totalScore);
            }

            if (totalScore > target) {

                System.out.println("Computer won the game!");

                return;
            }

        }

        while (user != comp);

        System.out.println("Computer is out!");

        System.out.println(
                "Computer total score: " + totalScore);

        if (totalScore < target) {

            System.out.println("You won the game!");
        }

        else {

            System.out.println("Match draw!");
        }
    }

    // computer batting first
    public static void compBat() {

        System.out.println("Computer is batting.");

        int user = 0;
        int comp = 0;
        int totalScore = 0;

        do {

            comp = r.nextInt(10) + 1;

            System.out.println("Enter a number between 1 and 10");

            user = SC.nextInt();

            if (user > 10 || user < 1) {

                System.out.println(
                        "Invalid choice! Enter a number between 1 and 10!");

                continue;
            }

            System.out.println("Computer choice: " + comp);

            if (user != comp) {

                totalScore += comp;

                System.out.println(
                        "Computer score: " + totalScore);
            }

        }

        while (user != comp);

        System.out.println("Computer is out!");

        System.out.println(
                "Computer total score: " + totalScore);

        System.out.println(
                "You need "
                        + (totalScore + 1)
                        + " runs to win.");

        compBall(totalScore);
    }

    // computer bowling
    public static void compBall(int target) {

        System.out.println("Computer is bowling.");

        int user = 0;
        int comp = 0;
        int totalScore = 0;

        do {

            System.out.println("Enter a number between 1 and 10");

            user = SC.nextInt();

            if (user > 10 || user < 1) {

                System.out.println(
                        "Invalid choice! Enter a number between 1 and 10!");

                continue;
            }

            comp = r.nextInt(10) + 1;

            System.out.println("Computer choice: " + comp);

            if (user != comp) {

                totalScore += user;

                System.out.println(
                        "Your score: " + totalScore);
            }

            if (totalScore > target) {

                System.out.println("You won the game!");

                return;
            }

        }

        while (user != comp);

        System.out.println("You are out!");

        System.out.println("Your total score: " + totalScore);

        if (totalScore < target) {

            System.out.println("Computer won the game!");
        }

        else {

            System.out.println("Match draw!");
        }
    }

    public static void compBall() {
        compBall(0);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the game!");

        System.out.println(
                "To know the rules press 1. otherwise press 2.");

        choice = SC.nextInt();

        switch (choice) {

            case 1:
                rules();
                break;

            case 2:
                break;
        }

        System.out.println("Lets start!");

        System.out.println(
                "Lets decide who will bat or bowl. Please choose even(press 2) or odd(press 1): ");

        choice = SC.nextInt();

        compchoice = 0;

        switch (choice) {

            case 1:
                compchoice = 2;
                initials();
                break;

            case 2:
                compchoice = 1;
                initials();
                break;
        }
    }
}