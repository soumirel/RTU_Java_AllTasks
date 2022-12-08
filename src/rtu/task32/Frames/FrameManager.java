package rtu.task32.Frames;


import rtu.task32.Application;
import rtu.task32.Frames.MakeOrderFrame.MakeInternetOrderFrame;
import rtu.task32.Frames.MakeOrderFrame.MakeOrderFrame;
import rtu.task32.Frames.MakeOrderFrame.MakeTableOrderFrame;
import rtu.task32.InternetOrder;
import rtu.task32.Order;

public class FrameManager {
    private static Application application;
    private OrdersMenuFrame ordersMenuFrame;
    private static NewOrderFrame newOrderFrame;

    public FrameManager(Application application){
        FrameManager.application = application;
        ordersMenuFrame = new OrdersMenuFrame();
    }

    public static MakeOrderFrame createMakeOrderFrame(Order order){
        MakeOrderFrame frame;
        if(order instanceof InternetOrder){
            frame = new MakeInternetOrderFrame(order);
            ((MakeInternetOrderFrame)frame).setInternetOrdersManager(application.getInternetOrdersManager());
        }
        else{
            frame = new MakeTableOrderFrame(order);
            ((MakeTableOrderFrame)frame).setTableOrdersManager(application.getTableOrdersManager());
        }

        frame.setApplication(application);
        return frame;
    }

    public static void setNewOrderFrame(NewOrderFrame newOrderFrame){
        FrameManager.newOrderFrame = newOrderFrame;
    }

    public OrdersMenuFrame getOrdersMenuFrame() {
        return ordersMenuFrame;
    }

    public void updateOrdersMenuFrame(Order[] orders, int cost, int quantity){
        newOrderFrame.dispose();
        ordersMenuFrame.dispose();
        ordersMenuFrame = new OrdersMenuFrame();
        ordersMenuFrame.run(orders, cost, quantity);
    }
}
