package rtu.task32.Frames.MakeOrderFrame;


import rtu.task32.Application;
import rtu.task32.Order;

import javax.swing.*;

public abstract class MakeOrderFrame extends JFrame {
    private final Order order;
    private final JButton checkoutButton;

    public MakeOrderFrame(Order order){
        this.order = order;
        checkoutButton = new JButton("Checkout");
    }

    public abstract void run();
    public abstract boolean areFieldsCorrectlyFilled();

    protected void addComponentsToBox(Box box, JComponent[] components){
        for(var component : components){
            addComponentToBox(box, component);
        }
    }

    protected void addComponentsToBox(Box box, JComponent[][] components){
        for (JComponent[] component : components) {
            addComponentToBox(box, (JLabel) component[0], (JTextField) component[1]);
        }
    }

    protected void addComponentToBox(Box box, JComponent component){
        component.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        component.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        JPanel panel = new JPanel();
        panel.add(component);
        box.add(panel);
    }
    protected void addComponentToBox(Box box, JLabel label, JTextField textField){
        JPanel panel = new JPanel();
        panel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
        panel.add(textField);
        box.add(panel);
    }

    public JButton getCheckoutButton() {
        return checkoutButton;
    }

    public Order getOrder() {
        return order;
    }

    public void setApplication(Application application) {
        application.setMakeOrderFrame(this);
    }
}
