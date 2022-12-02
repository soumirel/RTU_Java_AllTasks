package rtu.task32_my.Frames.MakeOrderFrame;


import rtu.task32_my.*;

import javax.swing.*;
import java.util.ArrayList;

public class MakeTableOrderFrame extends MakeOrderFrame {
    private final JTextField firstNameField;
    private final JTextField secondNameField;
    private final JTextField ageField;
    private final JTextField tableNumberField;
    private TableOrdersManager tableOrdersManager;

    public MakeTableOrderFrame(Order order) {
        super(order);

        firstNameField = new JTextField(10);
        secondNameField = new JTextField(10);
        ageField = new JTextField(2);
        tableNumberField = new JTextField(3);
    }

    @Override
    public void run(){
        final int WIDTH = 350;
        final int HEIGHT = 400;

        Order order = getOrder();
        JButton checkoutButton = getCheckoutButton();

        setSize(WIDTH, HEIGHT);
        setResizable(false);

        Box box = Box.createVerticalBox();

        add(box);

        JLabel firstNameLabel = new JLabel("First name");
        JLabel secondNameLabel = new JLabel("Second name");
        JLabel ageLabel = new JLabel("Age");
        JLabel tableNumberLabel = new JLabel("Table number");
        JLabel costTotalLabel = new JLabel("Cost total: " + order.getPrice());

        JComponent[][] pairedComponents = new JComponent[][]{
                {firstNameLabel, firstNameField},
                {secondNameLabel, secondNameField},
                {ageLabel, ageField},
                {tableNumberLabel, tableNumberField}
        };

        JComponent[] singleComponents = new JComponent[]{
                costTotalLabel,
                checkoutButton
        };

        addComponentsToBox(box, pairedComponents);
        addComponentsToBox(box, singleComponents);

        checkoutButton.addActionListener(e -> {
            if(!areFieldsCorrectlyFilled()){
                return;
            }

            String firstName = firstNameField.getText();
            String secondName = secondNameField.getText();
            int age = Integer.parseInt(ageField.getText().equals("") ? "0" :ageField.getText());
            int tableNumber = Integer.parseInt(tableNumberField.getText().equals("") ? "0" :tableNumberField.getText());

            Address address = new Address(tableNumber);
            Customer customer = new Customer(firstName, secondName, age, address);
            order.setCustomer(customer);

            JOptionPane.showMessageDialog(this, "Ordered!");
            dispose();
        });

        setVisible(true);
    }

    @Override
    public boolean areFieldsCorrectlyFilled() {
        String firstName = firstNameField.getText();
        String secondName = secondNameField.getText();
        String age = ageField.getText();
        String tableNumber = tableNumberField.getText();

        if(firstName.isEmpty() || secondName.isEmpty() || age.isEmpty() || tableNumber.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill all the fields!");
            return false;
        }

        if(!age.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the age correctly!");
            return false;
        }

        if(!tableNumber.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the table number correctly!");
            return false;
        }

//        if(Integer.parseInt(tableNumber) >= tableOrdersManager.getOrders().length){
//            JOptionPane.showMessageDialog(this, "There are " + tableOrdersManager.getOrders().length
//                    + " tables: from 0 to " + (tableOrdersManager.getOrders().length - 1));
//            return false;
//        }

        ArrayList<Integer> freeTableNumbers = tableOrdersManager.freeTableNumbers();
        boolean isTableNumberFree = false;
        for(int freeTableNumber : freeTableNumbers){
            if(freeTableNumber == Integer.parseInt(tableNumber)){
                isTableNumberFree = true;
                break;
            }
        }

        if(!isTableNumberFree){
            JOptionPane.showMessageDialog(this, "The table "+tableNumber+" is not free!");
            return false;
        }

        boolean alcoholIsPresent = false;
        Order order = getOrder();
        for(var item : order.getItems()){
            if(item instanceof Drink && ((Drink)item).isAlcoholic()){
                alcoholIsPresent = true;
                break;
            }
        }
        if(alcoholIsPresent && Integer.parseInt(age)<18){
            JOptionPane.showMessageDialog(this, "You must be at least 18 years old to order alcoholic drinks!");
            return false;
        }

        return true;
    }

    public void setTableOrdersManager(TableOrdersManager tableOrdersManager){
        this.tableOrdersManager = tableOrdersManager;
    }
}
