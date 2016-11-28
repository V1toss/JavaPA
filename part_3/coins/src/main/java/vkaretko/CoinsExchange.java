package vkaretko;

/**
 * The class CoinsExchange.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 28.11.2016
 */
public class CoinsExchange {

    /**
     * The value of coins.
     */
    private final int[] coins = {1, 5, 10};

    /**
     * Method to split money to coins.
     * @param money money to exchange
     */
    public void exchange(int money) {
        for (int tens = 0; tens <= (money / coins[2]); tens++) {
            int moneyWithoutTens = money - tens * coins[2];
            for (int fives = 0; fives <= (moneyWithoutTens / coins[1]); fives++) {
                multiplePrint(coins[2], tens);
                multiplePrint(coins[1], fives);
                multiplePrint(coins[0], (moneyWithoutTens - fives * coins[1]) / coins[0]);
                System.out.println("");
            }
        }
    }

    /**
     * Method prints result in console.
     * @param coin value of coin
     * @param amount amount of coins
     */
    private void multiplePrint(int coin, int amount) {
        if (amount != 0) {
            for (int index = 0; index < amount; index++) {
                System.out.print(String.format("%s ", coin));
            }
        }
    }
}
