import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
public class Io {
    public static void writeToFile(String path, String content, boolean append, boolean newLine) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(path, append));
            ps.print(content + (newLine ? "\n" : ""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.flush();
                ps.close();
            }
        }
    }
    public static void fileCleaner() {
        try {
            PrintWriter writer = new PrintWriter("output.txt");
            writer.print("");
            writer.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}