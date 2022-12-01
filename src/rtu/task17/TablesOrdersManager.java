package rtu.task17;

import java.util.ArrayList;
import java.util.HashMap;

public class TablesOrdersManager {
    // The map of orders, where key is table number and value is the order
    private HashMap<Integer, RestaurantOrder> orders = new HashMap<>();

    private int tablesAmount;

    public TablesOrdersManager(int tablesCount) {
        this.tablesAmount = tablesCount;
    }

    public void add(RestaurantOrder order, int tableNumber) {
        orders.put(tableNumber, order);
    }

    public RestaurantOrder getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void addDish(Dish dish, int tableNumber) {
        RestaurantOrder order = orders.get(tableNumber);
        if (order == null) {
            order = new RestaurantOrder();
            orders.put(tableNumber, order);
        }
        order.add(dish);
    }

    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
    }

    public int getFreeTableNumber() {
        for (int i = 0; i < tablesAmount; i++) {
            if (!orders.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> getFreeTableNumbers() {
        ArrayList<Integer> freeTables = new ArrayList<>();
        for (int i = 0; i < tablesAmount; i++) {
            if (!orders.containsKey(i)) {
                freeTables.add(i);
            }
        }
        return freeTables;
    }

    public int getTotalOrdersCost() {
        int sum = 0;
        for (RestaurantOrder order : orders.values()) {
            sum += order.getPrice();
        }
        return sum;
    }

    public int getItemsAmount(String itemName) {
        int amount = 0;
        for (RestaurantOrder order : orders.values()) {
            amount += order.getItemQuantity(itemName);
        }
        return amount;
    }

    public int getItemsAmount(Item item) {
        int quantity = 0;
        for (RestaurantOrder order : orders.values()) {
            quantity += order.getItemQuantity(item.getName());
        }
        return quantity;
    }

    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }

    public int getOrdersAmount() {
        return orders.size();
    }
}

