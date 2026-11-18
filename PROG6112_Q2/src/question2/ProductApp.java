package question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

// GUI Application - Q2.1 to Q2.4
public class ProductApp extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Q2.2 - Form controls
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        add(new JLabel("")); // Empty cell for layout
        btnProcess = new JButton("PROCESS");
        add(btnProcess);

        // Q2.4 - Menu 
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Q2.3 - Process logic (shared by button and menu)
        ActionListener processAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        };
        btnProcess.addActionListener(processAction);
        processItem.addActionListener(processAction);

        // Exit menu - closin the application
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Clear menu 
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerName.setText("");
                txtPrice.setText("");
                cmbProduct.setSelectedIndex(0);
            }
        });
    }

    // Method to process sale, show message and save to data.txt file
    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Showing popup message - matches sample screenshot
            String message = "Customer Name: " + customerName
                    + "\nProduct: " + productName
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Saving to data.txt - Q2.3
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("************************");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
            }
        });
    }
}