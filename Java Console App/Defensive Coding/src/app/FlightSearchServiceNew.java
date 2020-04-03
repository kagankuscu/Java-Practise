package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchServiceNew {
    
    private FlightStore flightsStore;

    public FlightSearchServiceNew(FlightStore store) {
        this.flightsStore = store;
    }

    public List<Flight> search(SearchRequest request) {
        List<Flight> flights = flightsStore.getFlights();

        return flights.stream()
                .filter(f -> f.getFromDest().equals(request.getFromDestination()))
                .filter(f -> f.getToDest().equals(request.getToDestination()))
                .filter(f -> LocalDate.parse(f.getDate(), 
                DateTimeFormatter.ofPattern("dd-MM-yyyy")).equals(request.getDepartDate()))
                .filter(f -> f.getSeatsAvailable() >= request.getPassengerNum())
                .collect(Collectors.toList());
    }

    public static FlightSearchServiceNew flightSearch() {
        return new FlightSearchServiceNew(new FlightsStoreImpl());
    }
}