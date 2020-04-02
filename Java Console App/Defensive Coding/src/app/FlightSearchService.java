package app;

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
        
        if (passengerNum < 1 || passengerNum > 7) {
            throw new IllegalArgumentException("The number of passeger must be between 1 and 7");
        }

        List<Flight> flights = flightStore.getFlights();
        
        return flights.stream()
                .filter(f -> fromDest.equals(f.getFromDest()))
                .filter(f -> f.getToDest().equals(toDest))
                .filter(f -> f.getDate().equals(departDate))
                .filter(f -> f.getSeatsAvailable() >= passengerNum)
                .collect(Collectors.toList());
    }

    private Boolean isNotValidString(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static FlightSearchService flightSearch() {
        return new FlightSearchService(new FlightsStoreImpl());
    }
}
