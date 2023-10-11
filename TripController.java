import java.util.Arrays;
import java.util.Comparator;

public class TripController implements ArrivalController, DepartureController {

    public TripController(TripSchedule trip_schedule) {
        this.DepartureSchedule(trip_schedule);
        this.ArrivalSchedule(trip_schedule);
    }

    @Override
    public void DepartureSchedule(TripSchedule trip_schedule){
        Comparator<Trip> byDeparture = Comparator.comparing(Trip::getDepartureTime);
        Io.writeToFile(Main.output, "Departure order:", true, true );
        Arrays.sort(trip_schedule.trips, byDeparture);
        for (int i = 0; i < trip_schedule.numTrips - 1; i++)
            if (trip_schedule.trips[i].getDepartureTime().equals(trip_schedule.trips[i + 1].getDepartureTime())) {
                trip_schedule.trips[i].setState("DELAYED");
                trip_schedule.trips[i + 1].setState("DELAYED");
            }
        trip_schedule.printDepartureSchedule();
    }

    @Override
    public void ArrivalSchedule(TripSchedule trip_schedule) {
        Comparator<Trip> byArrival = Comparator.comparing(Trip::getArrivalTime);
        Io.writeToFile(Main.output, "\nArrival order:", true, true );
        Arrays.sort(trip_schedule.trips, byArrival);
        for (int i = 0; i < trip_schedule.numTrips - 1; i++)
            if (trip_schedule.trips[i].getArrivalTime().equals(trip_schedule.trips[i + 1].getArrivalTime())) {
                trip_schedule.trips[i].setState("DELAYED");
                trip_schedule.trips[i + 1].setState("DELAYED");
            }
        trip_schedule.printArrivalSchedule();
    }
}