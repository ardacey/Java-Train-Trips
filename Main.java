import java.io.FileNotFoundException;
import java.text.ParseException;
public class Main {
    private static final String DEFAULT_OUTPUT = "trip_report.txt";

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: java Main <input-file> [output-file]");
            return;
        }

        String input = args[0];
        String output = args.length == 2 ? args[1] : DEFAULT_OUTPUT;

        Io.fileCleaner(output);
        TripSchedule trips = new TripSchedule(input);
        new TripController(trips, output);

        System.out.println("Report created: " + output);
    }
}