package com.exampl.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JFrame frame;
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passLabel;
    private JPasswordField passField;
    private JButton loginButton;
    private JButton resetButton;

    public LoginWindow() {
        initializeComponents();
        setupLayout();
        setupLoginButtonAction();
        setupResetButtonAction();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initializeComponents() {
        this.frame = new JFrame("Login Window");
        this.userLabel = new JLabel("Username:");
        this.userTextField = new JTextField(15);
        this.passLabel = new JLabel("Password:");
        this.passField = new JPasswordField(15);
        this.loginButton = new JButton("Login");
        this.resetButton = new JButton("Reset");
    }

    // Sets up the layout of the components on the frame
    private void setupLayout() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add username label and text field
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(userLabel, constraints);

        constraints.gridx = 1;
        frame.add(userTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(passLabel, constraints);

        constraints.gridx = 1;
        frame.add(passField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(loginButton, constraints);

        constraints.gridx = 1;
        frame.add(resetButton, constraints);
    }

    private void setupLoginButtonAction() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  String username = userTextField.getText();
                  String password = new String(passField.getPassword());

             
                  if (username.equals("admin") && password.equals("password")) {
                  	  username = userTextField.getText();
                        password = new String(passField.getPassword());

                       // Simple validation
                       if (username.equals("admin") && password.equals("password")) {
                           JOptionPane.showMessageDialog(frame, "Login successful!");

                           
                           openHomePage();
                           

                           frame.dispose();
                       } else {
                           JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                       }
                  } else {
                      JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                  }
            }
        });
    }

    private void setupResetButtonAction() {
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                passField.setText("");
            }
        });
    }
    
    private void openHomePage() {
        HomePage homePage = new HomePage();
        homePage.showHomePage();
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
