import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by uarem on 4/29/2015.
 *
 * https://code.google.com/codejam/contest/dashboard?c=32003#s=p0
 *
 * Alien Numbers
 */
public class AlienNumbers {

    public String alienNumbers(String alienNumber, List<String> sourceLanguage, List<String> targetLanguage) {
        List<Integer> result = subAlienNumbers(alienNumber, sourceLanguage);
        StringBuffer sb = new StringBuffer();

        for (int i=result.size()-1; i>=0; i--) {
            sb.append(targetLanguage.get(result.get(i)));
        }
        return sb.toString();
    }

    public List<Integer> subAlienNumbers(String alienNumber, List<String> sourceLanguage) {
        for (int i = alienNumber.length(); i > 0; i--) {
            String target = alienNumber.substring(0, i);
            if (sourceLanguage.contains(target)) {
                if (i == alienNumber.length()) {
                    List<Integer> index = new ArrayList<Integer>();
                    index.add(sourceLanguage.indexOf(target));
                    return index;
                } else {
                    List<Integer> subResult = subAlienNumbers(alienNumber.substring(i), sourceLanguage);
                    if (subResult.size() > 0) {
                        subResult.add(sourceLanguage.indexOf(target));
                        return subResult;
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
