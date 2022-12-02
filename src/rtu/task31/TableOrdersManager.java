package rtu.task31;

import java.util.ArrayList;
import java.util.HashMap;

public class TableOrdersManager implements OrdersManager {

    private HashMap<Integer, TableOrder> orders = new HashMap<>();

    private int tablesCount;


    public TableOrdersManager(int tablesCount) {
        this.tablesCount = tablesCount;
    }

    public TableOrdersManager() {
        this(10);
    }


    public void add(TableOrder order, int tableNumber) {
        orders.put(tableNumber, order);
    }


    public TableOrder getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void addDish(Dish dish, int tableNumber) {
        TableOrder order = orders.get(tableNumber);
        if (order == null) {
            order = new TableOrder();
            orders.put(tableNumber, order);
        }
        order.add(dish);
    }

    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
    }

    public int freeTableNumber() {
        for (int i = 0; i < tablesCount; i++) {
            if (!orders.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> freeTableNumbers() {
        ArrayList<Integer> freeTables = new ArrayList<>();
        for (int i = 0; i < tablesCount; i++) {
            if (!orders.containsKey(i)) {
                freeTables.add(i);
            }
        }
        return freeTables;
    }

    public int ordersCostSummary() {
        int sum = 0;
        for (TableOrder order : orders.values()) {
            sum += order.getPrice();
        }
        return sum;
    }

    public int itemsQuantity(String itemName) {
        int quantity = 0;
        for (TableOrder order : orders.values()) {
            quantity += order.itemQuantity(itemName);
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem menuItem) {
        int quantity = 0;
        for (TableOrder order : orders.values()) {
            quantity += order.itemQuantity(menuItem.getName());
        }
        return quantity;
    }

    @Override
    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }

    @Override
    public int ordersQuantity() {
        return orders.size();
    }
}

