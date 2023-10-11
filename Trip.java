import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Trip {
    public String tripName;
    public Date departureTime;
    public Date arrivalTime;
    public int duration;
    public String state;

    public Trip(String tripName, String departureTime, int duration) throws ParseException {
        this.tripName = tripName;
        DateFormat df = new SimpleDateFormat("HH:mm");
        this.departureTime = df.parse(departureTime);
        this.duration = duration;

        this.state = "IDLE";

        calculateArrival();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void calculateArrival() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.departureTime);
        cal.add(Calendar.MINUTE, this.duration);

        this.arrivalTime = cal.getTime();
    }

    public String departureToString() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        return tripName +
                " depart at " + df.format(departureTime) + "\t" +
                "Trip State:" + state;
    }

    public String arrivalToString() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        return tripName +
                " arrive at " + df.format(arrivalTime) + "\t" +
                "Trip State:" + state;
    }
}