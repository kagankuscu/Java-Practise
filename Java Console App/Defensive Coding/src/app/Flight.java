package app;

public class Flight {

    private String fromDest;
    private String toDest;
    private String date;
    private int seatsAvailable;

    public Flight(String fromDest, String toDest, String date, int seatsAvailable) {
        this.fromDest = fromDest;
        this.toDest = toDest;
        this.date = date;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFromDest() {
        return fromDest;
    }

    public void setFromDest(String fromDest) {
        this.fromDest = fromDest;
    }

    public String getToDest() {
        return toDest;
    }

    public void setToDest(String toDest) {
        this.toDest = toDest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    @Override
    public String toString() {
        return "From " + fromDest + ", to=" + toDest + ". Date:" + date + ". Available seats:" + seatsAvailable;
    }

}
