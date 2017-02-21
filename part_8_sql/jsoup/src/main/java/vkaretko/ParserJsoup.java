package vkaretko;

import com.sun.scenario.animation.shared.TimerReceiver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ParseJsoup parsing page with job-offers of sql.ru for Java vacancies.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.02.2017.
 */
public class ParserJsoup {

    /**
     * Url of sql.ru website with java vacancies.
     */
    private final String url = "http://www.sql.ru/forum/job-offers";

    /**
     * Logger for jsoup parser.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ParserJsoup.class);

    /**
     * DBManager.
     */
    private DBManager db = new DBManager();

    /**
     * Locale for converting date and time/
     */
    private final Locale locale = new Locale("ru","RU");

    /**
     * SimpleDateFormat for converting dates from forum.
     */
    private final SimpleDateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", locale);

    /**
     * Method parse webpage for vacancies.
     */
    public void start() {
        db.loadProperties();
        db.connectToDB();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements topics = doc.select("tr:has(.postslisttopic)");
            for (Element topic : topics) {
                if (topic.text().toLowerCase().contains("java") && !topic.text().toLowerCase().contains("script")) {
                    Elements link = topic.select("td.postslisttopic > a[href]");
                    Elements data = topic.select("td");

                    int offerId = Integer.parseInt(parseTopicId(link.attr("href")));
                    String linkOffer = link.attr("href");
                    String description = link.get(0).text();
                    Timestamp last_update = parseDate(data.get(5).text());
                    db.add(offerId, linkOffer, description, last_update);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        db.disconnect();
    }

    /**
     * Parse link for topic id.
     * @param line line to parse.
     * @return topic id.
     */
    public String parseTopicId (String line) {
        String result = "";
        Pattern p = Pattern.compile("forum/(\\d+)");
        Matcher m = p.matcher(line);
        while (m.find()) {
            result = m.group(1);
        }
        return result;
    }

    /**
     * Converting forum date to timestamp.
     * @param date date format from forum.
     * @return timestamp format for db.
     */
    public Timestamp parseDate(String date) {
        Calendar calendar = Calendar.getInstance();
        if (date.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(9,11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(12,14)));
        } else if (date.contains("вчера")) {
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(7,9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(10,12)));
        } else {
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return new Timestamp(calendar.getTimeInMillis());
    }


    public static void main(String[] args) {
        ParserJsoup pj = new ParserJsoup();
        pj.start();
    }
}
