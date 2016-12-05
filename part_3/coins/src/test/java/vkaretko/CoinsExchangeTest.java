package vkaretko;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Coins-exchange test-class.
 */
public class CoinsExchangeTest {
    /**
     * Test method for checking exchange money.
     */
    @Test
    public void whenExchangeMoneyTenThenResultStringWithCoins() {
        final int moneyToExchange = 10;
        final String sep = System.getProperty("line.separator");
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(output));
            new CoinsExchange().exchange(moneyToExchange);
            assertThat(output.toString(), is(
                    String.format("1 1 1 1 1 1 1 1 1 1 %s5 1 1 1 1 1 %s5 5 %s10 %s", sep, sep, sep, sep)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
