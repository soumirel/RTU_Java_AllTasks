package rtu.task32_my;

import javax.swing.*;
import java.awt.*;

public class DrinkPanel extends JPanel {
    private final JLabel itemQuantityLabel;
    private final JButton addButton;
    private final JButton removeButton;
    private final JPanel[] panels;
    private final String drinkName;
    private int drinkCount;
    private final int cost;
    private final int ROW_COUNT = 3;

    public DrinkPanel(String drinkName, int cost){
        this.drinkName = drinkName;
        this.cost = cost;
        itemQuantityLabel = new JLabel("0");
        addButton = new JButton("+");
        removeButton = new JButton("-");
        panels = new JPanel[ROW_COUNT];
    }

    public void run(){
        setLayout(new GridLayout(ROW_COUNT, 1));
        JLabel titleLabel = new JLabel(drinkName + ", " + cost);

        for(int i = 0; i<panels.length; i++){
            add(panels[i] = new JPanel());
        }

        panels[0].add(titleLabel);
        panels[1].add(removeButton);
        panels[1].add(addButton);
        panels[2].add(itemQuantityLabel);

        addButton.addActionListener(e -> {
            drinkCount++;
            updateLabel();
        });

        removeButton.addActionListener(e -> {
            drinkCount = drinkCount == 0 ? 0 : drinkCount - 1;
            updateLabel();
        });
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getCost() {
        return cost;
    }

    public void setDrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
        updateLabel();
    }

    public void setColor(Color color){
        for(JPanel panel : panels){
            panel.setBackground(color);
        }
    }

    private void updateLabel(){
        itemQuantityLabel.setText(String.valueOf(drinkCount));
    }
}
