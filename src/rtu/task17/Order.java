package rtu.task17;

public interface Order
{
    public boolean add(Item item);

    public boolean remove(Item item);

    public int removeAll(String name);

    public int getItemQuantity();

    public int getItemQuantity(String name);

    public Item[] getItems();

    public double getPrice();

    public String[] getItemNames();

    public String[] getSortedItems();
}
