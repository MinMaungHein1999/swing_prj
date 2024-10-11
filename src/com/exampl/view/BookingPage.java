package com.exampl.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingPage {

    // Sample movies data
    String[][] moviesData = {
        {"Movie 1", "10:00 AM", "Cinema 1"},
        {"Movie 2", "12:00 PM", "Cinema 2"},
        {"Movie 3", "2:00 PM", "Cinema 3"}
    };
    
    public BookingPage() {
        JFrame frame = new JFrame("Movie Booking");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Create movie listing table
        String[] columns = {"Movie Name", "Time", "Cinema"};
        JTable moviesTable = new JTable(moviesData, columns);
        JScrollPane scrollPane = new JScrollPane(moviesTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Button to book seat
        JButton bookButton = new JButton("Select Movie & Book Seat");
        frame.add(bookButton, BorderLayout.SOUTH);
        
        // Action Listener for booking button
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = moviesTable.getSelectedRow();
                if (selectedRow != -1) {
                    String movieName = moviesData[selectedRow][0];
                    String showTime = moviesData[selectedRow][1];
                    String cinema = moviesData[selectedRow][2];
                    
                    // Move to available seat selection
                    new AvailableSeatsView(movieName, showTime, cinema);
                    frame.dispose();  // Close current frame
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a movie!");
                }
            }
        });
        
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }

}

