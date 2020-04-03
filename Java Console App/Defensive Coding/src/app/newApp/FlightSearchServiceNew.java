package app.newApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import app.Flight;
import app.FlightStore;
import app.FlightStoreImpl;

public class FlightSearchServiceNew {
    
    private FlightStore flightStore;

    public FlightSearchServiceNew(FlightStore store) {
        this.flightStore = store;
    }

    public List<Flight> search(SearchRequest request) {
        List<Flight> flights = flightStore.getFlights();

        return flights.stream()
                .filter(f -> f.getFromDest().equals(request.getFromDestination()))
                .filter(f -> f.getToDest().equals(request.getToDestination()))
                .filter(f -> LocalDate.parse(f.getDate(), 
                DateTimeFormatter.ofPattern("dd-MM-yyyy")).equals(request.getDepartDate()))
                .filter(f -> f.getSeatsAvailable() >= request.getPassengerNum())
                .collect(Collectors.toList());
    }

    public static FlightSearchServiceNew flightSearch() {
        return new FlightSearchServiceNew(new FlightStoreImpl());
    }
}