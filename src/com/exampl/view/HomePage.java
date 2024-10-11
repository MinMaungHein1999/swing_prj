package com.exampl.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    private JFrame homeFrame;

    public void showHomePage() {
        homeFrame = new JFrame("Cinema Ticket Booking System");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(600, 400);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "Booking" menu
        JMenu bookingMenu = new JMenu("Booking");
        JMenuItem bookTicketItem = new JMenuItem("Book Ticket");
        JMenuItem viewMoviesItem = new JMenuItem("Movies");
        JMenuItem purchaseHistoryItem = new JMenuItem("Purchase History");

        // Add menu items to the booking menu
        bookingMenu.add(bookTicketItem);
        bookingMenu.add(viewMoviesItem);
        bookingMenu.add(purchaseHistoryItem);

        // Add booking menu to the menu bar
        menuBar.add(bookingMenu);

        // Add action listeners for the menu items
        bookTicketItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage();
            }
        });

        viewMoviesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(homeFrame, "Show list of available movies");
            }
        });

        purchaseHistoryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(homeFrame, "Show ticket purchase history");
            }
        });

        // Set the menu bar to the frame
        homeFrame.setJMenuBar(menuBar);

        // Show the home page
        homeFrame.setVisible(true);
    }
}
