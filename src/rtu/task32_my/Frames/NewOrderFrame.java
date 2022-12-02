package rtu.task32_my.Frames;

import rtu.task32_my.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewOrderFrame extends JFrame {
    private final Order order;
    private final JLabel costLabel;

    private final JButton makeOrderButton;
    private DrinkPanel selectedPanel;
    private final Color defaultColor;

    public NewOrderFrame(Order order) {
        this.order = order;
        costLabel = new JLabel("Cost total: 0");
        defaultColor = UIManager.getColor("Panel.background");
        makeOrderButton = new JButton("Making order");
    }

    public void run() {
        final int WIDTH = 650;
        final int HEIGHT = 600;
        final int PANELS_COUNT = 25;

        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(5, 5));
        setResizable(false);
        setTitle("New order");

        JButton removeAllButton = new JButton("Remove all");

        FrameManager.setNewOrderFrame(this);

        makeOrderButton.addActionListener(e -> {
            FrameManager.createMakeOrderFrame(order).run();
        });

        removeAllButton.addActionListener(e -> {
            if (selectedPanel != null) {
                selectedPanel.setDrinkCount(0);
                order.removeAll(selectedPanel.getDrinkName());
                deselectSelectedDrinkPanel();
            }
        });

        DrinkTypeEnum[] drinkTypes = DrinkTypeEnum.values();
        JPanel[] panels = new JPanel[PANELS_COUNT];
        int index = 0;

        for (int i = 0; i < PANELS_COUNT; i++) {
            panels[i] = new JPanel();

            if (i < drinkTypes.length) {
                if ((order instanceof TableOrder) || (order instanceof InternetOrder && drinkTypes[i].getAlcoholVol() == 0)) {
                    DrinkPanel panel = new DrinkPanel(drinkTypes[i].name(), (i + 1) * 10);
                    setUpDrinkPanel(panel, drinkTypes[i]);
                    panel.run();
                    panels[index++].add(panel);
                }
            }
            add(panels[i]);
        }

        panels[drinkTypes.length + 3].add(removeAllButton);
        panels[drinkTypes.length + 4].add(makeOrderButton);
        panels[drinkTypes.length + 5].add(costLabel);

        setVisible(true);
    }

    private void setUpDrinkPanel(DrinkPanel panel, DrinkTypeEnum currentDrinkType) {
        panel.getAddButton().addActionListener(e -> {
            order.add(new Drink(currentDrinkType, currentDrinkType.getAlcoholVol(), panel.getCost()));
            selectDrinkPanel(panel);
            updateCostLabel();
        });
        panel.getRemoveButton().addActionListener(e -> {
            order.remove(currentDrinkType.name());
            selectDrinkPanel(panel);
            updateCostLabel();
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectDrinkPanel(panel);
            }
        });
    }

    private void selectDrinkPanel(DrinkPanel panel) {
        if (selectedPanel != null)
            selectedPanel.setColor(defaultColor);
        selectedPanel = panel;
        selectedPanel.setColor(Color.cyan);
    }

    private void deselectSelectedDrinkPanel() {
        selectedPanel.setColor(defaultColor);
        selectedPanel = null;
        updateCostLabel();
    }

    private void updateCostLabel() {
        costLabel.setText("Cost total: " + order.getPrice());
    }
}