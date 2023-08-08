import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean yOrN = false;
        String yesOrNoString;

        do {
            int die1 = rnd.nextInt(1, 12);
            int die2 = rnd.nextInt(1, 12);
            int dieTotal = 0;
            int point;

            dieTotal = die1 + die2;
            System.out.println("The first dice rolled " + die1);
            System.out.println("The second dice rolled " + die2);
            System.out.println("The sum of the two dice is " + dieTotal);

            if(dieTotal == 2 || dieTotal == 3 || dieTotal == 12) {
                System.out.println("You crapped out. You lost.");
            } else if(dieTotal == 7 || dieTotal == 11) {
                System.out.println("You rolled a natural. You won.");
            } else {
                point = dieTotal;
                while(dieTotal != point || dieTotal != 7) {
                    die1 = rnd.nextInt(1, 12);
                    die2 = rnd.nextInt(1, 12);
                    dieTotal = die1 + die2;
                    if(dieTotal != point || dieTotal != 7) {
                        System.out.println("Re-rolling. Trying for point.");
                    }
                }
                if(dieTotal == point) {
                    System.out.println("You made point. You win");
                } else if(dieTotal == 7) {
                    System.out.println("You rolled a 7. You lost.");
                }
            }
            System.out.print("Would you like to continue playing? ");
            do {
                yesOrNoString = in.nextLine();
                if(in.hasNextLine()) {
                    if(yesOrNoString.equalsIgnoreCase("y")) {
                        yOrN = true;
                    } else if(yesOrNoString.equalsIgnoreCase("n")) {
                        yOrN = false;
                    }
                } else {
                    System.out.println("Invalid entry. Try again.");
                }
            }while(!in.hasNextLine());
        }while(yOrN);

        in.close();
    }
}