package com.exampl.view;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

class AvailableSeatsView {

    public AvailableSeatsView(String movieName, String showTime, String cinema) {
        JFrame frame = new JFrame("Available Seats - " + movieName);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Display movie details
        JLabel movieDetailsLabel = new JLabel("Movie: " + movieName + " | Time: " + showTime + " | Cinema: " + cinema);
        frame.add(movieDetailsLabel, BorderLayout.NORTH);

        // Available seats in a simple 2D array format (A1, A2, B1, B2, ...)
        String[] seats = {"A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4"};
        JList<String> seatsList = new JList<>(seats);
        seatsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(seatsList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button to confirm seat booking
        JButton confirmButton = new JButton("Confirm Booking");
        frame.add(confirmButton, BorderLayout.SOUTH);

        confirmButton.addActionListener(e -> {
            java.util.List<String> selectedSeats = seatsList.getSelectedValuesList();
            if (selectedSeats.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please select at least one seat!");
            } else {
                JOptionPane.showMessageDialog(frame, "Seats booked: " + selectedSeats);
                frame.dispose();  // Close the seat selection frame
            }
        });

        frame.setVisible(true);
    }
}
