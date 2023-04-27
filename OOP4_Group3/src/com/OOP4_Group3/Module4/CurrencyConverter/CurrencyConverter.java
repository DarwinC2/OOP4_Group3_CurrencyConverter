package com.OOP4_Group3.Module4.CurrencyConverter;

//****** GROUP MEMBERS *******//
//Darwin Dallas -        2101012479
//Althea Johnson-Roach - 2101012491
//Glen Brown -           2101011317
//Kemoy Gallimore -      2017002408
//David Samuels -        2101012913

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JPanel panelMain;
    private JLabel Input;
    private JLabel CurrencyType;
    private JLabel JMD;
    private JTextField txtBxInput;
    private JComboBox comboBoxCurrency;
    private JTextField txtBxJMdDisplay;
    private JButton btnClear;
    private JButton btnConvert;


    public CurrencyConverter() {
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double result = 0;
                double amount = 0;
                String fromCurrency = comboBoxCurrency.getSelectedItem().toString();


                if (!txtBxInput.getText().isEmpty() && txtBxInput.getText().matches("\\d+(\\.\\d+)?")) {
                    amount = Double.parseDouble(txtBxInput.getText());

                    switch (fromCurrency) {
                        case "USD":
                            result = amount * 129.02;
                            break;
                        case "CAN":
                            result = amount * 97.50;
                            break;
                        case "EURO":
                            result = amount * 164.33;
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(panelMain, "Invalid input. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                txtBxJMdDisplay.setText(String.valueOf(result));
            }
        });
        btnClear.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e){

                txtBxInput.setText("");
                txtBxJMdDisplay.setText("");
                comboBoxCurrency.setSelectedItem("USD");

            }
        });
    }




    public static void main(String[] args) {
        CurrencyConverter C = new CurrencyConverter();
        C.setContentPane(C.panelMain);
        C.setTitle("Currency Converter");
        C.setSize(300,200);
        C.setVisible(true);
        C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

