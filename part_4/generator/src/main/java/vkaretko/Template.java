package vkaretko;

import java.util.Map;

/**
 * Interface Template with generate method.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 10.12.2016
 */
public interface Template {
    /**
     * Method search keys in line and replace them with values.
     * @param line line to search keys.
     * @param keyMap map with keys and their values.
     * @return line with replaced keys.
     * @throws NoKeyException if no key in map.
     * @throws WrongKeyException if map has unnecessary keys.
     */
    String generate(String line, Map<String, String> keyMap) throws NoKeyException, WrongKeyException;
}
