import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        String s = null;
        try {
            s = new String(String.join("\n", Files.readAllLines(Paths.get("src/test/resources/" + fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
