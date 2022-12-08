package rtu.task32.Frames;

import rtu.task32.InternetOrder;
import rtu.task32.Order;
import rtu.task32.TableOrder;

import javax.swing.*;
import java.awt.*;

public class OrdersMenuFrame extends JFrame {
    public void run(Order[] orders, int costSummary, int ordersQuantity){
        final int WIDTH = 520;
        final int HEIGHT = 500;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMenu();

        int orderNumber = 1;

        if(orders != null){
            setLayout(new GridLayout(5, 5));

            for(int i = 0; i<20; i++){
                if(i<orders.length)
                   add(new JButton("Заказ №"+orderNumber++));
                else add(new JPanel());
            }
            add(new JLabel("Суммарно: " + costSummary));
            add(new JLabel("Orders quantity: " + ordersQuantity));
        }

        setVisible(true);
    }
    private void setMenu(){
        final String NEW_ORDER = "New order";
        final String TABLE_ORDER = "Table order";
        final String INTERNET_ORDER = "Internet order";

        JMenuBar menuBar = new JMenuBar();
        JMenu newOrderItem = new JMenu(NEW_ORDER);

        JMenuItem tableOrderItem = new JMenuItem(TABLE_ORDER);
        JMenuItem internetOrderItem = new JMenuItem(INTERNET_ORDER);

        tableOrderItem.addActionListener(e -> {
            new NewOrderFrame(new TableOrder()).run();
        });

        internetOrderItem.addActionListener(e -> {
            new NewOrderFrame(new InternetOrder()).run();
        });

        newOrderItem.add(tableOrderItem);
        newOrderItem.add(internetOrderItem);

        menuBar.add(newOrderItem);

        setJMenuBar(menuBar);
    }
}
