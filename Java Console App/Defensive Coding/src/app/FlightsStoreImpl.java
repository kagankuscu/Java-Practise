package app;

import java.util.List;

public class FlightsStoreImpl implements FlightStore {

    @Override
    public List<Flight> getFlights() {
        return List.of(
            // date format DD-MM-YYYY
            new Flight("Boston","New York", "15-10-2020",50),
            new Flight("Boston","New York", "16-11-2020",10),
            new Flight("Boston","New York", "17-9-2020",1),


            new Flight("Boston","Washington", "15-10-2020",20),
            new Flight("Boston","Washington", "16-10-2020",7),
            new Flight("Boston","Washington", "17-10-2020",1)
            );
    }

}