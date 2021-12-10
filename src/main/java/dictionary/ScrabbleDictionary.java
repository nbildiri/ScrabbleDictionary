package dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrabbleDictionary {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public ScrabbleDictionary() throws IOException {

        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = null;
        if (in != null)
        {
            reader = new BufferedReader(new InputStreamReader(in));
        }
        String dictionaryLine;
        while ((dictionaryLine = reader.readLine()) != null)
        {
            int index = dictionaryLine.indexOf(" ");
            String[] pairs = dictionaryLine.split(" ", 2);
            wordsToDefinitions.put(
                    index == -1 ? dictionaryLine : dictionaryLine.substring(0, index), //key
                    index > -1 ? dictionaryLine.substring(index + 1) : null);
        }
    }

    public boolean contains(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size() {
        return wordsToDefinitions.size();
    }

}
