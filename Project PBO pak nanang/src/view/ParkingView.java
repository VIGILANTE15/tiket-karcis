package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ParkingView extends JFrame {
    private JTextField vehicleNumberField;
    private JComboBox<String> transportTypeComboBox;
    private JButton generateTicketButton;
    private JButton calculateFeeButton;
    private JButton listTicketsButton;
    private JTextArea resultArea;

    public ParkingView() {
        setTitle("Parking Ticket System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nomor Kendaraan:"));
        vehicleNumberField = new JTextField();
        inputPanel.add(vehicleNumberField);

        inputPanel.add(new JLabel("Tipe Kendaraan:"));
        transportTypeComboBox = new JComboBox<>(new String[]{"Mobil", "Motor"});
        inputPanel.add(transportTypeComboBox);

        generateTicketButton = new JButton("Buat Karcis");
        calculateFeeButton = new JButton("Total Pembayaran");
        listTicketsButton = new JButton("List Tickets");

        inputPanel.add(generateTicketButton);
        inputPanel.add(calculateFeeButton);
        inputPanel.add(new JLabel());
        inputPanel.add(listTicketsButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    public String getVehicleNumber() {
        return vehicleNumberField.getText();
    }

    public String getTransportType() {
        return (String) transportTypeComboBox.getSelectedItem();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addGenerateTicketListener(ActionListener listener) {
        generateTicketButton.addActionListener(listener);
    }

    public void addCalculateFeeListener(ActionListener listener) {
        calculateFeeButton.addActionListener(listener);
    }

    public void addListTicketsListener(ActionListener listener) {
        listTicketsButton.addActionListener(listener);
    }
}