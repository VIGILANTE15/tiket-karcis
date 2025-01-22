package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingTicket {
    private String ticketId;
    private Transportasi transportasi;
    private long entryTime;
    private long exitTime;
    private double parkingRate = 2000;

    public ParkingTicket(int ticketNumber, Transportasi transportasi) {
        this.ticketId = "TKT" + ticketNumber;
        this.transportasi = transportasi;
        this.entryTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Transportasi getTransportasi() {
        return transportasi;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public String getFormattedEntryTime() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(entryTime));
    }

    public String getFormattedExitTime() {
        return exitTime > 0 ? new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(exitTime)) : "N/A";
    }

    public double calculateFee() {
        long duration = exitTime - entryTime;
        double hours = Math.ceil(duration / (1000.0 * 60 * 60)); // Convert milliseconds to hours
        return hours * parkingRate;
    }
}
