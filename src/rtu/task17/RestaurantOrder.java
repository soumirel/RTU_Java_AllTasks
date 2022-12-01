package rtu.task17;

import java.util.ArrayList;

public class RestaurantOrder implements Order {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int size;

    public boolean add(Item item) {
        if (item == null) {
            return false;
        }
        items.add(item);
        size++;
        return true;
    }

    public boolean remove(Item item) {
        if (item == null) {
            return false;
        }
        if (items.contains(item)) {
            items.remove(item);
            size--;
            return true;
        }
        return false;
    }

    public int removeAll(String name) {
        int removed = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                size--;
                removed++;
            }
        }
        return removed;
    }

    public int getItemQuantity() {
        return size;
    }

    public int getItemQuantity(String name) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public Item[] getItems() {
        Item[] itemsArray = new Item[size];
        for (int i = 0; i < size; i++) {
            itemsArray[i] = items.get(i);
        }
        return itemsArray;
    }

    public double getPrice() {
        double totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += items.get(i).getPrice();
        }
        return totalPrice;
    }

    public String[] getItemNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (!names.contains(items.get(i).getName())) {
                names.add(items.get(i).getName());
            }
        }
        String[] namesArray = new String[names.size()];
        return names.toArray(namesArray);
    }

    public String[] getSortedItems() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            names.add(items.get(i).getName());
        }
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.size() - 1; j++) {
                if (items.get(j).getPrice() < items.get(j + 1).getPrice()) {
                    String temp = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp);
                }
            }
        }
        String[] namesArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            namesArray[i] = names.get(i);
        }
        return namesArray;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += items.get(i).toString() + "\n";
        }
        return result;
    }
}

