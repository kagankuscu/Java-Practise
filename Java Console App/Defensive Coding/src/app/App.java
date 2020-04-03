package app;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        int passengerNum = Integer.parseInt(args[0]);
        String departDate = args[1];
        String fromDestination = args[2];
        String toDestination = args[3];

        FlightSearchService searchService = FlightSearchService.flightSearch();

        List<Flight> outboundFlights = searchService.search(fromDestination, toDestination, departDate, passengerNum);

        displayFligths(outboundFlights);
    }

    private static void displayFligths(List<Flight> outbounFlights) {
        if (outbounFlights.size() == 0) {
            System.out.println("No flights found your search criteria.");
        } else {
            System.out.println("Flights found:");
            System.out.println(Arrays.toString(outbounFlights.toArray()));
        }
    }

}