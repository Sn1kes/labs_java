import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {
    private Map<Character, Integer> charMap;
    private char mostPopular;

    private FileStats(File file) {
        BufferedReader bufRead = null;
        try {
            bufRead = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        charMap = new HashMap<>();
        int next;
        int maxCount = 0;
        try {
            while((next = bufRead.read()) != -1) {
                char c = (char)next;
                if(Character.isWhitespace(c))
                    continue;
                int count = 1;
                if(!charMap.containsKey(c)) {
                    charMap.put(c, count);
                } else {
                    count = charMap.get(c) + 1;
                    charMap.replace(c, count);
                }
                if(maxCount < count) {
                    maxCount = count;
                    mostPopular = c;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {
        File file = new File("src/test/resources/" + fileName);
        if(!file.canRead())
            throw new FileStatsException("File doesn't exist or not readable!");
        return new FileStats(file);
    }

    /**
     * Returns a number of occurrences of the particular character.
     *
     * @param character a specific character
     * @return a number that shows how many times this character appeared in a text file
     */
    public int getCharCount(char character) {
        Integer count = charMap.get(character);
        if(count == null) {
            return 0;
        }
        return count;
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {
        return mostPopular;
    }

    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return charMap.containsKey(character);
    }
}
