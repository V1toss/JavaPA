package vkaretko;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 03.01.2017.
 */
public class Parser {

    /**
     * HashMap of all order books.
     */
    private HashMap<String, OrderBook> orderBooks = new HashMap<>();

    /**
     * Method for parsing xml file.
     * @param file file to parse.
     * @throws XMLStreamException if xml file is not valid.
     * @throws FileNotFoundException if file not found.
     */
    public void parse(String file) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream(file);
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                if (streamReader.getLocalName().equals("AddOrder")) {
                    addOrder(streamReader);
                } else if (streamReader.getLocalName().equals("DeleteOrder")) {
                    deleteOrder(streamReader);
                }
            }
            streamReader.next();
        }
        printOrders();
    }

    private void printOrders() {
        for (String book : orderBooks.keySet()) {
            System.out.println(book);
            orderBooks.get(book).print();
        }
    }

    /**
     * Method send values from xml stream to add method of orderBook.
     * @param reader xml stream reader.
     */
    private void addOrder(XMLStreamReader reader) {
        String book = reader.getAttributeValue(0);
        Order order = new Order(Double.valueOf(reader.getAttributeValue(2)),
                Integer.valueOf(reader.getAttributeValue(3)),
                Integer.valueOf(reader.getAttributeValue(4)),
                reader.getAttributeValue(1).equals("BUY"));
        OrderBook orderBook = orderBooks.get(book);
        if (orderBook == null) {
            orderBook = new OrderBook();
            orderBooks.put(book, orderBook);
        }
        orderBook.add(order);
    }

    /**
     * Method send information from xml stream to delete method of orderBook.
     * @param streamReader xml stream reader.
     */
    private void deleteOrder(XMLStreamReader streamReader) {
        String book = streamReader.getAttributeValue(0);
        int orderId = Integer.valueOf(streamReader.getAttributeValue(1));
        OrderBook orderBook = orderBooks.get(book);
        orderBook.delete(orderId);
    }

    /**
     * Method main calculates time.
     * @param args arguments from command line.
     * @throws Exception if file not found.
     */
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Parser parser = new Parser();
        parser.parse("c:/orders.xml");
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
