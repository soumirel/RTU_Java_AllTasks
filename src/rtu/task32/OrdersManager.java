package rtu.task32;

public interface OrdersManager
{
    int itemsQuantity(String itemName);

    int itemsQuantity(MenuItem menuItem);

    Order[] getOrders();

    int ordersQuantity();

    int ordersCostSummary();
}

