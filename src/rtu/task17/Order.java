package rtu.task17;

public interface Order {

    boolean add(Item item);

    String[] itemsNames();

    int itemsQuantity();

    int itemQuantity(String itemName);

    int itemQuantity(Item itemName);

    Item[] getItems();

    boolean remove(String itemName);

    boolean remove(Item itemName);

    int removeAll(String itemName);

    int removeAll(Item itemName);

    Item[] sortedItemsByCostDesc();

    int costTotal();

    Customer getCustomer();

    void setCustomer(Customer customer);
}