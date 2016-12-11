package vkaretko;

import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SimpleGenerator for replacing keys in line with values from keyMap.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 10.12.2016
 */
public class SimpleGenerator implements Template {
    /**
     * Pattern for searching.
     */
    private static final Pattern PATTERN = Pattern.compile("\\$\\{(\\w+)}");
    /**
     * Method search keys in line and replace them with values.
     * @param line line to search keys.
     * @param keyMap map with keys and their values.
     * @return line with replaced keys.
     * @throws NoKeyException if no key in map.
     * @throws WrongKeyException if map has unnecessary keys.
     */
    @Override
    public String generate(String line, Map<String, String> keyMap) throws NoKeyException, WrongKeyException {
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        Matcher m = PATTERN.matcher(sb);
        HashSet<String> keySetFromLine = new HashSet<>();
        while (m.find()) {
            keySetFromLine.add(m.group(0));
            if (keyMap.containsKey(m.group(0))) {
                sb.replace(m.start(), m.end(), keyMap.get(m.group(0)));
            } else {
                throw new NoKeyException("Error: no Key in Map");
            }
            m.reset(sb);
        }
        if (keySetFromLine.size() != keyMap.size()) {
            throw new WrongKeyException("Error: Map has unnecessary key");
        }
        return sb.toString();
    }
}
