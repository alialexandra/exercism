package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Regular expression to match words, including contractions
        // and ignoring quoted parts
        Pattern pattern = Pattern.compile("\\b\\w+'?\\w*\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Normalize to lower case
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}