package rtu.task31;

public interface Order
{
    public boolean add(MenuItem menuItem);

    public boolean remove(MenuItem menuItem);

    public int removeAll(String name);

    public int itemQuantity();

    public int itemQuantity(String name);

    public MenuItem[] getItems();

    public double getPrice();

    public String[] itemNames();

    public String[] getSortedItems();

    Customer getCustomer();

    void setCustomer(Customer customer);
}

