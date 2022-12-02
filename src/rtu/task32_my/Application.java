package rtu.task32_my;

import rtu.task32_my.Frames.FrameManager;
import rtu.task32_my.Frames.MakeOrderFrame.MakeOrderFrame;


public class Application {
    private final InternetOrdersManager internetOrdersManager;
    private final TableOrdersManager tableOrdersManager;
    private final FrameManager frameManager;

    public Application() {
        frameManager = new FrameManager(this);
        tableOrdersManager = new TableOrdersManager(10);
        internetOrdersManager = new InternetOrdersManager();
    }

    public void setMakeOrderFrame(MakeOrderFrame frame) {
        frame.getCheckoutButton().addActionListener(e -> {
            Order order = frame.getOrder();
            if (order.getCustomer() == null) {
                return;
            }
            if (order instanceof InternetOrder) {
                internetOrdersManager.add(order);
            } else {
                tableOrdersManager.add(order, order.getCustomer().getAddress().getApartmentNumber());
            }

            Order[] orders = new Order[internetOrdersManager.ordersQuantity() + tableOrdersManager.ordersQuantity()];
            int index = 0;
            for (Order internetOrder : internetOrdersManager.getOrders()) {
                orders[index++] = internetOrder;
            }
            for (Order tableOrder : tableOrdersManager.getOrders()) {
                if (tableOrder != null) {
                    orders[index++] = tableOrder;
                }
            }
            int costSummary = internetOrdersManager.ordersCostSummary() + tableOrdersManager.ordersCostSummary();
            int quantity = internetOrdersManager.ordersQuantity() + tableOrdersManager.ordersQuantity();
            frameManager.updateOrdersMenuFrame(orders, costSummary, quantity);
        });
    }

    public void run() {
        frameManager.getOrdersMenuFrame().run(null, 0, 0);
    }

    public TableOrdersManager getTableOrdersManager() {
        return tableOrdersManager;
    }

    public InternetOrdersManager getInternetOrdersManager() {
        return internetOrdersManager;
    }
}
