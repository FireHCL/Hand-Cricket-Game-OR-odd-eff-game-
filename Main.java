import java.util.*;

public class Main {
    public static Scanner SC = new Scanner (System.in);
    public static Random r = new Random();
    public static int choice;
    public static int compchoice;
    //rules
    public static void rules () {
        System.out.println ("RULES");
    }
    //decides who bats first
    public static void initials () {
        System.out.println ("Now lets start to choose who bats first.");
         System.out.println("Please choose a number betwen 1 to 10: ");
         choice = SC.nextInt();
         compchoice = r.nextInt(9) + 1;
         System.out.println("Computer choice: "+compchoice);
         if ((compchoice+choice)%2==0 && compchoice == 2 || (compchoice+choice)%2 != 0 && compchoice ==1) {
            System.out.println ("Computer won");
            compchoice = r.nextInt(1) + 1;
            System.out.println ("Computer chooses: "+ ((compchoice==1) ? "Batting" : "Balling"));
            switch (compchoice) {
                case 1 : compBat();
                break;
                case 2 : compBall();
                break;
            }
         }
         else {
            System.out.println ("You won. Please choose your choice. You want batting(press 1) or balling(press 2)?");
            choice = SC.nextInt();
            switch (choice) {
                case 1: userBat();
                break;
                case 2: userBall();
                break;
            }
         }
    }
    //all code for user to bat adbsolute fun
    public static void userBat () {

    }
    //code for user to ball
    public static void userBall () {

    }
    //code for batting computer
    public static void compBat() {

    }
    //code for balling computer
    public static void compBall () {

    }

     public static void main(String[] args) {
        System.out.println ("Welcome to the game! ");
        System.out.println ("To know the rules press 1. otherwise press 2.");
        choice = SC.nextInt();

        switch (choice) {
            case 1: rules();
            break;
            case 2: break;
        }

        System.out.println ("Lets start!");
        System.out.println ("Lets decide who will bat or ball. Please choose even(press 2) or odd(press 1): ");
        choice = SC.nextInt();
        compchoice = 0;
        switch (choice) {
            case 1: compchoice = 2;
            initials();
            break;
            case 2: compchoice = 1;
            initials();
            break;
        }
    }
}