package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {
    private FlightStore flightStore;

    public FlightSearchService(FlightStore store) {
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum) {
        
        if (isNotValidString(fromDest) ||
            isNotValidString(toDest) ||
            isNotValidString(departDate) ){
                
            String msg = String.format("none of them cannot be null. fromDest: %s, toDest: %s, departDate: %s", fromDest, toDest, departDate);
            throw new IllegalArgumentException(msg);
        }

        if (fromDest.equalsIgnoreCase(toDest)) {
            throw new IllegalArgumentException("From to destination cannot be same. " + "You input " + fromDest);
        }

        LocalDate date = parseInputDate(departDate);
        
        if (passengerNum < 1 || passengerNum > 7) {
            throw new IllegalArgumentException("The number of passeger must be between 1 and 7");
        }

        List<Flight> flights = flightStore.getFlights();
        
        return flights.stream()
                .filter(f -> fromDest.equals(f.getFromDest()))
                .filter(f -> f.getToDest().equals(toDest))
                .filter(f -> LocalDate.parse(f.getDate(),DateTimeFormatter.ofPattern("dd-MM-yyy")).equals(date))
                .filter(f -> f.getSeatsAvailable() >= passengerNum)
                .collect(Collectors.toList());
    }

    private LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(String.format("Could not parse input date %s, " +
                                                "Please enter a date in format dd-MM-yyyy",departDate));
        }
        return date;
    }

    private Boolean isNotValidString(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static FlightSearchService flightSearch() {
        return new FlightSearchService(new FlightsStoreImpl());
    }
}
