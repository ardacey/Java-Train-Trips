import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class TripSchedule {
    public Trip[] trips;
    int numTrips, tripNum = 0;

    public TripSchedule(String fileName) throws FileNotFoundException, ParseException {
        try (Scanner tripCount = new Scanner(new File(fileName))) {
            while (tripCount.hasNextLine()) {
                tripCount.nextLine();
                numTrips++;
            }
        }

        this.trips = new Trip[numTrips];
        try (Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNextLine()) {
                Trip trips = new Trip(input.next(), input.next(), input.nextInt());
                addTrip(trips);

                try {
                    input.nextLine();
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

    public void addTrip(Trip trip) {
        this.trips[this.tripNum] = trip;
        this.tripNum++;
    }

    public void printDepartureSchedule(String outputPath) {
        for (int i = 0; i < numTrips; i++) {
            Io.writeToFile(outputPath, trips[i].departureToString(), true, true);
        }
    }

    public void printArrivalSchedule(String outputPath) {
        for (int i = 0; i < numTrips; i++) {
            Io.writeToFile(outputPath, trips[i].arrivalToString(), true, true);
        }
    }
}