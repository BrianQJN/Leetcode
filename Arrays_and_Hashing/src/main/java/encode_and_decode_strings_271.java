import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @since 2023-12-22
 */
public class encode_and_decode_strings_271 {
    /**
     * @implSpec Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
     * @author Brian Qu
     * @param strs the list of strings to encode
     * @return encoded string
     * @since 2023-12-22 18:44
     */
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    /**
     * @implSpec Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
     * @author Brian Qu
     * @param s encoded str to decode
     * @return decoded list of strings
     * @since 2023-12-22 18:46
     */
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, j));
            i = j + 1 + length;
            decoded.add(s.substring(j + 1, i));
        }
        return decoded;
    }
}
