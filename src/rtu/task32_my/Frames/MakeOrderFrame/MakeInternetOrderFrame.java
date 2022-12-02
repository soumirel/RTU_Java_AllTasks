package rtu.task32_my.Frames.MakeOrderFrame;

import rtu.task32_my.Address;
import rtu.task32_my.Customer;
import rtu.task32_my.InternetOrdersManager;
import rtu.task32_my.Order;

import javax.swing.*;

public class MakeInternetOrderFrame extends MakeOrderFrame {
    private InternetOrdersManager internetOrdersManager;
    private final JTextField firstNameField;
    private final JTextField secondNameField;
    private final JTextField ageField;
    private final JTextField cityNameField;
    private final JTextField zipCodeField;
    private final JTextField streetNameField;
    private final JTextField buildingNumberField;
    private final JTextField buildingLetterField;
    private final JTextField apartmentNumberField;
    private final JCheckBox privatePolicyCheckBox;

    public MakeInternetOrderFrame(Order order) {
        super(order);

        firstNameField = new JTextField(10);
        secondNameField = new JTextField(10);
        ageField = new JTextField(2);
        cityNameField = new JTextField(15);
        zipCodeField = new JTextField(6);
        streetNameField = new JTextField(20);
        buildingNumberField = new JTextField(2);
        buildingLetterField = new JTextField(1);
        apartmentNumberField = new JTextField(3);
        privatePolicyCheckBox = new JCheckBox("I accept the terms of the privacy policy");
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
        JLabel cityNameLabel = new JLabel("City name");
        JLabel zipCodeLabel = new JLabel("Zip code");
        JLabel streetNameLabel = new JLabel("Street name");
        JLabel buildingNumberLabel = new JLabel("Building number");
        JLabel buildingLetterLabel = new JLabel("Building letter");
        JLabel apartmentNumberLabel = new JLabel("Apartment number");
        JLabel costTotalLabel = new JLabel("Cost total: " + order.getPrice());

        JComponent[][] pairedComponents = new JComponent[][]{
                {firstNameLabel, firstNameField},
                {secondNameLabel, secondNameField},
                {ageLabel, ageField},
                {cityNameLabel, cityNameField},
                {zipCodeLabel, zipCodeField},
                {streetNameLabel, streetNameField},
                {buildingNumberLabel, buildingNumberField},
                {buildingLetterLabel, buildingLetterField},
                {apartmentNumberLabel, apartmentNumberField}
        };

        JComponent[] singleComponents = new JComponent[]{
                privatePolicyCheckBox,
                costTotalLabel,
                checkoutButton
        };

        addComponentsToBox(box, pairedComponents);
        addComponentsToBox(box, singleComponents);

        checkoutButton.addActionListener(e -> {
            if(!areFieldsCorrectlyFilled()){
                return;
            }
            if(!privatePolicyCheckBox.isSelected()){
                JOptionPane.showMessageDialog(this, "Select the checkbox");
                return;
            }

            String firstName = firstNameField.getText();
            String secondName = secondNameField.getText();
            int age = Integer.parseInt(ageField.getText().equals("") ? "0" :ageField.getText());
            String cityName = cityNameField.getText();
            int zipCode = Integer.parseInt(zipCodeField.getText().equals("") ? "0" :zipCodeField.getText());
            String streetName = streetNameField.getText();
            int buildingNumber = Integer.parseInt(buildingNumberField.getText().equals("") ? "0" :buildingNumberField.getText());
            char buildingLetter = buildingLetterField.getText().equals("") ? 'A' : buildingLetterField.getText().charAt(0);
            int apartmentNumber = Integer.parseInt(apartmentNumberField.getText().equals("") ? "0" :apartmentNumberField.getText());

            Address address = new Address(cityName, zipCode, streetName, buildingNumber, buildingLetter, apartmentNumber);

            for(var o : internetOrdersManager.getOrders()){
                if(o.getCustomer().getAddress().equals(address)){
                    JOptionPane.showMessageDialog(this, "An order has already been placed at this address");
                    return;
                }
            }

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
        String cityName = cityNameField.getText();
        String zipCode = zipCodeField.getText();
        String streetName = streetNameField.getText();
        String buildingNumber = buildingNumberField.getText();
        String buildingLetter = buildingLetterField.getText();
        String apartmentNumber =apartmentNumberField.getText();

        if(firstName.isEmpty() || secondName.isEmpty()
                || age.isEmpty() || cityName.isEmpty()
                || zipCode.isEmpty() || streetName.isEmpty()
                || buildingNumber.isEmpty() || buildingLetter.isEmpty()
                || apartmentNumber.isEmpty()){
            JOptionPane.showMessageDialog(this, "Fill all the fields!");
            return false;
        }

        if(!age.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the age correctly!");
            return false;
        }

        if(!zipCode.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the zip code correctly!");
            return false;
        }

        if(!buildingNumber.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the building number correctly!");
            return false;
        }

        if(!buildingLetter.matches("[a-zA-Z]")){
            JOptionPane.showMessageDialog(this, "Enter the building number correctly!");
            return false;
        }

        if(!apartmentNumber.matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Enter the apartment number correctly!");
            return false;
        }

        return true;
    }

    public void setInternetOrdersManager(InternetOrdersManager internetOrdersManager) {
        this.internetOrdersManager = internetOrdersManager;
    }
}
