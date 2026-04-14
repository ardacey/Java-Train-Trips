# Java Train Trips Scheduler

A small Java CLI application that reads train trip definitions, calculates arrival times, and generates a sorted schedule report.

## Features

- Reads trips from a text file (`tripCode departureTime durationInMinutes`)
- Calculates arrival time for each trip
- Sorts and prints:
  - departure order
  - arrival order
- Marks trips as `DELAYED` when two trips share the same departure or arrival time
- Writes results to a report file

## Project Structure

- `Main.java`: command-line entry point
- `Trip.java`: trip model and time calculations
- `TripSchedule.java`: file parsing and schedule printing
- `TripController.java`: sorting and delay detection logic
- `ArrivalController.java`, `DepartureController.java`: controller interfaces
- `Io.java`: output file helpers
- `examples/sample-trips.txt`: sample input data

## Requirements

- Java 8+

## Build

```bash
javac *.java
```

## Run

```bash
java Main <input-file> [output-file]
```

Examples:

```bash
java Main examples/sample-trips.txt
java Main examples/sample-trips.txt trip_report.txt
```

If `output-file` is not provided, the default file is `trip_report.txt`.

## Input Format

Each line in the input file must follow:

```text
<tripName> <HH:mm> <durationMinutes>
```

Example:

```text
TR100 10:10 70
TR200 10:20 15
TR300 11:25 90
```

## Output

The report includes two sections:

- `Departure order:`
- `Arrival order:`

Each line displays trip code, time, and state (`IDLE` or `DELAYED`).

## Notes

- This project is intentionally dependency-free and uses only Java standard library classes.
- Time values use 24-hour format (`HH:mm`).