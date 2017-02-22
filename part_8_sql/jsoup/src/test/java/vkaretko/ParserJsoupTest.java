package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Class ParserJsoupTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 22.02.2017.
 */
public class ParserJsoupTest {
    /**
     * Parser for tests.
     */
    private ParserJsoup pj = new ParserJsoup();

    /**
     * DBManager for tests.
     */
    private DBManager db = new DBManager();

    /**
     * Prepare database and parser.
     */
    @Before
    public void prepareDatabaseAndParser() {
        this.pj = new ParserJsoup();
        this.db = new DBManager();
    }

    /**
     * Test for parse topic method.
     */
    @Test
    public void whenParseLinkThenResultTopicID() {
        String result = pj.parseTopicId("http://www.sql.ru/forum/1249811/java-senior-developer-team-leader-udalennaya-rabota");
        String expected = "1249811";
        assertEquals(result, expected);
    }

    /**
     * Test for parsing date for today.
     */
    @Test
    public void whenParseDateTodayThenResultTimeStamp() {
        Timestamp date = pj.parseDate("сегодня, 19:13");
        Timestamp today = new Timestamp(System.currentTimeMillis());
        assertThat(date.getDate(), is(today.getDate()));
    }

    /**
     * Test for parsing date with SimpleDateFormat.
     */
    @Test
    public void whenParseDateThenResultTimeStamp() {
        Timestamp date = pj.parseDate("19 фев 17, 17:37");
        assertThat(date.toLocalDateTime().toString(), is("2017-02-19T17:37"));
    }

    /**
     * Test parse jsoup.
     */
    public void whenStartParseJsoupThenResultsInsertingToDb() {
        ParserJsoup pj = new ParserJsoup();
        DBManager db = new DBManager();
        db.loadProperties();
        db.connectToDB();
        pj.start(db);
        db.disconnect();
    }

}