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
     * DBManager
     */
    private DBManager db = new DBManager();

    /**
     * Method parse webpage for vacancies.
     */
    public void start() {
        db.loadProperties();
        db.connectToDB();
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
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
            e.printStackTrace();
        }
        db.disconnect();
    }

    public String parseTopicId (String line) {
        String result = "";
        Pattern p = Pattern.compile("forum/(\\d+)");
        Matcher m = p.matcher(line);
        while (m.find()) {
            result = m.group(1);
        }
        return result;
    }

    public Timestamp parseDate(String date) {
        Timestamp result = new Timestamp(System.currentTimeMillis());
        return result;
    }

    public static void main(String[] args) {
        ParserJsoup pj = new ParserJsoup();
        pj.start();
    }
}
