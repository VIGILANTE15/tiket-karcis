package controllers;

import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

import view.ParkingView;
import models.ParkingTicket;
import models.Transportasi;
import models.Mobil;
import models.Motor;

public class ParkingController {
    private ParkingView view;
    private Map<String, ParkingTicket> tickets;
    private int ticketCounter = 1;

    public ParkingController(ParkingView view) {
        this.view = view;
        this.tickets = new HashMap<>();

        this.view.addGenerateTicketListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vehicleNumber = view.getVehicleNumber();
                String transportType = view.getTransportType();

                if (vehicleNumber.isEmpty()) {
                    view.setResult("Harap Masukkan Nomor Kendaraan dengan benar.");
                    return;
                }

                Transportasi transportasi;
                if (transportType.equals("Mobil")) {
                    transportasi = new Mobil(vehicleNumber);
                } else {
                    transportasi = new Motor(vehicleNumber);
                }

                ParkingTicket ticket = new ParkingTicket(ticketCounter++, transportasi);
                tickets.put(ticket.getTicketId(), ticket);
                view.setResult("Ticket Dibuat:\nTicket ID: " + ticket.getTicketId() + "\nNomor Kendaraan: " + vehicleNumber + "\nTipe Kendaraan: " + transportasi.getJenisTransportasi() + "\nEntry Time: " + ticket.getFormattedEntryTime());
            }
        });

        this.view.addCalculateFeeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vehicleNumber = view.getVehicleNumber();
                ParkingTicket ticket = tickets.values().stream()
                        .filter(t -> t.getTransportasi().getNomorKendaraan().equals(vehicleNumber))
                        .findFirst()
                        .orElse(null);
                if (ticket == null) {
                    view.setResult("Ticket tidak ditemukan: " + vehicleNumber);
                    return;
                }
                ticket.setExitTime(System.currentTimeMillis());
                double fee = ticket.calculateFee();
                view.setResult("Ticket ID: " + ticket.getTicketId() +
                        "\nNomor Kendaraan: " + ticket.getTransportasi().getNomorKendaraan() +
                        "\nTipe Kendaraan: " + ticket.getTransportasi().getJenisTransportasi() +
                        "\nEntry Time: " + ticket.getFormattedEntryTime() +
                        "\nExit Time: " + ticket.getFormattedExitTime() +
                        "\nTotal Pembayaran: " + fee + "Rp");
            }
        });

        this.view.addListTicketsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tickets.isEmpty()) {
                    view.setResult("Ticket tidak tersedia.");
                    return;
                }
                String result = tickets.values().stream()
                        .map(t -> "Ticket ID: " + t.getTicketId() + ", Kendaraan: " + t.getTransportasi().getNomorKendaraan() + ", Tipe: " + t.getTransportasi().getJenisTransportasi() + ", Entry: " + t.getFormattedEntryTime())
                        .collect(Collectors.joining("\n"));
                view.setResult(result);
            }
        });
    }
}