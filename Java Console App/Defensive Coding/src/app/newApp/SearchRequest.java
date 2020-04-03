package app.newApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SearchRequest {

    private int passengerNum;
    private LocalDate departDate;
    private String fromDestination;
    private String toDestination;

    public SearchRequest(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("There should be exactly 4 arguments provided.");
        }

        this.passengerNum = validatePassengerNum(args[0]);
        this.departDate = validateDate(args[1]);
        this.fromDestination = isInvalidString(args[2]);
        this.toDestination = isInvalidString(args[3]);
    }

    private int validatePassengerNum(String inputPassenger) {
        int passengerNum = Integer.parseInt(inputPassenger);
        if (passengerNum < 1 || passengerNum > 7) {
            throw new IllegalArgumentException("The number of passenger must be between 1 and 7");
        }
        return passengerNum;
    }

    private LocalDate validateDate(String stringDate) {
        String date = isInvalidString(stringDate);
        return parseInputDate(date);
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

    private String isInvalidString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("You have provided the following argument," +
                    "but it cannot be null or empty" + s);
        }
        return s;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    
}