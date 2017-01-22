package vkaretko;

/**
 * Class User.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class User {
    /**
     * Name of user.
     */
    private String name;
    /**
     * Amount of user cash.
     */
    private int amount;

    /**
     * Constructor of user.
     * @param name name of user.
     * @param amount amount of cash.
     */
    public User(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    /**
     * Getter for amount.
     * @return amount.
     */
    public synchronized int getAmount() {
        return this.amount;
    }

    /**
     * Setter for amount.
     * @param amount amount to set.
     */
    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Getter for name.
     * @return name of user.
     */
    public String getName() {
        return this.name;
    }
}
