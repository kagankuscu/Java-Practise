package app.newApp;

import java.util.Arrays;
import java.util.List;

import app.Flight;

public class AppNew {
    public static void main(String[] args) {
        SearchRequest request = new SearchRequest(args);

        FlightSearchServiceNew searchService = FlightSearchServiceNew.flightSearch();

        List<Flight> outboundFlights = searchService.search(request);

        displayFligths(outboundFlights);
    }

    private static void displayFligths(List<Flight> outboundFlights) {
        if (outboundFlights.size() == 0) {
            System.out.println("No flights found your search criteria.");
        } else {
            System.out.println("Flights found:");
            System.out.println(Arrays.toString(outboundFlights.toArray()));
        }
    }
}