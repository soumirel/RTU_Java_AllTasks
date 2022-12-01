package rtu.task31;

public interface Order {
    public boolean add(MenuItem item);

    public String[] itemsNames();

    public int itemQuantity(String itemName);

    public int itemQuantity(MenuItem menuItem);

    public MenuItem[] getItems();

    public boolean remove(String itemName);

    public boolean remove(MenuItem menuItem);

    public boolean removeAll(String itemName);

    public boolean removeAll(MenuItem menuItem);
}
