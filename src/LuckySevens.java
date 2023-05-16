import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class LuckySevens {
    public static void main (String[] args) {

        // declare initial game stats
        Integer money = 0;
        Integer winMoney = 4;
        Integer loseMoney = 1;
        Integer totalRolls = 1;

        Integer highestMoney = 0;
        Integer highestMoneyRolls = 0;

        // get the money amount from the user
        System.out.println("How many dollars do you have?");
        Scanner inScanner = new Scanner(System.in);
        money = parseInt(inScanner.nextLine());

        // game loop starts here
        do {
            Boolean diceResults = rollDice();

            if (diceResults) {
                money += winMoney;
            }
            else {
                money -= loseMoney;
            }

            if (money > highestMoney) {
                highestMoney = money;
                highestMoneyRolls = totalRolls;
            }

            totalRolls++;

        } while (money > 0);

        // game is over, display the stats
        System.out.println("You are broke after "+ totalRolls + " rolls.");
        System.out.println("You should have quit after " + highestMoneyRolls + " rolls when you had $" + highestMoney + ".");
    }

    // roll two dice, check the sum, and return true for a win and false for a lose
    public static Boolean rollDice() {
        Random random = new Random();

        Integer firstDice = Math.abs(random.nextInt() % 6);
        Integer secondDice = Math.abs(random.nextInt() % 6);

        if (firstDice + secondDice == 7) {
            return true;
        }
        else {
            return false;
        }
    }
}
