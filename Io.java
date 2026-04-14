import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
public class Io {
    public static void writeToFile(String path, String content, boolean append, boolean newLine) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(path, append))) {
            ps.print(content + (newLine ? "\n" : ""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void fileCleaner(String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}