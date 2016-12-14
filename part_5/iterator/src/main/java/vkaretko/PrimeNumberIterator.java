package vkaretko;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class PrimeNumberIterator for iterating prime numbers.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 14.12.2016
 */
public class PrimeNumberIterator implements Iterator {
    /**
     * Int values for iterator.
     */
    private final int[] values;

    /**
     * Start index of array.
     */
    private int index = 0;

    /**
     * Constructor of PrimeNumberIterator.
     * @param values array to iterate.
     */
    public PrimeNumberIterator(int[] values) {
        this.values = values;
    }

    /**
     * Pattern for prime numbers.
     */
    private static final Pattern PATTERN = Pattern.compile(".?|(..+?)\\1+");

    /**
     * Method checks that number is prime.
     * @param n number to check
     * @return true if prime, false otherwise
     */
    private boolean isPrime(int n) {
        Matcher m = PATTERN.matcher(new String(new char[n]));
        return !m.matches();
    }

    /**
     * Method check that array has prime numbers.
     * @return true if array has prime numbers, false otherwise.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int ind = index; ind < values.length; ind++) {
            if (isPrime(values[ind])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Method select next prime number in Array.
     * @return next prime number in array.
     */
    @Override
    public Object next() {
        Integer result = null;
        if (hasNext()) {
            for (int ind = index; ind < values.length; ind++) {
                if (isPrime(values[ind])) {
                    result = values[ind];
                    index = ind + 1;
                    break;
                }
            }
        }
        return result;
    }


}
