import java.io.FileNotFoundException;
import java.text.ParseException;
public class Main {
    public static String input;
    public static String output;

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Io.fileCleaner();
        input = args[0];
        output = args[1];
        TripSchedule trips = new TripSchedule(input);
        new TripController(trips);
    }
}